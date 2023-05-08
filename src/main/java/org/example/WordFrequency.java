package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.FileInputStream;
import java.io.IOException;

public class WordFrequency {
    private static List<String> getWordsList(FileInputStream file) throws IOException {
        List<String> words = new ArrayList<>();
        String word = "";

        int ch;
        while ((ch = file.read()) != -1) {
            if (Character.isWhitespace(ch)) {
                if (word.isEmpty()) continue;
                words.add(word);
                word = "";
                continue;
            }
            word += (char) ch;
        }
        return words;
    }

    public static HashMap<String, Integer> getFrequencyMap(FileInputStream file) throws IOException {
        List<String> words = getWordsList(file);
        HashMap<String, Integer> frequencyMap = new LinkedHashMap<>();

        for (String word : words) {
            if (!frequencyMap.containsKey(word)) {
                frequencyMap.put(word, 1);
                continue;
            }
            frequencyMap.put(word, frequencyMap.get(word) + 1);
        }

        return frequencyMap;
    }
}