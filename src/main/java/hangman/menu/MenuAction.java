package main.java.hangman.menu;

import main.java.hangman.input.Input;
import main.java.hangman.store.Store;

public interface MenuAction {
    boolean execute(Store store, Input input);
    String showName();
}
