package patterns.cursach.censorshipstrategy;

import patterns.cursach.dictionary.Dictionary;
import patterns.cursach.factory.TextContainer;
import patterns.cursach.searcher.Searcher;
import patterns.cursach.stemmer.Stemmer;


public interface CensorshipStrategy {
    String replace(String word);
}
