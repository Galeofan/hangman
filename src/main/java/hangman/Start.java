package main.java.hangman;

import main.java.hangman.stores.FileStore;
import main.java.hangman.stores.Store;

import java.util.Scanner;

public class Start {
    Scanner sc = new Scanner(System.in);
    Store store = new FileStore();
    NewGame game = new NewGame();
    boolean isRun = true;

    private void init() {
        while (isRun) {
            System.out.println("1.Начать новую игру");
            System.out.println("2.Выйти из игры");
            int i = sc.nextInt();
            if (i == 1) {
                System.out.println("Загадываем слово");
                String word = game.mindWord(store);
                System.out.println("Слово успешно загадано");
                game.start(word);
            } else {
                isRun = false;
                System.out.println("Выходим из игры");
            }
        }
    }

    public static void main(String[] args) {
        Start start = new Start();
        start.init();
    }
}