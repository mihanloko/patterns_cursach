package patterns.cursach.censorshipstrategy;

import patterns.cursach.searcher.Searcher;
import patterns.cursach.stemmer.Stemmer;

public class ReplacementStrategy implements CensorshipStrategy {

    private int replacementCount;

    public ReplacementStrategy(int replacementCount) {
        this.replacementCount = replacementCount;
    }

    public ReplacementStrategy() {
        this.replacementCount = 3;
    }

    @Override
    public String replace(String word) {
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
