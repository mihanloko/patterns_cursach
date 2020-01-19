package patterns.cursach.iterator;

public interface Iterator {
    String getNextWord();
    boolean hasNext();
    String getCurrentWord();

    int getLeftPosition();
    int getRightPosition();
}
