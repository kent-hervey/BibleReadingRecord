package services;

public class BibleBook {
    private String name;
    private int numChapters;

    public BibleBook(String name, int numChapters) {
        this.name = name;
        this.numChapters = numChapters;
    }

    public BibleBook() {
    }

    // Getters and setters (you can generate these in most IDEs)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumChapters() {
        return numChapters;
    }

    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }
}
