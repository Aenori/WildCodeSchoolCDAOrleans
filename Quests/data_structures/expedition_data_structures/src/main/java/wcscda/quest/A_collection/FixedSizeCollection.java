package wcscda.quest.A_collection;

import wcscda.quest.Sentinel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class FixedSizeCollection implements Collection<Integer> {
    private int maxSize;
    private Integer[] array;
    private int currentSize;

    public FixedSizeCollection(int maxSize) {
        this.maxSize = maxSize;
        array = new Integer[maxSize];
        currentSize = 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Integer i: array) {
            if(o.equals(i)) return true;
        }

        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if(currentSize == maxSize) {
            return false;
        }
        else {
            array[currentSize++] = integer;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if(o == null) return false;

        boolean found = false;

        for(int i = 0; i < currentSize; ++i) {
            if (o.equals(array[i])) {
                found = true;
            }
            if (found) {
                if (i == currentSize - 1) {
                    array[i] = null;
                } else {
                    array[i] = array[i + 1];
                }
            }
        }

        if(found) --currentSize;

        return found;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}