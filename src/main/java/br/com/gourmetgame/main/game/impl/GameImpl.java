package br.com.gourmetgame.main.game.impl;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.domain.Node;
import br.com.gourmetgame.main.game.Game;
import lombok.Getter;

public class GameImpl implements Game {

    @Getter
    private Node root;
    private Message message;

    public GameImpl(Message message) {
        this.message = message;

        this.root = new Node("massa");
        this.root.setLeftChild(new Node("Lasanha"));
        this.root.setRightChild(new Node("Bolo de Chocolate"));
    }

    @Override
    public void execute() {
        boolean closeGame;

        do {
            closeGame = message.informStart("Pense em um prato que gosta", "Jogo Gourmet");

            if (!closeGame) {
                boolean answer = message.ask(String.format("O prato que você pensou é %s?", root.getValue()), "Confirm");
                Node node = answer ? root.getLeftChild() : root.getRightChild();

                guessDish(node);
            }
        } while (!closeGame);

    }

    private void guessDish(Node node) {
        boolean answer = message.ask(String.format("O prato que você pensou é %s?", node.getValue()), "Confirm");

        if (answer) {

            if (node.hasRightChild()) {
                guessDish(node.getRightChild());
            } else {
                message.inform("Acertei de novo!", "Jogo Gourmet");
            }

        } else {

            if (node.hasLeftChild()) {
                guessDish(node.getLeftChild());
            } else {
                String dish = message.getInformation("Qual prato você pensou?");
                String feature = message.getInformation(String.format("%s é ______ mas %s não", dish, node.getValue()));

                insertNode(node, dish, feature);
            }

        }
    }

    private void insertNode(Node node, String answer, String feature) {
        String oldValue = node.getValue();

        node.setValue(feature);
        node.setLeftChild(new Node(oldValue));
        node.setRightChild(new Node(answer));
    }

}
