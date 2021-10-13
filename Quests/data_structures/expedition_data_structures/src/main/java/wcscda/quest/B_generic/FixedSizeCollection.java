package wcscda.quest.B_generic;

import wcscda.quest.Sentinel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FixedSizeCollection<T> implements Collection<T> {
    private int maxSize;
    private T[] array;
    private int currentSize;

    public FixedSizeCollection(Class<T> clazz, int maxSize) {
        this.maxSize = maxSize;
        array = (T[])Array.newInstance(clazz, maxSize);
        currentSize = 0;
    }

    @Override
    public int size() {
       int n=0;
		for (int i = 0; i < array.length; i++) {
    		if(array[i]==null) {
    			n=n+1;
    
    		}
    	}
        return array.length-n;
    }

    @Override
    public boolean isEmpty() {
    	if(size()>0) {
    		return false;
    		
    	}  return true;
    }

    @Override
    public boolean contains(Object o) {
    	for(int i = 0; i < array.length; i++) {
    		if(o==array[i]) {
    			return true;
    		};
    		
    	}
    	
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
    	if(currentSize == maxSize) {
            return false;
        }
        else {
            array[currentSize++] = t;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
    	int b = array.length;
    	for(int i=0;i<b;i++) {
    		if(o==array[i]) {
    			
    			//return true;
    		while(i<b-1) {
    				array[i]=array[i+1];
    				i++;
    				
    			}
    		array[i]=null;
    				return true;
    		}
    		
    		
    	}

		return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
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
