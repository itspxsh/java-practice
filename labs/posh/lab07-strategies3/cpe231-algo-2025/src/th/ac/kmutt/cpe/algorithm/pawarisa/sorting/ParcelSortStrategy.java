package th.ac.kmutt.cpe.algorithm.pawarisa.sorting;

import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.Parcel;
import java.util.List;

public interface ParcelSortStrategy {
    void sort(List<Parcel> parcels);
}