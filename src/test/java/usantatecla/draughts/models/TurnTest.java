package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnTest {

    private Turn turn;

    @Before
    public void before() {
        this.turn = new Turn();
    }

    @Test
    public void testGivenTurnWithWhiteColorWhenChangeThenColorIsBlack() {
        this.turn.change();
        assertEquals(this.turn.getColor(), Color.BLACK);
    }

    @Test
    public void testGivenTurnWithWhiteColorWhenGetTheOppositeColorThenReturnColorBlack() {
        assertEquals(this.turn.getOppositeColor(), Color.BLACK);
    }

    @Test
    public void testGivenTurnWithWhiteColorWhenCallToStringMethodThenReturnTheColorName() {
        assertEquals(this.turn.toString(), "WHITE");
    }

}
