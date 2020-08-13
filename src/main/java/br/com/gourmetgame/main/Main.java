package br.com.gourmetgame.main;

import br.com.gourmetgame.core.message.Message;
import br.com.gourmetgame.core.message.impl.MessageImpl;
import br.com.gourmetgame.main.game.Game;
import br.com.gourmetgame.main.game.impl.GameImpl;
import br.com.gourmetgame.service.GameService;

public class Main {

    public static void main(String ... args) {
        GameService service = new GameService();
        Message message = new MessageImpl();
        Game game = new GameImpl(message);

        service.executeGame(game);
    }

}
