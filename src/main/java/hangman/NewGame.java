package main.java.hangman;

import main.java.hangman.stores.Store;

import java.util.Scanner;

public class NewGame {
    boolean isStarted = true;
    Scanner sc = new Scanner(System.in);
    int counter = 1;
    int mistakes;

    public void start(String word) {
        while (isStarted) {
            System.out.println("Введите " + counter + "-ю" + " букву:");
            String letter = sc.nextLine();
            if (hasLetter(letter, word)) {
                counter++;
            } else {
                System.out.println("Буквы " + letter + " нет в слове");
                System.out.println("Кол-во ошибок: " + ++mistakes);
                drawHang(mistakes);
            }
            if (counter >= word.length() + 1) {
                System.out.println("Победа победа вместо обеда!!!");
                isStarted = false;
            }
            if (mistakes == 6) {
                System.out.println("В другой раз повезёт");
                isStarted = false;
            }
        }
    }

    public String mindWord(Store store) {
        store.setWord("test");
        String mindedWord = store.getWord();
        for (int i = 0; i < mindedWord.length(); i++) {
            System.out.print("_");
        }
        System.out.println();
        return mindedWord;
    }

    public boolean hasLetter(String letter, String word) {
        boolean hasLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.contains(letter)) {
                System.out.println("Есть такая буква");
                hasLetter = true;
                break;
            }
        }
        return hasLetter;
    }

    public void drawHang(int mistakes) {
        if (mistakes == 1) {
            System.out.println("  O");
        }
        if (mistakes == 2) {
            System.out.println("  O\n  |");
        }
        if (mistakes == 3) {
            System.out.println("  O\n /|");
        }
        if (mistakes == 4) {
            System.out.println("  O\n /|\\");
        }
        if (mistakes == 5) {
            System.out.println("  O\n /|\\\n /");
        }
        if (mistakes == 6) {
            System.out.println("  O\n /|\\\n / \\");
        }
    }
}
