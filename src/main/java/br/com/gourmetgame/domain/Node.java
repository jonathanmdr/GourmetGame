package br.com.gourmetgame.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Node {

    private Node leftChild;
    private Node rightChild;
    private String value;

    public Node(String value) {
        this.value = value;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

}
