package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import usantatecla.draughts.controllers.AllControllerTest;
import usantatecla.draughts.models.AllModelTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllControllerTest.class,
        AllModelTest.class
})
public class AllTest {
}
