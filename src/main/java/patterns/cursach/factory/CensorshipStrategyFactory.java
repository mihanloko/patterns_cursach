package patterns.cursach.factory;

import patterns.cursach.censorshipstrategy.CensorshipStrategy;
import patterns.cursach.censorshipstrategy.DeleteStrategy;
import patterns.cursach.censorshipstrategy.ReplacementStrategy;
import patterns.cursach.constants.Strategy;

public class CensorshipStrategyFactory {

    public static CensorshipStrategy getStrategy(int strategy) {
        switch (strategy) {
            case 2:
                return new DeleteStrategy();
            case 1:
                return new ReplacementStrategy();
        }
        return null;
    }

}
