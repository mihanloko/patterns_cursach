package patterns.cursach.dictionary;

import patterns.cursach.stemmer.PorterStemmer;
import patterns.cursach.stemmer.Stemmer;

import java.util.LinkedList;
import java.util.List;

public class Dictionary {
    private static Dictionary instance;
    private List<String> badWords = new LinkedList<>();

    private Dictionary(Stemmer stemmer) {
        //todo подумать что тут будет, что и откуда брать. можно ли в курсаче ругаться
        String[] words = {"пример", "ругательство", "пидор"};
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
