package th.ac.kmutt.cpe.algorithm.pawarisa.searching;

import java.util.ArrayList;

public interface SearchStrategy<T extends Comparable<T>, R> {
    R search(ArrayList<T> list, T target);
}
