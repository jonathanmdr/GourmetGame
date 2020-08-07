package br.com.gourmetgame.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Node {

    private Node leftNode;
    private Node rightNode;
    private String value;

    public Node(String value) {
        this.value = value;
    }

    public boolean hasLeft() {
        return this.leftNode != null;
    }

    public boolean hasRight() {
        return this.rightNode != null;
    }

}
