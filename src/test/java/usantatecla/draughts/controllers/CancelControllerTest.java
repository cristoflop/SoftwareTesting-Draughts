package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import static org.junit.Assert.assertEquals;

public class CancelControllerTest {

    private Game game;
    private State state;
    private CancelController cancelController;

    @Before
    public void before() {
        this.game = new Game();
        this.state = new State();
        this.state.next();
        this.cancelController = new CancelController(this.game, this.state);
    }

    @Test
    public void testGivenCancelControllerWhenCallCancelMethodThenStateChangeToFinal() {
        this.cancelController.cancel();
        assertEquals(this.state.getValueState(), StateValue.FINAL);
    }

}
