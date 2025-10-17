package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.util.ArrayList;
import java.util.List;

public class FirstFitDecreasingStrategy implements PackingStrategy {
    @Override
    public PackResult pack(Box box, List<Parcel> parcels) {
        List<Parcel> notPlaced = new ArrayList<>();
        for (Parcel p : parcels) {
            if (!box.placeTopLeft(p)) {
                notPlaced.add(p);
            }
        }
        return new PackResult(box, notPlaced);
    }
}