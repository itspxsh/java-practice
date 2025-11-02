package th.ac.kmutt.cpe.algorithm.pawarisa.searching;

import java.util.ArrayList;

public class MultipleLinearSearch<T extends Comparable<T>> implements SearchStrategy<T, ArrayList<Integer>> {
    public ArrayList<Integer> search(ArrayList<T> list, T target) {
        ArrayList<Integer> foundIndices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                foundIndices.add(i);
            }
        }
        return foundIndices;
    }
}