package solvd.training.student;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String filePath = Main.class.getClassLoader().getResource("file.txt").getPath();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String text = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
                String[] words = text.split("\\W+");

                List<String> filteredWords = new ArrayList<>();
                for (String word : words) {
                    if (!StringUtils.isAllBlank(word) && !StringUtils.containsAny(word, ",.")) {
                        filteredWords.add(word);
                    }
                }

                Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
                FileUtils.writeStringToFile(new File("output.txt"), String.valueOf(uniqueWords.size()), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading or writing files", e);
        }
    }
}