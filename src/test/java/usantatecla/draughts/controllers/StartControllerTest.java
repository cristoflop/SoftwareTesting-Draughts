package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import static org.junit.Assert.assertEquals;

public class StartControllerTest {

    private Game game;
    private State state;
    private StartController startController;

    @Before
    public void before() {
        this.game = new Game();
        this.state = new State();
        this.startController = new StartController(this.game, this.state);
    }

    @Test
    public void testGivenStartControllerWhenCallStartMethodThenTurnChangeToInGame() {
        assertEquals(this.state.getValueState(), StateValue.INITIAL);
        this.startController.start();
        assertEquals(this.state.getValueState(), StateValue.IN_GAME);
    }

}
