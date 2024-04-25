package day_one.assertj;

public class Item implements Comparable<Item> {

    private int size;
    private String description;

    public Item(int size, String description) {
        this.size = size;
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Item o) {
        return this.description.compareTo(o.description);
    }

    @Override
    public String toString() {
        return description;
    }
}
