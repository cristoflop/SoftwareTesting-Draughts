package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PieceTest {

    protected Piece white1;
    protected Piece white2;
    protected Piece black1;
    protected Piece black2;

    protected Coordinate coordinate10;
    protected Coordinate coordinate32;
    protected Coordinate coordinate21;
    protected Coordinate coordinate43;
    protected Coordinate coordinate15;
    protected Coordinate coordinate65;
    protected Coordinate coordinate54;

    protected Coordinate coordinateInFirstRow;
    protected Coordinate coordinateInLastRow;

    @Before
    public void before() {
        this.white1 = new Draught(Color.WHITE);
        this.white2 = new Pawn(Color.WHITE);
        this.black1 = new Draught(Color.BLACK);
        this.black2 = new Draught(Color.BLACK);
        this.coordinate10 = new Coordinate(1, 0);
        this.coordinate32 = new Coordinate(3, 2);
        this.coordinate21 = new Coordinate(2, 1);
        this.coordinate43 = new Coordinate(4, 3);
        this.coordinate15 = new Coordinate(1, 5);
        this.coordinate65 = new Coordinate(6, 5);
        this.coordinate54 = new Coordinate(5, 4);
        this.coordinateInFirstRow = new Coordinate(0, 1);
        this.coordinateInLastRow = new Coordinate(7, 6);
    }

    @Test
    public void testGivenPieceToMoveFromCoordinateAToCoordinateBAndPieceOfOtherColorBetweenThatCoordinatesWhenTryToCheckIfMovementIsPossibleThenMoveOk() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(this.black1);
        Error error = this.white1.isCorrectMovement(pieces, 0, this.coordinate10, this.coordinate32);
        assertNull(error);
    }

    @Test
    public void testGivenPieceToMoveFromCoordinateAToCoordinateBAndPieceOfSameColorBetweenThatCoordinatesWhenTryToCheckIfMovementIsPossibleThenReturnError() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(this.white2);
        Error error = this.white1.isCorrectMovement(pieces, 0, this.coordinate10, this.coordinate32);
        assertEquals(error, Error.COLLEAGUE_EATING);
    }

    @Test
    public void testGivenPieceToMoveFromCoordinateAToCoordinateBNotInDiagonalWhenTryToCheckIfMovementIsPossibleThenReturnError() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(this.black1);
        Error error = this.white1.isCorrectMovement(pieces, 0, this.coordinate10, this.coordinate15);
        assertEquals(error, Error.NOT_DIAGONAL);
    }

    @Test
    public void testGivenWhitePieceInFirstPositionsWhenCheckIfPieceIsLimitThenReturnTrue() {
        boolean ok = this.white1.isLimit(this.coordinateInFirstRow);
        assertTrue(ok);
    }

    @Test
    public void testGivenWhitePieceInNotFirstPositionsWhenCheckIfPieceIsLimitThenReturnFalse() {
        boolean ok = this.white1.isLimit(this.coordinateInLastRow);
        assertFalse(ok);
    }

    @Test
    public void testGivenBlackPieceInLastPositionsWhenCheckIfPieceIsLimitThenReturnTrue() {
        boolean ok = this.black1.isLimit(this.coordinateInLastRow);
        assertTrue(ok);
    }

    @Test
    public void testGivenBlackPieceInNotLastPositionsWhenCheckIfPieceIsLimitThenReturnFalse() {
        boolean ok = this.black1.isLimit(this.coordinateInFirstRow);
        assertFalse(ok);
    }

    @Test
    public void testGivenWhitePieceAndTwoCoordinatesABWhenCheckIfThePieceIsAdvancedAndAIsBelowBThenReturnTrue() {
        assertTrue(this.white1.isAdvanced(this.coordinate32, this.coordinate10));
    }

    @Test
    public void testGivenWhitePieceAndTwoCoordinatesABWhenCheckIfThePieceIsAdvancedAndAIsAboveBThenReturnFalse() {
        assertFalse(this.white1.isAdvanced(this.coordinate10, this.coordinate32));
    }

    @Test
    public void testGivenBlackPieceAndTwoCoordinatesABWhenCheckIfThePieceIsAdvancedAndAIsAboveBThenReturnTrue() {
        assertTrue(this.black1.isAdvanced(this.coordinate10, this.coordinate32));
    }

    @Test
    public void testGivenBlackPieceAndTwoCoordinatesABWhenCheckIfThePieceIsAdvancedAndAIsBelowBThenReturnFalse() {
        assertFalse(this.black1.isAdvanced(this.coordinate32, this.coordinate10));
    }

    @Test
    public void testGivenDraughtToMoveFromCoordinateAToCoordinateBAndPiecesOfOtherColorBetweenThatCoordinatesWhenTryToCheckIfMovementIsPossibleThenReturnToMuchEating() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(this.black1);
        pieces.add(this.black2);
        Error error = this.white1.isCorrectMovement(pieces, 0, this.coordinate10, this.coordinate54);
        assertEquals(error, Error.TOO_MUCH_EATINGS);
    }

    @Test
    public void testGivenPawnToMoveFromCoordinateAToCoordinateBAndBackwardsWhenTryToCheckIfMovementIsPossibleThenReturnErrorNotAdvanced() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(this.black1);
        Error error = this.white2.isCorrectMovement(pieces, 0, this.coordinate10, this.coordinate32);
        assertEquals(error, Error.NOT_ADVANCED);
    }

    @Test
    public void testGivenPawnToMoveFromCoordinateAToCoordinateBInLargeDistanceWhenTryToCheckIfMovementIsPossibleThenReturnErrorTooMuchAdvanced() {
        List<Piece> pieces = new ArrayList<Piece>();
        Error error = this.white2.isCorrectMovement(pieces, 0, this.coordinate43, this.coordinate10);
        assertEquals(error, Error.TOO_MUCH_ADVANCED);
    }

    @Test
    public void testGivenPawnToMoveFromCoordinateAToCoordinateBWithDistance2WithoutCollectPiecesWhenTryToCheckIfMovementIsPossibleThenReturnErrorWithoutEating() {
        List<Piece> pieces = new ArrayList<Piece>();
        Error error = this.white2.isCorrectMovement(pieces, 0, this.coordinate32, this.coordinate10);
        assertEquals(error, Error.WITHOUT_EATING);
    }

    @Test
    public void testGivenPawnToMoveFromCoordinateAToCoordinateBCollecting1PieceWhenTryToCheckIfMovementIsPossibleThenReturnErrorNull() {
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(this.black1);
        Error error = this.white2.isCorrectMovement(pieces, 0, this.coordinate32, this.coordinate10);
        assertNull(error);
    }

}
