package br.com.gourmetgame.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.core.message.impl.MessageImpl;
import br.com.gourmetgame.domain.Node;
import br.com.gourmetgame.main.game.impl.GameImpl;

public class GameImplTest {

    private GameImpl subject;

    @Before
    public void before() {
        Node root = new Node();
        Message message = new MessageImpl();
        this.subject = new GameImpl(root, message);
    }

    @Test
    public void validateBinaryTreeRootIsEqualsToMassa() {
        Assert.assertEquals("massa", this.subject.getRoot().getValue());
    }

    @Test
    public void validateBinaryTreeLeftChildNodeEqualsToLasanha() {
        Assert.assertEquals("Lasanha", this.subject.getRoot().getLeftChild().getValue());
    }

    @Test
    public void validateBinaryTreeRightChildNodeEqualsToBoloDeChocolate() {
        Assert.assertEquals("Bolo de Chocolate", this.subject.getRoot().getRightChild().getValue());
    }

}
