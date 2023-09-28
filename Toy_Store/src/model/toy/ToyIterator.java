package model.toy;

import java.util.Iterator;
import java.util.List;

public class ToyIterator implements Iterator<Toy> {
    private int index;
    private List<Toy> toyStore;

    public ToyIterator(List<Toy> toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public boolean hasNext() {
        return toyStore.size() > index;
    }

    @Override
    public Toy next() {
        return toyStore.get(index++);
    }
}
