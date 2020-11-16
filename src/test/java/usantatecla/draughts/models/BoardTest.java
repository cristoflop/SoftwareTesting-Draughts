package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;
    private Piece draughtWhite;
    private Piece draughtBlack1;
    private Piece draughtBlack2;
    private Piece draughtBlack3;
    private Coordinate coordinate1;
    private Coordinate coordinate2;
    private Coordinate coordinate3;

    @Before
    public void before() {
        this.board = new Board();
        this.draughtWhite = new Draught(Color.WHITE);
        this.draughtBlack1 = new Draught(Color.BLACK);
        this.draughtBlack2 = new Draught(Color.BLACK);
        this.draughtBlack3 = new Draught(Color.BLACK);
        this.coordinate1 = new Coordinate(0, 0);
        this.coordinate2 = new Coordinate(3, 3);
        this.coordinate3 = new Coordinate(0, 4);
    }

    @Test
    public void testGivenNewBoardWhenGetPieceInEmptyCoordinateThenReturnNull() {
        assertNull(this.board.getPiece(coordinate1));
    }

    @Test
    public void testGivenNewBoardWhenGetPieceInDraughtCoordinateThenReturnDraught() {
        this.board.put(coordinate1, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate1));
    }

    @Test
    public void testGivenNewBoardWhenRemoveDraughtThenReturnNullInThatCoordinate() {
        this.board.put(coordinate1, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate1));
        this.board.remove(coordinate1);
        assertNull(this.board.getPiece(coordinate1));
    }

    @Test
    public void testGivenNewBoardWhenMoveDraughtToOtherCoordinateThenReturnNullInPreviousCoordinate() {
        this.board.put(coordinate1, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate1));
        assertNull(this.board.getPiece(coordinate2));
        this.board.move(coordinate1, coordinate2);
        assertNull(this.board.getPiece(coordinate1));
    }

    @Test
    public void testGivenNewBoardWhenMoveDraughtToOtherCoordinateThenReturnTheDraughtInNewCoordinate() {
        this.board.put(coordinate1, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate1));
        assertNull(this.board.getPiece(coordinate2));
        this.board.move(coordinate1, coordinate2);
        assertNotNull(this.board.getPiece(coordinate2));
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesInDiagonalWhenGetThePiecesBetweenThatTwoCoordinatesThenReturnThePiecesBetweenThem() {
        this.board.put(new Coordinate(1, 1), draughtBlack1);
        this.board.put(new Coordinate(2, 2), this.draughtBlack2);
        List<Piece> pieces = this.board.getBetweenDiagonalPieces(this.coordinate1, this.coordinate2);
        assertTrue(pieces.size() > 0);
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesNotInDiagonalWhenGetThePiecesBetweenThatTwoCoordinatesThenReturnEmptyList() {
        this.board.put(new Coordinate(0, 2), this.draughtBlack3);
        List<Piece> pieces = this.board.getBetweenDiagonalPieces(this.coordinate1, this.coordinate3);
        assertTrue(pieces.isEmpty());
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesInDiagonalWhenGetTheAmountOfPiecesBetweenThatTwoCoordinatesThenReturnThePiecesAmountBetweenThem() {
        this.board.put(new Coordinate(1, 1), draughtBlack1);
        this.board.put(new Coordinate(2, 2), this.draughtBlack2);
        int pieces = this.board.getAmountBetweenDiagonalPieces(this.coordinate1, this.coordinate2);
        assertTrue(pieces > 0);
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesNotInDiagonalWhenGetTheAmountOfPiecesBetweenThatTwoCoordinatesThenReturnZero() {
        this.board.put(new Coordinate(0, 2), this.draughtBlack3);
        int pieces = this.board.getAmountBetweenDiagonalPieces(this.coordinate1, this.coordinate3);
        assertEquals(0, pieces);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenGetTheColorOfThePieceInThatCoordinateThenReturnTheColorIfCoordinateIsNotEmpty() {
        this.board.put(this.coordinate1, this.draughtWhite);
        assertEquals(this.board.getColor(this.coordinate1), Color.WHITE);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenGetTheColorOfThePieceInThatCoordinateThenReturnNullIfCoordinateIsEmpty() {
        assertNull(this.board.getColor(this.coordinate1));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenGetTheColorOfThePieceInNullCoordinateThenExpectedAssertionError() {
        this.board.getColor(null);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenIsAnEmptyCoordinateThenReturnTrue() {
        boolean isEmpty = this.board.isEmpty(this.coordinate1);
        assertTrue(isEmpty);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenIsNotAnEmptyCoordinateThenReturnFalse() {
        this.board.put(this.coordinate1, this.draughtWhite);
        boolean isEmpty = this.board.isEmpty(this.coordinate1);
        assertFalse(isEmpty);
    }

    @Test
    public void testGivenNewBoardWhenGetTheStringOfTheBoardThenTheSizeOfTheStringIsBiggerThanZero() {
        String a = this.board.toString();
        assertTrue(a.length() > 0);
    }

    @Test
    public void testGivenTwoBoardWhenCompareThemIfTheyAreBothEmptyThenReturnTrue() {
        Board other = new Board();
        assertEquals(this.board, other);
    }

    @Test
    public void testGivenTwoBoardWhenCompareThemIfBothHaveTheSamePiecesInTheSamePositionThenReturnTrue() {
        Board other = new Board();
        this.board.put(this.coordinate1, this.draughtBlack1);
        other.put(this.coordinate1, this.draughtBlack2);
        assertEquals(this.board, other);
    }

    @Test
    public void testGivenTwoBoardWhenCompareThemIfBothHaveNotTheSamePiecesInTheSamePositionThenReturnFalse() {
        Board other = new Board();
        this.board.put(this.coordinate1, this.draughtBlack1);
        other.put(this.coordinate2, this.draughtBlack2);
        assertNotEquals(this.board, other);
    }

}
