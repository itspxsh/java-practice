package th.ac.kmutt.cpe.algorithm.pawarisa.searching;

public interface SearchStrategy<T extends Comparable<T>> {
    int searchBeads(String beads, char target1, char target2, int size);
}