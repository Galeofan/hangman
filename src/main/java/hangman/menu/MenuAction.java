package main.java.hangman.menu;

import main.java.hangman.store.Store;

public interface MenuAction {
    boolean execute(Store store);
    String showName();
}
