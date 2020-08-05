package br.com.gourmetgame.core.message.impl;

import br.com.gourmetgame.core.message.Message;

import javax.swing.*;

public class MessageImpl implements Message {

    @Override
    public boolean ask(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }

    @Override
    public boolean informStart(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.CLOSED_OPTION;
    }

    @Override
    public void inform(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getInformation(String message) {
        return JOptionPane.showInputDialog(message);
    }

}
