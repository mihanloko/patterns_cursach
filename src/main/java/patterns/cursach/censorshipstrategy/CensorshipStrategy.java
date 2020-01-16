package patterns.cursach.censorshipstrategy;

import patterns.cursach.dictionary.Dictionary;
import patterns.cursach.factory.TextContainer;
import patterns.cursach.searcher.Searcher;
import patterns.cursach.stemmer.Stemmer;


public abstract class CensorshipStrategy {
    protected Searcher searcher;
    protected Stemmer stemmer;
    protected Dictionary dictionary = null;

    public CensorshipStrategy(Searcher searcher, Stemmer stemmer) {
        this.searcher = searcher;
        this.stemmer = stemmer;
        dictionary = Dictionary.getInstance(stemmer);
    }

    public CensorshipStrategy() {
        searcher = null;
        stemmer = null;
        dictionary = Dictionary.getInstance();
    }

    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

    public void setStemmer(Stemmer stemmer) {
        this.stemmer = stemmer;
    }

    public abstract TextContainer execute(TextContainer container, int errorCount);

}
