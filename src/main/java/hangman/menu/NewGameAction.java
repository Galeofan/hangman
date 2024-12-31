package main.java.hangman.menu;

import main.java.hangman.Hang;
import main.java.hangman.input.Input;
import main.java.hangman.store.Store;

import java.util.*;

public class NewGameAction implements MenuAction {
    boolean isStarted = true;
    static int mistakes;
    ArrayList<Character> charArray = new ArrayList<>();
    Set<Character> inputChars = new HashSet<>();

    @Override
    public boolean execute(Store store, Input input) {
        System.out.println("=== Игра началась ===");
        System.out.println("Загаданное слово:");
        store.setWord();
        String word = store.getWord();
        fillCharArray(charArray, word.length());
        showCharArray(charArray);
        while (isStarted) {
            Character letter = input.askChar("Введите " + "букву:");
            if (!checkCyrillic(letter)) {
                System.out.print("Слово в данный момент: \n");
                showCharArray(charArray);
                System.out.println("Кол-во ошибок: " + mistakes);
                continue;
            }
            if (checkRepeated(letter)) {
                System.out.print("Слово в данный момент: \n");
                showCharArray(charArray);
                System.out.println("Кол-во ошибок: " + mistakes);
                Hang.drawHang(mistakes);
            } else if (hasLetter(letter, word)) {
                System.out.print("Слово в данный момент:");
                fillCharArray(charArray, letter, word);
                showCharArray(charArray);
                System.out.println("Кол-во ошибок: " + mistakes);
                Hang.drawHang(mistakes);
            } else {
                System.out.println("Буквы " + letter + " нет в слове");
                mistakes++;
                System.out.println("Кол-во ошибок: " + mistakes);
                Hang.drawHang(mistakes);
            }
            if (!charArray.contains('_')) {
                System.out.println("Победа победа вместо обеда!!!");
                isStarted = false;
            }
            if (mistakes == 6) {
                System.out.println("Конец игры");
                System.out.println("Слово было: " + store.getWord());
                isStarted = false;
            }
            inputChars.add(letter);
        }
        return true;
    }

    @Override
    public String showName() {
        return "Начать новую игру";
    }

    public void fillCharArray(List<Character> charArray, int length) {
        for (int i = 0; i < length; i++) {
            charArray.add('_');
        }
    }

    public void fillCharArray(List<Character> charArray, char letter, String word) {
        for (int i = 0; i < charArray.size(); i++) {
            if (word.charAt(i) == letter) {
                charArray.set(i, letter);
            }
        }
        System.out.println();
    }

    public void showCharArray(List<Character> charArray) {
        for (Character chars : charArray) {
            System.out.print(chars);
        }
        System.out.println();
    }

    public boolean hasLetter(Character letter, String word) {
        boolean hasLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                System.out.println("Есть такая буква!!!");
                hasLetter = true;
                break;
                }
            }
        return hasLetter;
    }

    public boolean checkCyrillic(Character letter) {
        boolean result = Character.UnicodeBlock.of(letter).equals(Character.UnicodeBlock.CYRILLIC);
        if (!result) {
            System.out.println("Введите символ кириллицы");
        }
        return result;
    }

    public boolean checkRepeated(Character letter) {
        boolean result = inputChars.contains(letter);
        if (result) {
            System.out.println("Буква уже вводилась ранее");
        }
        return result;
    }
}
