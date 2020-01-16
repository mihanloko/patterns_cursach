package patterns.cursach.iterator;

public class SimpleIterator implements Iterator {

    private int currentPosition = 0, lastWordStartPosition = 0;
    private String text;

    public SimpleIterator(String text) {
        this.text = text;
        currentPosition = 0;
        lastWordStartPosition = 0;
    }

    public int getLeftPosition() {
        return lastWordStartPosition;
    }

    public int getRightPosition() {
        return currentPosition;
    }

    public SimpleIterator(int lastWordStartPosition, int currentPosition, String text) {
        this.currentPosition = currentPosition;
        this.lastWordStartPosition = lastWordStartPosition;
        this.text = text;
    }

    private void skipSeparators() {
        while (currentPosition < text.length() &&
                (text.charAt(currentPosition) == ' ' || text.charAt(currentPosition) == '\n' ||
                text.charAt(currentPosition) == ',' || text.charAt(currentPosition) == '.' ||
                text.charAt(currentPosition) == '?' || text.charAt(currentPosition) == '!' ||
                text.charAt(currentPosition) == '-' || text.charAt(currentPosition) == '\t'))
            currentPosition++;
    }

    @Override
    public String getNextWord() {
        skipSeparators();
        lastWordStartPosition = currentPosition;
        while (currentPosition < text.length() && text.charAt(currentPosition) != ' ' && text.charAt(currentPosition) != '\n' &&
                text.charAt(currentPosition) != ',' && text.charAt(currentPosition) != '.' &&
                text.charAt(currentPosition) != '?' && text.charAt(currentPosition) != '!' &&
                text.charAt(currentPosition) != '\t')
            currentPosition++;
        return text.substring(lastWordStartPosition, currentPosition);
    }

    @Override
    public boolean hasNext() {
        skipSeparators();
        return currentPosition < text.length();
    }
}
