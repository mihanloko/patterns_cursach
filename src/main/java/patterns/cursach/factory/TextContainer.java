package patterns.cursach.factory;

import patterns.cursach.iterator.Iterable;
import patterns.cursach.iterator.Iterator;

public class TextContainer implements Iterable {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    @Override
    public Iterator getIterator() {
        return null;//TODO make iterator
    }
}
