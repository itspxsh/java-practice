package th.ac.kmutt.cpe.algorithm.pawarisa.sorting;

import java.util.ArrayList;

public interface SortStrategy<T extends Comparable<T>> {
    void sort(ArrayList<T> list);
}