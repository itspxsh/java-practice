package th.ac.kmutt.cpe.algorithm.pawarisa.searching;

import java.util.ArrayList;

public class EMSSearch<T extends Comparable<T>> implements SearchStrategy<T, Integer> {
    public Integer search(ArrayList<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(target) > 0) {
                return i - 1;
            }
        }
        return -1;
    }
}