package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private Game game2;
    private Game game3;

    private Coordinate coordinate21;
    private Coordinate coordinate23;
    private Coordinate coordinate32;
    private Coordinate coordinate54;
    private Coordinate coordinate43;
    private Coordinate coordinate67;
    private Coordinate coordinate65;

    @Before
    public void before() {
        this.game = new Game();
        this.coordinate21 = new Coordinate(2, 1);
        this.coordinate23 = new Coordinate(2, 3);
        this.coordinate32 = new Coordinate(3, 2);
        this.coordinate54 = new Coordinate(5, 4);
        this.coordinate43 = new Coordinate(4, 3);
        this.coordinate67 = new Coordinate(6, 7);
        this.coordinate65 = new Coordinate(6, 5);

        Coordinate coordinate45 = new Coordinate(4, 5);
        Coordinate coordinate14 = new Coordinate(1, 4);
        Coordinate coordinate10 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(1, 2);
        Coordinate coordinate03 = new Coordinate(0, 3);

        Board board = new Board();
        board.put(this.coordinate67, new Draught(Color.WHITE));
        board.put(this.coordinate54, new Pawn(Color.WHITE));
        board.put(this.coordinate32, new Pawn(Color.WHITE));
        board.put(coordinate14, new Draught(Color.BLACK));
        board.put(this.coordinate21, new Pawn(Color.BLACK));
        board.put(coordinate45, new Pawn(Color.BLACK));
        this.game2 = new Game(board);

        Board board2 = new Board();
        board2.put(coordinate10, new Pawn(Color.BLACK));
        board2.put(this.coordinate21, new Pawn(Color.WHITE));
        board2.put(coordinate12, new Pawn(Color.BLACK));
        board2.put(coordinate03, new Pawn(Color.BLACK));
        this.game3 = new Game(board2);
    }

    @Test
    public void testGivenGameWhenResetTheGameThenTheTurnColorIsWhite() {
        this.game.reset();
        assertEquals(this.game.getTurnColor(), Color.WHITE);
    }

    @Test
    public void testGivenGameWhenMoveFromCoordinateToOtherAndItIsPossibleThenReturnErrorNull() {
        Error error = this.game.move(this.coordinate54, this.coordinate43);
        assertNull(error);
    }

    @Test
    public void testGivenGameWhenMoveFromCoordinateToOtherAndThenOtherAndItIsNotPossibleThenReturnError() {
        Error error = this.game.move(this.coordinate54, this.coordinate43, this.coordinate32);
        assertEquals(error, Error.TOO_MUCH_JUMPS);
    }

    @Test
    public void testGivenGameWhenTryToMovePieceFromEmptyOriginThenReturnError() {
        Error error = this.game.move(this.coordinate32, this.coordinate43);
        assertEquals(error, Error.EMPTY_ORIGIN);
    }

    @Test
    public void testGivenGameWhenTurnIsWhiteAndTryToMoveBlackPieceThenReturnError() {
        Error error = this.game.move(this.coordinate21, this.coordinate32);
        assertEquals(error, Error.OPPOSITE_PIECE);
    }

    @Test
    public void testGivenGameWhenMovePawnAndCollectMoreThanOnePieceTheReturnErrorNull() {
        this.game2.move(this.coordinate67, this.coordinate23);
        Error error2 = this.game2.move(this.coordinate21, this.coordinate43, this.coordinate65);
        assertNull(error2);
    }

    @Test
    public void testGivenGameWhenCheckIfPlayerIsBlockedAndThereIsAPieceWhichCanMoveThenReturnFalse() {
        assertFalse(this.game2.isBlocked());
    }

    @Test
    public void testGivenGameWhenCheckIfPlayerIsBlockedAndThereIsNotPiecesWhichCanMoveThenReturnTrue() {
        assertTrue(this.game3.isBlocked());
    }

    @Test
    public void testGivenGameWhenPlayerCancelThenTurnIsForTheOtherPlayer() {
        this.game3.cancel();
        Color color = this.game3.getTurnColor();
        assertEquals(color, Color.BLACK);
    }

    @Test
    public void testGivenGameWhenGetTheColorOfNonEmptyCoordinateThenReturnTheColor() {
        assertEquals(this.game.getColor(this.coordinate21), Color.BLACK);
    }

    @Test
    public void testGivenGameWhenGetTheColorOfEmptyCoordinateThenReturnNull() {
        assertNull(this.game.getColor(this.coordinate32));
    }

    @Test
    public void testGivenGameWhenGetThePieceOfNonEmptyCoordinateThenReturnThePiece() {
        assertNotNull(this.game.getPiece(this.coordinate21));
    }

    @Test
    public void testGivenGameWhenGetThePieceOfEmptyCoordinateThenReturnNull() {
        assertNull(this.game.getPiece(this.coordinate32));
    }

}
