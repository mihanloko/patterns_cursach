package patterns.cursach.textgetters;

import patterns.cursach.factory.TextContainer;

public class SimpleTextGetter implements TextGetter {
    private String text;

    public SimpleTextGetter(String text) {
        this.text = text;
    }

    @Override
    public TextContainer getText() {
        return new TextContainer(text);
    }
}
