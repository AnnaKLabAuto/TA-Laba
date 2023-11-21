package solvd.training.student;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = Main.class.getClassLoader().getResource("file.txt").getPath();
        String text = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        Set<String> uniqueWords = new HashSet<>(List.of(StringUtils.split(text, " ")));
        FileUtils.writeStringToFile(new File("output.txt"), String.valueOf(uniqueWords.size()), StandardCharsets.UTF_8);
    }
}