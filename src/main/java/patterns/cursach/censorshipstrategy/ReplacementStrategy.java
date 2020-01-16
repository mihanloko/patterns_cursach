package patterns.cursach.censorshipstrategy;

import patterns.cursach.factory.TextContainer;
import patterns.cursach.iterator.Iterator;
import patterns.cursach.searcher.Searcher;
import patterns.cursach.stemmer.Stemmer;

import java.util.List;

public class ReplacementStrategy extends CensorshipStrategy {

    private int replacementCount;

    public ReplacementStrategy(Searcher searcher, Stemmer stemmer, int replacementCount) {
        super(searcher, stemmer);
        this.replacementCount = replacementCount;
    }

    @Override
    public TextContainer execute(TextContainer container, int errorCount) {
        List<String> wordList = dictionary.getBadWords();
        Iterator i = container.getIterator();
        while (i.hasNext()) {
            String currentWord = i.getNextWord();
            boolean target = false;
            for (String bad: wordList) {
                target = searcher.compare(errorCount, stemmer.stem(currentWord), bad);
                if (target) break;
            }
            if (target) {
                i = container.replace(i, replace(currentWord));
            }

        }
        return null;
    }

    private String replace(String word) {
        StringBuilder result = new StringBuilder();
        if (word.length() <= replacementCount) {
            for (int i = 0; i < word.length(); i++)
                result.append('*');
        }
        else {
            result.append(word.charAt(0));
            for (int i = 0; i < replacementCount; i++)
                result.append('*');
            for (int i = replacementCount + 1; i < word.length(); i++)
                result.append(word.charAt(i));
        }
        return result.toString();
    }
}
