package patterns.cursach.dictionary;

import patterns.cursach.stemmer.PorterStemmer;
import patterns.cursach.stemmer.Stemmer;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    private static Dictionary instance;
    private List<String> badWords = new LinkedList<>();

    private Dictionary(Stemmer stemmer) {
        LinkedList<String> words = new LinkedList<>();
        InputStream wordList = Dictionary.class.getResourceAsStream("/static/wordlist1.txt");
        Scanner scanner = new Scanner(wordList);
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();

        for (String word: words)
            badWords.add(stemmer.stem(word));
    }

    public static Dictionary getInstance(Stemmer stemmer) {
        if (instance == null) {
            instance = new Dictionary(stemmer);
        }
        return instance;
    }

    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new Dictionary(new PorterStemmer());
        }
        return instance;
    }

    public List<String> getBadWords() {
        return badWords;
    }
}
