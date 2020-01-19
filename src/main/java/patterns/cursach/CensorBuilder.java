package patterns.cursach;

import patterns.cursach.censorshipstrategy.CensorshipStrategy;
import patterns.cursach.constants.Algorithm;
import patterns.cursach.constants.Stemming;
import patterns.cursach.constants.Strategy;
import patterns.cursach.factory.AlgorithmFactory;
import patterns.cursach.factory.CensorshipStrategyFactory;
import patterns.cursach.factory.StemmerFactory;
import patterns.cursach.searcher.Searcher;
import patterns.cursach.stemmer.Stemmer;

public class CensorBuilder {
    private Censor censor;

    void reset() {
        censor = new Censor();
    }

    public CensorBuilder() {
        this.reset();
    }

    public CensorBuilder addStrategy(int strategy) {
        censor.setCensorshipStrategy(CensorshipStrategyFactory.getStrategy(strategy));
        return this;
    }

    public CensorBuilder addSearcher(int algorithm) {
        censor.setSearcher(AlgorithmFactory.getAlgorithm(algorithm));
        return this;
    }

    public CensorBuilder addStemmer(int stemming) {
        censor.setStemmer(StemmerFactory.getStemmer(stemming));
        return this;
    }

    public Censor build() {
        Censor result = censor;
        reset();
        return result;
    }
}
