package main.java.hangman;

import main.java.hangman.input.ConsoleInput;
import main.java.hangman.input.Input;
import main.java.hangman.menu.MenuAction;
import main.java.hangman.menu.NewGameAction;
import main.java.hangman.menu.StopGameAction;
import main.java.hangman.store.FileStore;
import main.java.hangman.store.Store;

import java.util.Arrays;
import java.util.List;

public class Start {

    private void init(Input input, Store store, List<MenuAction> actions) {
        boolean isRun = true;
        while (isRun) {
            showMenu(actions);
            int select = input.askInt() - 1;
            if (select < 0 || select > actions.size() - 1){
                System.out.println("Выберите корректный пункт меню");
                continue;
            }
            MenuAction action = actions.get(select);
            isRun = action.execute(store, input);
        }
    }

    public void showMenu(List<MenuAction> actions) {
        int index = 1;
        for (MenuAction action : actions) {
            System.out.println(index++ + "." + action.showName());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Store store = new FileStore();
        List<MenuAction> actions = Arrays.asList(new NewGameAction(), new StopGameAction());
        Start start = new Start();

        start.init(input, store, actions);
    }
}