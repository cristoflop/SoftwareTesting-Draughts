package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogicTest {

    private Logic logic;

    @Before
    public void before() {
        this.logic = new Logic();
    }

    @Test
    public void testGivenNewLogicWhenGetControllerThenReturnStartController() {
        assertTrue(this.logic.getController() instanceof StartController);
    }

}
