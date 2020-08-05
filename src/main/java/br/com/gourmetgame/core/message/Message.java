package br.com.gourmetgame.core.message;

public interface Message {

    boolean ask(String message, String title);

    boolean informStart(String message, String title);

    void inform(String message, String title);

    String getInformation(String message);

}
