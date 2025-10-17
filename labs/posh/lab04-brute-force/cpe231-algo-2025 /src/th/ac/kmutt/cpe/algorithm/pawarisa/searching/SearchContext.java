package th.ac.kmutt.cpe.algorithm.pawarisa.searching;

public class SearchContext<T extends Comparable<T>> {
    private SearchStrategy<T> strategy;

    public SearchContext(SearchStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setSearchStrategy(SearchStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public int executeBeadsSearch(String beads, char target1, char target2, int size) {
        return strategy.searchBeads(beads, target1, target2, size);
    }
}