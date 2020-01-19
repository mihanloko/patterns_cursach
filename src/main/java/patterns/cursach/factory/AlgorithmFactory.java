package patterns.cursach.factory;

import patterns.cursach.constants.Algorithm;
import patterns.cursach.searcher.LevensteinDistance;
import patterns.cursach.searcher.Searcher;

public class AlgorithmFactory {

    public static Searcher getAlgorithm(int algorithm) {
        switch (algorithm) {
            case 1:
                return new LevensteinDistance();
        }
        return null;
    }

}
