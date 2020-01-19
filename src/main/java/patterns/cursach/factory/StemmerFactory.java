package patterns.cursach.factory;

import patterns.cursach.constants.Stemming;
import patterns.cursach.stemmer.PorterStemmer;
import patterns.cursach.stemmer.Stemmer;

public class StemmerFactory {
    public static Stemmer getStemmer(int stemming) {
        switch (stemming) {
            case 1:
                return new PorterStemmer();
        }
        return null;
    }
}
