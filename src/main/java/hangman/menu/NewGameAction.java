package main.java.hangman.menu;

import main.java.hangman.store.Store;

import java.util.Arrays;
import java.util.Scanner;

public class NewGameAction implements MenuAction {
    boolean isStarted = true;
    Scanner sc = new Scanner(System.in);
    int counter = 1;
    int mistakes;

    @Override
    public boolean execute(Store store) {
        System.out.println("=== Игра началась ===");
        System.out.println("Загаданное слово:");
        store.setWord();
        String word = store.getWord();
        Character[] charArray = new Character[word.length()];
        fillAndShowCharArray(charArray);

        while (isStarted) {
            System.out.println("Введите " + "букву:");
            String letter = sc.nextLine().toLowerCase();
            if (Arrays.asList(charArray).contains(letter.charAt(0)))
            {
                System.out.println("Буква уже была отгадана ранее");
                System.out.print("Слово в данный момент: \n");
                fillAndShowCharArray(charArray, letter.charAt(0), word);
                drawHang(mistakes);
            } else if (hasLetter(letter, word)) {
                counter++;
                System.out.print("Слово в данный момент: \n");
                fillAndShowCharArray(charArray, letter.charAt(0), word);
                drawHang(mistakes);
            } else {
                System.out.println("Буквы " + letter + " нет в слове");
                mistakes++;
                System.out.println("Кол-во ошибок: " + mistakes);
                drawHang(mistakes);
            }
            if (!Arrays.asList(charArray).contains('_')) {
                System.out.println("Победа победа вместо обеда!!!");
                isStarted = false;
            }
            if (mistakes == 6) {
                System.out.println("Конец игры");
                System.out.println("Слово было: " + store.getWord());
                isStarted = false;
            }
        }
        return true;
    }

    public void fillAndShowCharArray(Character[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            if (null == charArray[i]) {
                charArray[i] = '_';
            }
        }
        for (char chars: charArray) {
            System.out.print(chars);
        }
        System.out.println();
    }

    public void fillAndShowCharArray(Character[] charArray, char letter, String word) {
        for (int i = 0; i < charArray.length; i++) {
            if (word.charAt(i) == letter) {
                charArray[i] = letter;
            }
        }
        for (char chars: charArray) {
            System.out.print(chars);
        }
        System.out.println();
    }

    public boolean hasLetter(String letter, String word) {
        boolean hasLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.contains(letter)) {
                System.out.println("Есть такая буква!!!");
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

    @Override
    public String showName() {
        return "Начать новую игру";
    }
}
