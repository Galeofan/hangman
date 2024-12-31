package main.java.hangman.input;

import java.util.Scanner;

public class ConsoleInput implements Input{
    Scanner sc = new Scanner(System.in);

    @Override
    public Character askChar(String message) {
        System.out.println(message);
        return sc.nextLine().toLowerCase().charAt(0);
    }

    @Override
    public int askInt() {
        return Integer.parseInt(sc.nextLine());
    }
}
