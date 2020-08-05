package br.com.gourmetgame.main.game.impl;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.domain.BinaryTree;
import br.com.gourmetgame.domain.No;
import br.com.gourmetgame.main.game.Game;
import lombok.Getter;

public class GameImpl implements Game {

    @Getter
    private BinaryTree binaryTree;
    private Message message;

    public GameImpl(Message message) {
        this.message = message;

        this.binaryTree = new BinaryTree(new No("massa"));
        this.binaryTree.getRoot().setLeftNo(new No("Lasanha"));
        this.binaryTree.getRoot().setRightNo(new No("Bolo de Chocolate"));
    }

    @Override
    public void execute() {
        boolean closeGame;

        do {
            closeGame = message.informStart("Pense em um prato que gosta", "Jogo Gourmet");

            if (!closeGame) {
                boolean answer = message.ask(String.format("O prato que você pensou é %s?", binaryTree.getRoot().getValue()), "Confirm");
                No no = answer ? binaryTree.getRoot().getLeftNo() : binaryTree.getRoot().getRightNo();

                guessDish(no);
            }
        } while (!closeGame);

    }

    private void guessDish(No no) {
        boolean answer = message.ask(String.format("O prato que você pensou é %s?", no.getValue()), "Confirm");

        if (answer) {

            if (no.getRightNo() == null) {
                message.inform("Acertei de novo!", "Jogo Gourmet");
            } else {
                guessDish(no.getRightNo());
            }

        } else {

            if (no.getLeftNo() == null) {
                String dish = message.getInformation("Qual prato você pensou?");
                String feature = message.getInformation(String.format("%s é ______ mas %s não", dish, no.getValue()));

                if (dish != null && feature != null) {
                    insertNo(no, dish, feature);
                }
            }

        }
    }

    private void insertNo(No no, String answer, String feature) {
        no.setValue(feature);
        no.setLeftNo(new No(no.getValue()));
        no.setRightNo(new No(answer));
    }

}
