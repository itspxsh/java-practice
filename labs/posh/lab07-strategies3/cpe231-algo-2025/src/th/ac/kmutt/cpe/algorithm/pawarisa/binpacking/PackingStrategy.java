package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.util.List;

public interface PackingStrategy {
    /**
     * Pack parcels into a single container sized containerWidth x containerHeight.
     * Parcels list will be mutated: Parcel.placeAt(...) & Parcel.isPlaced() used.
     */
    void pack(double containerWidth, double containerHeight, List<Parcel> parcels);
}
