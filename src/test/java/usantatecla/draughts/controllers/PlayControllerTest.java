package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.*;

import static org.junit.Assert.*;

public class PlayControllerTest {

    private Coordinate coordinate50;
    private Coordinate coordinate41;
    private PlayController playController;

    @Before
    public void before() {
        this.coordinate50 = new Coordinate(5, 0);
        this.coordinate41 = new Coordinate(4, 1);
        Game game = new Game();
        State state = new State();
        state.next();
        this.playController = new PlayController(game, state);
    }

    @Test
    public void testGivenPlayControllerWhenMoveFromCoordinateAToCoordinateBAndItIsPossibleThenReturnErrorNull() {
        Error error = this.playController.move(this.coordinate50, this.coordinate41);
        assertNull(error);
    }

    @Test
    public void testGivenPlayControllerWhenGetTheColorOfPlayerTurnThenReturnWhite() {
        Color color = this.playController.getColor();
        assertEquals(color, Color.WHITE);
    }

    @Test
    public void testGivenPlayControllerWhenGetTheColorOfPlayerTurnAfterCancelThenReturnBlack() {
        this.playController.cancel();
        Color color = this.playController.getColor();
        assertEquals(color, Color.BLACK);
    }

    @Test
    public void testGivenPlayControllerWhenCheckIfGameIsBlockedAndPlayerCanMoveThenReturnFalse() {
        assertFalse(this.playController.isBlocked());
    }

}
