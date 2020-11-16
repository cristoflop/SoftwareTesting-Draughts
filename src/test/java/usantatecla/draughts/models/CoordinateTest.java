package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CoordinateTest {

    private Coordinate coordinate1;
    private Coordinate coordinate2;
    private Coordinate coordinate3;
    private Coordinate coordinate4;
    private Coordinate coordinate5;
    private Coordinate coordinate6;
    private Coordinate coordinate7;
    private Direction direction;

    @Before
    public void before() {
        this.coordinate1 = new Coordinate(0, 5);
        this.coordinate2 = new Coordinate(1, 1);
        this.coordinate3 = new Coordinate(3, 3);
        this.coordinate4 = new Coordinate(0, 7);
        this.coordinate5 = new Coordinate(2, 2);
        this.coordinate6 = new Coordinate(5, 5);
        this.coordinate7 = new Coordinate(7, 0);
        this.direction = Direction.NE;
    }

    @Test
    public void testGivenStringWithIncorrectFormatWhenGetInstanceThenReturnNull() {
        Coordinate coordinate = Coordinate.getInstance("error");
        assertNull(coordinate);
    }

    @Test
    public void testGivenStringWithCorrectFormatWhenGetInstanceAndCoordinateIsWithInThenReturnTheCoordinate() {
        Coordinate coordinate = Coordinate.getInstance("16");
        assertEquals(this.coordinate1, coordinate);
    }

    @Test
    public void testGivenStringWithCorrectFormatWhenGetInstanceAndCoordinateIsNotWithInThenReturnNull() {
        Coordinate coordinate = Coordinate.getInstance("109");
        assertNull(coordinate);
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenGetTheDirectionBetweenThemThenReturnTheDirection() {
        Direction direction = this.coordinate2.getDirection(this.coordinate3);
        assertEquals(this.direction, direction);
    }

    @Test
    public void testGivenTwoCoordinatesInRowWhenGetTheDirectionBetweenThemThenReturnNull() {
        Direction direction = this.coordinate1.getDirection(this.coordinate4);
        assertNull(direction);
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenCheckIfTheyAreInDiagonalThenReturnTrue() {
        assertTrue(this.coordinate2.isOnDiagonal(this.coordinate3));
    }

    @Test
    public void testGivenTwoCoordinatesNotInDiagonalWhenCheckIfTheyAreInDiagonalThenReturnFalse() {
        assertFalse(this.coordinate1.isOnDiagonal(this.coordinate2));
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenGetTheDistanceBetweenThemThenReturnTheDistance() {
        int diagonalDistance = this.coordinate2.getDiagonalDistance(this.coordinate3);
        assertTrue(diagonalDistance > 0);
    }

    @Test
    public void testGivenTwoCoordinatesWithDiagonalDistance2WhenGetTheCoordinateInTheMiddleThenReturnTheCoordinate() {
        Coordinate coordinate = this.coordinate2.getBetweenDiagonalCoordinate(this.coordinate3);
        assertEquals(this.coordinate5, coordinate);
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenGetTheCoordinatesBetweenThemThenReturnAList() {
        List<Coordinate> coordinates = this.coordinate2.getBetweenDiagonalCoordinates(this.coordinate6);
        assertTrue(coordinates.contains(this.coordinate5));
    }

    @Test
    public void testGivenCoordinateAndProfundityLevelWhenGetTheCoordinatesInAllDiagonalWaysThenReturnAList() {
        List<Coordinate> coordinates = this.coordinate2.getDiagonalCoordinates(1);
        assertTrue(coordinates.contains(this.coordinate5));
    }

    @Test
    public void testGivenBlackCoordinateWhenCheckIfCoordinateIsBlackThenReturnTrue() {
        assertTrue(this.coordinate1.isBlack());
    }

    @Test
    public void testGivenWhiteCoordinateWhenCheckIfCoordinateIsBlackThenReturnFalse() {
        assertFalse(this.coordinate2.isBlack());
    }

    @Test
    public void testGivenCoordinateInFirstRowWhenCheckIfCoordinateIsInFirstRowThenReturnTrue() {
        assertTrue(this.coordinate1.isFirst());
    }

    @Test
    public void testGivenCoordinateNotInFirstRowWhenCheckIfCoordinateIsInFirstRowThenReturnFalse() {
        assertFalse(this.coordinate7.isFirst());
    }

    @Test
    public void testGivenCoordinateInLastRowWhenCheckIfCoordinateIsInLastRowThenReturnTrue() {
        assertTrue(this.coordinate7.isLast());
    }

    @Test
    public void testGivenCoordinateNotInLastRowWhenCheckIfCoordinateIsInLastRowThenReturnFalse() {
        assertFalse(this.coordinate1.isLast());
    }

}
