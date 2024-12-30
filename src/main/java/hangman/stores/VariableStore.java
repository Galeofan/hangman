package main.java.hangman.stores;

public class VariableStore implements Store {
    private String word;

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}

