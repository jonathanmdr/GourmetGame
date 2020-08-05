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
        GameImpl game = this.game;

        Assert.assertEquals("massa", game.getBinaryTree().getRoot().getValue());
    }

    @Test
    public void validateBinaryTreeLeftNoEqualToLasanha() {
        GameImpl game = this.game;

        Assert.assertEquals("Lasanha", game.getBinaryTree().getRoot().getLeftNo().getValue());
    }

    @Test
    public void validateBinaryTreeRightNoEqualToBoloDeChocolate() {
        GameImpl game = this.game;

        Assert.assertEquals("Bolo de Chocolate", game.getBinaryTree().getRoot().getRightNo().getValue());
    }

}
