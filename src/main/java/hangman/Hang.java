package main.java.hangman;

public class Hang {

    public static void drawHang(int mistakes) {
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
