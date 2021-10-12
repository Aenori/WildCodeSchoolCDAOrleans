package wcscda.quest.A_collection;

import wcscda.quest.Sentinel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;



public class FixedSizeCollection implements Collection<Integer> {
    private Integer[] array;
    private int currentSize;
    private int maxSize;

    public FixedSizeCollection(int maxSize) {
    	this.maxSize = maxSize;
    	array = new Integer[maxSize];
    	maxSize=0;
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