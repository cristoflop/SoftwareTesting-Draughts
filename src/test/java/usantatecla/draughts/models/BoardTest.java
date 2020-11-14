package usantatecla.draughts.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void before() {
        this.board = new Board();
    }

    @Test
    public void getPieceTest() {
        Assert.assertNotNull(this.board);
    }

}
