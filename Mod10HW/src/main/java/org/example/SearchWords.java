package org.example;


import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SearchWords {
    static String file = "words.txt";

    public static String wordsCounts(String file) throws IOException {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> wordFreqMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (wordFreqMap.containsKey(word)) {
                wordFreqMap.put(word, wordFreqMap.get(word) + 1);
            } else {
                wordFreqMap.put(word, 1);
            }
        }
        scanner.close();
        wordFreqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

        return result.toString();
    }


    public static void main(String[] args) throws IOException {
        System.out.println(wordsCounts(file));
    }

}