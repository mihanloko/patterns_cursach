package patterns.cursach.factory;

import patterns.cursach.iterator.Iterable;
import patterns.cursach.iterator.Iterator;
import patterns.cursach.iterator.SimpleIterator;

public class TextContainer implements Iterable {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    @Override
    public Iterator getIterator() {
        return new SimpleIterator(text);//TODO make iterator
    }

    public Iterator replace(Iterator i, String newString) {
        int delta = i.getRightPosition() - i.getLeftPosition() - newString.length();
        StringBuilder newText = new StringBuilder(text.substring(0, i.getLeftPosition()));
        newText.append(newString);
        newText.append(text.substring(i.getRightPosition()));
        this.text = newText.toString();
        return new SimpleIterator(i.getLeftPosition(), i.getRightPosition() - delta, text);
    }

    public String getText() {
        return text;
    }
}
