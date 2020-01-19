package patterns.cursach;

import patterns.cursach.censorshipstrategy.CensorshipStrategy;
import patterns.cursach.constants.FactoryMods;
import patterns.cursach.dictionary.Dictionary;
import patterns.cursach.factory.ContainerFactory;
import patterns.cursach.factory.TextContainer;
import patterns.cursach.iterator.Iterator;
import patterns.cursach.searcher.Searcher;
import patterns.cursach.stemmer.Stemmer;

import java.util.List;


public class Censor {
    private Searcher searcher;
    private Stemmer stemmer;
    private int errorCount;
    private CensorshipStrategy censorshipStrategy;

    public String startCensorship(String text,
                                  FactoryMods mod) {

        TextContainer container = ContainerFactory.getContainer(text, mod);
        errorCount = 2;

        Dictionary dictionary = Dictionary.getInstance();
        List<String> wordList = dictionary.getBadWords();

        Iterator i = container.getIterator();
        while (i.hasNext()) {
            String currentWord = i.getNextWord();
            boolean target = false;
            for (String bad: wordList) {
                target = searcher.compare(errorCount, stemmer.stem(currentWord), bad);
                if (target) {
                    System.out.println(i.getCurrentWord() + " " + bad);
                    break;
                }
            }
            if (target) {
                i = container.replace(i, censorshipStrategy.replace(i.getCurrentWord()));
            }
        }

        return container.getText();
    }

    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

    public void setStemmer(Stemmer stemmer) {
        this.stemmer = stemmer;
    }

    public void setCensorshipStrategy(CensorshipStrategy censorshipStrategy) {
        this.censorshipStrategy = censorshipStrategy;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }
}
