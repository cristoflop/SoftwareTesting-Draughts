package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CoordinateTest {

    private Coordinate coordinate05;
    private Coordinate coordinate11;
    private Coordinate coordinate33;
    private Coordinate coordinate07;
    private Coordinate coordinate22;
    private Coordinate coordinate55;
    private Coordinate coordinate70;
    private Direction direction;

    @Before
    public void before() {
        this.coordinate05 = new Coordinate(0, 5);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate33 = new Coordinate(3, 3);
        this.coordinate07 = new Coordinate(0, 7);
        this.coordinate22 = new Coordinate(2, 2);
        this.coordinate55 = new Coordinate(5, 5);
        this.coordinate70 = new Coordinate(7, 0);
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
        assertEquals(this.coordinate05, coordinate);
    }

    @Test
    public void testGivenStringWithCorrectFormatWhenGetInstanceAndCoordinateIsNotWithInThenReturnNull() {
        Coordinate coordinate = Coordinate.getInstance("109");
        assertNull(coordinate);
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenGetTheDirectionBetweenThemThenReturnTheDirection() {
        Direction direction = this.coordinate11.getDirection(this.coordinate33);
        assertEquals(this.direction, direction);
    }

    @Test
    public void testGivenTwoCoordinatesInRowWhenGetTheDirectionBetweenThemThenReturnNull() {
        Direction direction = this.coordinate05.getDirection(this.coordinate07);
        assertNull(direction);
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenCheckIfTheyAreInDiagonalThenReturnTrue() {
        assertTrue(this.coordinate11.isOnDiagonal(this.coordinate33));
    }

    @Test
    public void testGivenTwoCoordinatesNotInDiagonalWhenCheckIfTheyAreInDiagonalThenReturnFalse() {
        assertFalse(this.coordinate05.isOnDiagonal(this.coordinate11));
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenGetTheDistanceBetweenThemThenReturnTheDistance() {
        int diagonalDistance = this.coordinate11.getDiagonalDistance(this.coordinate33);
        assertTrue(diagonalDistance > 0);
    }

    @Test
    public void testGivenTwoCoordinatesWithDiagonalDistance2WhenGetTheCoordinateInTheMiddleThenReturnTheCoordinate() {
        Coordinate coordinate = this.coordinate11.getBetweenDiagonalCoordinate(this.coordinate33);
        assertEquals(this.coordinate22, coordinate);
    }

    @Test
    public void testGivenTwoCoordinatesInDiagonalWhenGetTheCoordinatesBetweenThemThenReturnAList() {
        List<Coordinate> coordinates = this.coordinate11.getBetweenDiagonalCoordinates(this.coordinate55);
        assertTrue(coordinates.contains(this.coordinate22));
    }

    @Test
    public void testGivenCoordinateAndProfundityLevelWhenGetTheCoordinatesInAllDiagonalWaysThenReturnAList() {
        List<Coordinate> coordinates = this.coordinate11.getDiagonalCoordinates(1);
        assertTrue(coordinates.contains(this.coordinate22));
    }

    @Test
    public void testGivenBlackCoordinateWhenCheckIfCoordinateIsBlackThenReturnTrue() {
        assertTrue(this.coordinate05.isBlack());
    }

    @Test
    public void testGivenWhiteCoordinateWhenCheckIfCoordinateIsBlackThenReturnFalse() {
        assertFalse(this.coordinate11.isBlack());
    }

    @Test
    public void testGivenCoordinateInFirstRowWhenCheckIfCoordinateIsInFirstRowThenReturnTrue() {
        assertTrue(this.coordinate05.isFirst());
    }

    @Test
    public void testGivenCoordinateNotInFirstRowWhenCheckIfCoordinateIsInFirstRowThenReturnFalse() {
        assertFalse(this.coordinate70.isFirst());
    }

    @Test
    public void testGivenCoordinateInLastRowWhenCheckIfCoordinateIsInLastRowThenReturnTrue() {
        assertTrue(this.coordinate70.isLast());
    }

    @Test
    public void testGivenCoordinateNotInLastRowWhenCheckIfCoordinateIsInLastRowThenReturnFalse() {
        assertFalse(this.coordinate05.isLast());
    }

}
