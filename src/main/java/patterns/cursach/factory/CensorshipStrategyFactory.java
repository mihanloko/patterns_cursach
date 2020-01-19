package patterns.cursach.factory;

import patterns.cursach.censorshipstrategy.CensorshipStrategy;
import patterns.cursach.censorshipstrategy.ReplacementStrategy;
import patterns.cursach.constants.Strategy;

public class CensorshipStrategyFactory {

    public static CensorshipStrategy getStrategy(int strategy) {
        switch (strategy) {
            case 2:
            case 1:
                return new ReplacementStrategy();
        }
        return null;
    }

}
