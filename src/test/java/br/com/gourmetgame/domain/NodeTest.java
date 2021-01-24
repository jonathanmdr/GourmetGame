package br.com.gourmetgame.domain;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    private Node subject;

    @Test
    public void hasLeftChildEqualsTrue() {
        subject = new Node("massa");
        subject.setLeftChild(new Node("Lasanha"));

        Assert.assertTrue(subject.hasLeftChild());
    }

    @Test
    public void hasLeftChildEqualsFalse() {
        subject = new Node("massa");
        subject.setLeftChild(null);

        Assert.assertFalse(subject.hasLeftChild());
    }

    @Test
    public void hasRightChildEqualsTrue() {
        subject = new Node("massa");
        subject.setRightChild(new Node("Bolo de chocolate"));

        Assert.assertTrue(subject.hasRightChild());
    }

    @Test
    public void hasRightChildEqualsFalse() {
        subject = new Node();
        subject.setRightChild(null);

        Assert.assertFalse(subject.hasRightChild());
    }

}
