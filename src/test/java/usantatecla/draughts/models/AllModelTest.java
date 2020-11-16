package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BoardTest.class,
        ColorTest.class,
        CoordinateTest.class,
        DirectionTest.class,
        PieceTest.class,
        StateTest.class
})
public class AllModelTest {

}