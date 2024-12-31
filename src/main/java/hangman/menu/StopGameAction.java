package main.java.hangman.menu;

import main.java.hangman.store.Store;

public class StopGameAction implements MenuAction {

    @Override
    public boolean execute(Store store) {
        System.out.println("=== Завершение программы ===");
        return false;
    }

    @Override
    public String showName() {
        return "Выйти из игры";
    }
}
