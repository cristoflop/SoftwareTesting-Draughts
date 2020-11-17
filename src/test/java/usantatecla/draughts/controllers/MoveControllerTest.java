package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import static org.junit.Assert.assertNull;

public class MoveControllerTest {

    private MoveController moveController;

    @Before
    public void before() {
        Game game = new Game();
        State state = new State();
        state.next();
        this.moveController = new MoveController(game, state);
    }

    @Test
    public void testGivenMoveControllerWhenMoveFromCoordinateToOtherThenReturnErrorNull() {
        Coordinate coordinate52 = new Coordinate(5, 2);
        Coordinate coordinate41 = new Coordinate(4, 1);
        Error error = this.moveController.game.move(coordinate52, coordinate41);
        assertNull(error);
    }

}
