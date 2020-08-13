package br.com.gourmetgame.domain;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void hasLeftChildEqualsTrue() {
        Node node = new Node("massa");
        node.setLeftChild(new Node("Lasanha"));

        Assert.assertTrue(node.hasLeftChild());
    }

    @Test
    public void hasLeftChildEqualsFalse() {
        Node node = new Node("massa");
        node.setLeftChild(null);

        Assert.assertFalse(node.hasLeftChild());
    }

    @Test
    public void hasRightChildEqualsTrue() {
        Node node = new Node("massa");
        node.setRightChild(new Node("Bolo de chocolate"));

        Assert.assertTrue(node.hasRightChild());
    }

    @Test
    public void hasRightChildEqualsFalse() {
        Node node = new Node();
        node.setRightChild(null);

        Assert.assertFalse(node.hasRightChild());
    }

}
