package br.com.gourmetgame.main.game.impl;

import static java.lang.String.format;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.domain.Node;
import br.com.gourmetgame.main.game.Game;
import lombok.Getter;

public class GameImpl implements Game {

    @Getter
    private final Node root;
    private final Message message;

    public GameImpl(Node root, Message message) {
        this.root = root;
        this.message = message;

        this.root.setValue("massa");
        this.root.setLeftChild(new Node("Lasanha"));
        this.root.setRightChild(new Node("Bolo de Chocolate"));
    }

    @Override
    public void execute() {
        boolean closeGame;

        do {
            closeGame = message.informStart("Pense em um prato que gosta", "Jogo Gourmet");

            if (!closeGame) {
                boolean answer = askingDish(root);
                Node node = answer ? root.getLeftChild() : root.getRightChild();

                guessDish(node);
            }
        } while (!closeGame);

    }

    private void guessDish(Node node) {
        boolean answer = askingDish(node);

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
                String feature = message.getInformation(format("%s é ______ mas %s não", dish, node.getValue()));

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

    private boolean askingDish(Node node) {
        return message.ask(format("O prato que você pensou é %s?", node.getValue()), "Confirm");
    }

}
