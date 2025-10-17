package th.ac.kmutt.cpe.algorithm.pawarisa.sorting;

import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.Parcel;
import java.util.List;

public class SortContext {
    private ParcelSortStrategy strategy;

    public SortContext(ParcelSortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Parcel> parcels) {
        strategy.sort(parcels);
    }
}