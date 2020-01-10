package patterns.cursach.factory;

import patterns.cursach.constants.FactoryMods;
import patterns.cursach.textgetters.SimpleTextGetter;
import patterns.cursach.textgetters.TextGetter;

public class ContainerFactory {

    public static TextContainer getContainer(String text, FactoryMods mod) {
        TextGetter getter = null;
        switch (mod) {
            case URL:
                break;
            case File:
                break;
            case SimpleText:
                getter = new SimpleTextGetter(text);
                break;
        }
        if (getter != null)
            return getter.getText();
        else {
            return null;
        }
    }
}
