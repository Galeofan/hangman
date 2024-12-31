package main.java.hangman.store;

public class VariableStore implements Store {
    private String word;

    public void setWord() {
        this.word = "word";
    }

    public String getWord() {
        return word;
    }
}

