package main.java.hangman;

import main.java.hangman.menu.MenuAction;
import main.java.hangman.menu.NewGameAction;
import main.java.hangman.menu.StopGameAction;
import main.java.hangman.store.FileStore;
import main.java.hangman.store.Store;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Start {

    private void init(Scanner sc, Store store, List<MenuAction> actions) {
        boolean isRun = true;
        while (isRun) {
            showMenu(actions);
            int select = sc.nextInt() - 1;
            if (select < 0 || select > actions.size() - 1){
                throw new IllegalArgumentException("Выберите корректный пункт меню");
            }
            MenuAction action = actions.get(select);
            isRun = action.execute(store);
        }
    }

    public void showMenu(List<MenuAction> actions) {
        int index = 1;
        for (MenuAction action : actions) {
            System.out.println(index++ + "." + action.showName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new FileStore();
        List<MenuAction> actions = Arrays.asList(new NewGameAction(), new StopGameAction());
        Start start = new Start();

        start.init(sc, store, actions);
    }
}