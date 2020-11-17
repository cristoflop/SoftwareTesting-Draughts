package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import static org.junit.Assert.assertEquals;

public class ResumeControllerTest {

    private Game game;
    private State state;
    private ResumeController resumeController;

    @Before
    public void before() {
        this.game = new Game();
        this.state = new State();
        state.next();
        state.next();
        this.resumeController = new ResumeController(game, state);
    }

    @Test
    public void testGivenResumeControllerWhenCallNextMethodThenStateChangeToExit() {
        this.resumeController.next();
        assertEquals(this.state.getValueState(), StateValue.EXIT);
    }

    @Test
    public void testGivenResumeControllerWhenCallResetMethodThenStateChangeToInitial() {
        this.resumeController.reset();
        assertEquals(this.state.getValueState(), StateValue.INITIAL);
    }

}
