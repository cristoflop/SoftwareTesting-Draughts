package usantatecla.draughts.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StartControllerTest.class,
        CancelControllerTest.class,
        MoveControllerTest.class,
        PlayControllerTest.class,
        ResumeControllerTest.class,
        LogicTest.class
})
public class AllControllerTest {

}
