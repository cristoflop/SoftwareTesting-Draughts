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
    private Coordinate coordinate00;
    private Coordinate coordinate33;
    private Coordinate coordinate04;

    @Before
    public void before() {
        this.board = new Board();
        this.draughtWhite = new Draught(Color.WHITE);
        this.draughtBlack1 = new Draught(Color.BLACK);
        this.draughtBlack2 = new Draught(Color.BLACK);
        this.draughtBlack3 = new Draught(Color.BLACK);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate33 = new Coordinate(3, 3);
        this.coordinate04 = new Coordinate(0, 4);
    }

    @Test
    public void testGivenNewBoardWhenGetPieceInEmptyCoordinateThenReturnNull() {
        assertNull(this.board.getPiece(coordinate00));
    }

    @Test
    public void testGivenNewBoardWhenGetPieceInDraughtCoordinateThenReturnDraught() {
        this.board.put(coordinate00, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate00));
    }

    @Test
    public void testGivenNewBoardWhenRemoveDraughtThenReturnNullInThatCoordinate() {
        this.board.put(coordinate00, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate00));
        this.board.remove(coordinate00);
        assertNull(this.board.getPiece(coordinate00));
    }

    @Test
    public void testGivenNewBoardWhenMoveDraughtToOtherCoordinateThenReturnNullInPreviousCoordinate() {
        this.board.put(coordinate00, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate00));
        assertNull(this.board.getPiece(coordinate33));
        this.board.move(coordinate00, coordinate33);
        assertNull(this.board.getPiece(coordinate00));
    }

    @Test
    public void testGivenNewBoardWhenMoveDraughtToOtherCoordinateThenReturnTheDraughtInNewCoordinate() {
        this.board.put(coordinate00, this.draughtBlack1);
        assertNotNull(this.board.getPiece(coordinate00));
        assertNull(this.board.getPiece(coordinate33));
        this.board.move(coordinate00, coordinate33);
        assertNotNull(this.board.getPiece(coordinate33));
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesInDiagonalWhenGetThePiecesBetweenThatTwoCoordinatesThenReturnThePiecesBetweenThem() {
        this.board.put(new Coordinate(1, 1), draughtBlack1);
        this.board.put(new Coordinate(2, 2), this.draughtBlack2);
        List<Piece> pieces = this.board.getBetweenDiagonalPieces(this.coordinate00, this.coordinate33);
        assertTrue(pieces.size() > 0);
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesNotInDiagonalWhenGetThePiecesBetweenThatTwoCoordinatesThenReturnEmptyList() {
        this.board.put(new Coordinate(0, 2), this.draughtBlack3);
        List<Piece> pieces = this.board.getBetweenDiagonalPieces(this.coordinate00, this.coordinate04);
        assertTrue(pieces.isEmpty());
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesInDiagonalWhenGetTheAmountOfPiecesBetweenThatTwoCoordinatesThenReturnThePiecesAmountBetweenThem() {
        this.board.put(new Coordinate(1, 1), draughtBlack1);
        this.board.put(new Coordinate(2, 2), this.draughtBlack2);
        int pieces = this.board.getAmountBetweenDiagonalPieces(this.coordinate00, this.coordinate33);
        assertTrue(pieces > 0);
    }

    @Test
    public void testGivenNewBoardAndTwoCoordinatesNotInDiagonalWhenGetTheAmountOfPiecesBetweenThatTwoCoordinatesThenReturnZero() {
        this.board.put(new Coordinate(0, 2), this.draughtBlack3);
        int pieces = this.board.getAmountBetweenDiagonalPieces(this.coordinate00, this.coordinate04);
        assertEquals(0, pieces);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenGetTheColorOfThePieceInThatCoordinateThenReturnTheColorIfCoordinateIsNotEmpty() {
        this.board.put(this.coordinate00, this.draughtWhite);
        assertEquals(this.board.getColor(this.coordinate00), Color.WHITE);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenGetTheColorOfThePieceInThatCoordinateThenReturnNullIfCoordinateIsEmpty() {
        assertNull(this.board.getColor(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenGetTheColorOfThePieceInNullCoordinateThenExpectedAssertionError() {
        this.board.getColor(null);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenIsAnEmptyCoordinateThenReturnTrue() {
        boolean isEmpty = this.board.isEmpty(this.coordinate00);
        assertTrue(isEmpty);
    }

    @Test
    public void testGivenNewBoardAndCoordinateWhenIsNotAnEmptyCoordinateThenReturnFalse() {
        this.board.put(this.coordinate00, this.draughtWhite);
        boolean isEmpty = this.board.isEmpty(this.coordinate00);
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
        this.board.put(this.coordinate00, this.draughtBlack1);
        other.put(this.coordinate00, this.draughtBlack2);
        assertEquals(this.board, other);
    }

    @Test
    public void testGivenTwoBoardWhenCompareThemIfBothHaveNotTheSamePiecesInTheSamePositionThenReturnFalse() {
        Board other = new Board();
        this.board.put(this.coordinate00, this.draughtBlack1);
        other.put(this.coordinate33, this.draughtBlack2);
        assertNotEquals(this.board, other);
    }

}
