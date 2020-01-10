package patterns.cursach;

import org.springframework.stereotype.Service;
import patterns.cursach.constants.FactoryMods;
import patterns.cursach.factory.ContainerFactory;
import patterns.cursach.factory.TextContainer;
import patterns.cursach.stemmer.PorterStemmer;


public class Censor {
    public String startCensorship(String text, FactoryMods mod) {
        TextContainer container = ContainerFactory.getContainer(text, mod);

        return null;
    }
}
