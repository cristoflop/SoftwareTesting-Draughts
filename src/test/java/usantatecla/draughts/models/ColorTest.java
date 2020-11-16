package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    private Color white;
    private Color black;
    private Coordinate coordinate0;
    private Coordinate coordinate1;
    private Coordinate coordinate2;
    private Coordinate coordinate3;

    @Before
    public void before() {
        this.white = Color.WHITE;
        this.black = Color.BLACK;
        this.coordinate0 = new Coordinate(4, 3);
        this.coordinate1 = new Coordinate(0, 0);
        this.coordinate2 = new Coordinate(7, 0);
        this.coordinate3 = new Coordinate(1, 0);
    }

    @Test
    public void testGivenARowWhenCheckIfIsInitialRowForWhiteColorAndRowIsHigherOrEqualThan5ThenReturnTrue() {
        assertTrue(this.white.isInitialRow(5));
    }

    @Test
    public void testGivenARowWhenCheckIfIsInitialRowForWhiteColorAndRowIsLowerThan5ThenReturnFalse() {
        assertFalse(this.white.isInitialRow(4));
    }

    @Test
    public void testGivenARowWhenCheckIfIsInitialRowForBlackColorAndRowIsLowerOrEqualThan2ThenReturnTrue() {
        assertTrue(this.black.isInitialRow(2));
    }

    @Test
    public void testGivenARowWhenCheckIfIsInitialRowForBlackColorAndRowIsHigherThan2ThenReturnFalse() {
        assertFalse(this.black.isInitialRow(3));
    }

    @Test
    public void testGivenACoordinateWhenCoordinateIsBlackCoordinateAndIsInitialRowForWhiteColorThenReturnTheColorForThatCoordinate() {
        Color color = Color.getInitialColor(this.coordinate2);
        assertEquals(color, Color.WHITE);
    }

    @Test
    public void testGivenACoordinateWhenCoordinateIsBlackCoordinateAndIsInitialRowForBlackColorThenReturnTheColorForThatCoordinate() {
        Color color = Color.getInitialColor(this.coordinate3);
        assertEquals(color, Color.BLACK);
    }

    @Test
    public void testGivenACoordinateWhenCoordinateIsBlackAndIsNotInitialRowCoordinateThenReturnNull() {
        Color color = Color.getInitialColor(this.coordinate0);
        assertNull(color);
    }

    @Test
    public void testGivenACoordinateWhenCoordinateIsWhiteCoordinateThenReturnNull() {
        Color color = Color.getInitialColor(this.coordinate1);
        assertNull(color);
    }

}
