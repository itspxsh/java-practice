package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.util.List;

public interface PackingStrategy {
    PackResult pack(Box box, List<Parcel> parcels);

    class PackResult {
        private final Box box;
        private final List<Parcel> notPlaced;

        public PackResult(Box box, List<Parcel> notPlaced) {
            this.box = box;
            this.notPlaced = notPlaced;
        }

        public Box getBox() { return box; }
        public List<Parcel> getNotPlaced() { return notPlaced; }
    }
}