package patterns.cursach.iterator;

public interface Iterator {
    String getNextWord();
    boolean hasNext();

    int getLeftPosition();
    int getRightPosition();
}
