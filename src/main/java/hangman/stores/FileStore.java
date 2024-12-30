package main.java.hangman.stores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class FileStore implements Store {
    Path filePath = Paths.get("words.txt");
    private String word;

    @Override
    public void setWord(String word)  {
        try {
            List<String> lines = Files.readAllLines(filePath);
            Random random = new Random();
            int randomIndex = random.nextInt(lines.size());
            this.word = lines.get(randomIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getWord() {
        return word;
    }
}
