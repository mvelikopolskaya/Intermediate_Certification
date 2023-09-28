package model.toystore;

import model.toy.Toy;
import model.toy.ToyIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyStore implements Iterable<Toy> {
    private List<Toy> toyStore;

    public ToyStore() {
        toyStore = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toyStore.add(toy);
    }

    public void clearToyStore(){
        toyStore.clear();
    }

    public Toy getToy(int index){
        return toyStore.get(index);
    }
    public void removeToy(int index){
        toyStore.remove(index);
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyIterator(toyStore);
    }
}
