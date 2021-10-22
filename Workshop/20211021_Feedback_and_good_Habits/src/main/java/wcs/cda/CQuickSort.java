package wcs.cda;

import java.util.ArrayList;
import java.util.Collections;

// There is nothing to do in this file, it is just an example
public class CQuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> testArray = new ArrayList<>();

        for(int i = 0; i < 10; ++i) {
            testArray.add(i);
        }

        Collections.shuffle(testArray);
        sort(testArray);
    }

    // This algorithm is the quick sort, it work by finding a value (the pivot)
    public static void sort(ArrayList<Integer> arrayList) {
        sort(arrayList, 0, arrayList.size(), 0);
    }

    public static void sort(ArrayList<Integer> arrayList, int start, int end, int depth) {
        /*for(int i = 0; i < depth; ++i) {
            System.out.print("  ");
        }
        System.out.println("=> called " + arrayList.toString() + " " + start + "/" + end);
        */
        if(end - start < 2) return;
        int initialStart = start;
        int initialEnd = end;

        for(int i = 0; i < depth; ++i) {
            System.out.print("  ");
        }

        int pivotValue = arrayList.get(end - 1);
        // System.out.println("pivot value " + pivotValue);
        end--;

        while(end - start > 0) {
            if(arrayList.get(start) < pivotValue) {
                start++;
                continue;
            }
            if(arrayList.get(end - 1) >= pivotValue) {
                end--;
                continue;
            }
            switchValues(arrayList, start, end - 1);
            start++;
            end--;
        }

        switchValues(arrayList, start, initialEnd - 1);

        sort(arrayList, initialStart, start, depth + 1);
        sort(arrayList, start + 1, initialEnd, depth + 1);
    }

    private static void switchValues(ArrayList<Integer> arrayList, int first, int second) {
        int temp = arrayList.get(second);
        arrayList.set(second, arrayList.get(first));
        arrayList.set(first, temp);
    }
}
