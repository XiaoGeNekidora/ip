package litsewei.util;

/**
 * A simple class to store a pair of an index and an item. <br/>
 * @param <T> - the type of the item in the pair. <br/>
 */
public class Pair<T>{
    public int index;
    public T item;

    /**
     * Constructs a Pair.
     * @param index the index
     * @param item the item
     */
    public Pair(int index, T item) {
        this.index = index;
        this.item = item;
    }
}