package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {

    private State state;

    @Before
    public void before() {
        this.state = new State();
    }

    @Test
    public void testGivenStateWhenResetThenStateValueIsInitial() {
        this.state.reset();
        assertEquals(this.state.getValueState(), StateValue.INITIAL);
    }

    @Test
    public void testGivenInitialStateWhenMakeNextThenReturnInGameState() {
        this.state.next();
        assertEquals(this.state.getValueState(), StateValue.IN_GAME);
    }

}
