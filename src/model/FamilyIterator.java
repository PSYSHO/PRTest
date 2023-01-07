package model;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<Human> {

    private List<Human> humans;
    private int index;

    public FamilyIterator(List<Human> members) {
        this.humans = members;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(index++);
    }
}
