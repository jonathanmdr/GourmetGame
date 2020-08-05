package br.com.gourmetgame.main;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.core.message.impl.MessageImpl;
import br.com.gourmetgame.main.game.impl.GameImpl;
import br.com.gourmetgame.service.GameService;

public class Main {

    public static void main(String ... args) {
        Message message = new MessageImpl();
        GameService service = new GameService();

        service.executeGame(new GameImpl(message));
    }

}
