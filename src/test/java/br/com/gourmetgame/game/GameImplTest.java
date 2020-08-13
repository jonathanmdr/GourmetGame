package br.com.gourmetgame.game;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.core.message.impl.MessageImpl;
import br.com.gourmetgame.main.game.impl.GameImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameImplTest {

    private GameImpl game;

    @Before
    public void before() {
        Message message = new MessageImpl();
        this.game = new GameImpl(message);
    }

    @Test
    public void validateBinaryTreeRootIsEqualToMassa() {
        Assert.assertEquals("massa", this.game.getRoot().getValue());
    }

    @Test
    public void validateBinaryTreeLeftNoEqualToLasanha() {
        Assert.assertEquals("Lasanha", this.game.getRoot().getLeftChild().getValue());
    }

    @Test
    public void validateBinaryTreeRightNoEqualToBoloDeChocolate() {
        Assert.assertEquals("Bolo de Chocolate", this.game.getRoot().getRightChild().getValue());
    }

}
