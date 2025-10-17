package th.ac.kmutt.cpe.algorithm.pawarisa.sorting;

import java.util.ArrayList;

public class SortContext<T extends Comparable<T>> {
    private SortStrategy<T> strategy;

    public SortContext(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setSortStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public int executeSort(ArrayList<T> list, T target) {
        return strategy.sort(list);
    }
}