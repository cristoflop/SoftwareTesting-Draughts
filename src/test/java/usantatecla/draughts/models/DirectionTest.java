package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    private Direction direction;
    private Coordinate coordinate1;
    private Coordinate coordinate2;

    @Before
    public void before() {
        this.direction = Direction.NE;
        this.coordinate1 = new Coordinate(1, 1);
        this.coordinate2 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenCoordinateAndDirectionOnCoordinateDirectionWhenCheckIfDirectionIsOnCoordinateDirectionThenReturnTrue() {
        assertTrue(this.direction.isOnDirection(this.coordinate1));
    }

    @Test
    public void testGivenCoordinateAndDirectionNotOnCoordinateDirectionWhenCheckIfDirectionIsOnCoordinateDirectionThenReturnFalse() {
        assertFalse(this.direction.isOnDirection(this.coordinate2));
    }

    @Test
    public void testGivenDirectionAndProfundityLevelWhenGetCoordinateThenReturnTheCoordinate() {
        assertEquals(this.direction.getDistanceCoordinate(1), this.coordinate1);
    }

}
