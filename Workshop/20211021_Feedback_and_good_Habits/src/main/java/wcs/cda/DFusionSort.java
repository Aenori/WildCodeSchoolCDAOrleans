package wcs.cda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFusionSort {
    // Implémenter le fusion sort.
    // Il s'agit d'un algorithme de tri récursif qui fonctionne
    // de la façon suivante :
    //
    // 1. Si je reçois une liste de taille 1, elle est considérée
    //    comme triée
    // 2. Sinon je coupe la liste en deux, m'appelle récursivement
    //    et fusionne les deux listes triées en respectant l'ordre.
    //
    // Exemple : si je veux trier [2, 1]
    //
    // 1. Je la sépare en deux listes [1] [2]
    // 2. Je trie chacune des listes en appelant la méthode
    //    récursivement
    // 3. Je fusionne les deux
    //
    // La fusion respecte l'ordre:
    //
    // fusion([1, 3], [2, 4]) => [1, 2, 3, 4]
    //
    // Commencer par implémenter la méthode merge (fusion en anglais)
    public static void main(String[] args) {
        ArrayList<Integer> testArray = new ArrayList<>();

        for(int i = 0; i < 10; ++i) {
            testArray.add(i);
        }

        Collections.shuffle(testArray);
        sort(testArray);
    }

    public static void sort(List<Integer> testArray) {
        List<Integer> sorted = sort(testArray, 0);
        testArray.clear();
        testArray.addAll(sorted);
    }

    public static List<Integer> sort(List<Integer> testArray, int depth) {
        /*for(int i = 0; i < depth; ++i) {
            System.out.print("  ");
        }
        System.out.println("called for " + testArray.toString());
        */
        if(testArray.size() == 1) {
            return testArray;
        }

        List<Integer> firstHalf = testArray.subList(0, testArray.size() / 2);
        List<Integer> secondHalf = testArray.subList(testArray.size() / 2,
                testArray.size());

        List<Integer> result = merge(
                sort(firstHalf, depth + 1),
                sort(secondHalf, depth + 1)
        );

        /*for(int i = 0; i < depth; ++i) {
            System.out.print("  ");
        }
        System.out.println("result => " + result.toString());*/

        return result;
    }

    private static void splitInputList(
            List<Integer> testArray,
            List<Integer> firstHalf,
            List<Integer> secondHalf
    ) {
        for(int i = 0; i < testArray.size(); ++i) {
            if(i < testArray.size() / 2) {
                firstHalf.add(testArray.get(i));
            }
            else {
                secondHalf.add(testArray.get(i));
            }
        }
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();

        int list1pos = 0;
        int list2pos = 0;

        while(list1pos != list1.size() && list2pos != list2.size()) {
            if(list1.get(list1pos) < list2.get(list2pos)) {
                result.add(list1.get(list1pos));
                list1pos++;
            }
            else{
                result.add(list2.get(list2pos));
                list2pos++;
            }
        }

        for(;list1pos != list1.size(); list1pos++) {
            result.add(list1.get(list1pos));
        }
        for(;list2pos != list2.size(); list2pos++) {
            result.add(list2.get(list2pos));
        }

        return result;
    }
}
