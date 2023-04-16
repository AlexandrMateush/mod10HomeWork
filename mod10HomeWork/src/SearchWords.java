import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class SearchWords {
    static String file = "words.txt";

    public static String wordsCount(String file) throws IOException {
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            line = reader.readLine();
        }
        reader.close();
        for (String word : wordCount.keySet()) {
           result.append(word).append(" ").append(wordCount.get(word)).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(wordsCount(file));
    }

}

