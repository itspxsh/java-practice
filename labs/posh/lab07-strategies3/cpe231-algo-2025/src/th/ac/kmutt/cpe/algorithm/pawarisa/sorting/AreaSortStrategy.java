package th.ac.kmutt.cpe.algorithm.pawarisa.sorting;

import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.Parcel;

import java.util.Comparator;
import java.util.List;

public class AreaSortStrategy implements ParcelSortStrategy {
    @Override
    public void sort(List<Parcel> parcels) {
        parcels.sort(Comparator.comparingDouble(Parcel::area).reversed());
    }
}