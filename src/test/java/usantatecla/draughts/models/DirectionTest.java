package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    private Direction direction;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    @Before
    public void before() {
        this.direction = Direction.NE;
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenCoordinateAndDirectionOnCoordinateDirectionWhenCheckIfDirectionIsOnCoordinateDirectionThenReturnTrue() {
        assertTrue(this.direction.isOnDirection(this.coordinate11));
    }

    @Test
    public void testGivenCoordinateAndDirectionNotOnCoordinateDirectionWhenCheckIfDirectionIsOnCoordinateDirectionThenReturnFalse() {
        assertFalse(this.direction.isOnDirection(this.coordinate01));
    }

    @Test
    public void testGivenDirectionAndProfundityLevelWhenGetCoordinateThenReturnTheCoordinate() {
        assertEquals(this.direction.getDistanceCoordinate(1), this.coordinate11);
    }

}
