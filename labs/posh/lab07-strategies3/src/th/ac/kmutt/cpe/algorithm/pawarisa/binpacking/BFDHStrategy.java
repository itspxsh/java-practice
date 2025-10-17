package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Best-Fit Decreasing Height (BFDH) implementation.
 *
 * 1. Sort descending by height (tiebreaker width).
 * 2. For each parcel, place into the shelf that fits and leaves least leftover width (tightest).
 * 3. If none fits, create a new shelf if vertical space remains.
 */
public class BFDHStrategy implements PackingStrategy {

    @Override
    public void pack(double containerWidth, double containerHeight, List<Parcel> parcels) {
        // Defensive: mark all unplaced initially
        for (Parcel p : parcels) {
            // no-op; constructor already sets unplaced, but keep for clarity
        }

        // sort by height desc then width desc
        parcels.sort(Comparator.<Parcel>comparingDouble((Parcel p) -> -p.getHeight())
                .thenComparingDouble(p -> -p.getWidth()));

        List<Shelf> shelves = new ArrayList<>();
        double currentY = 0.0; // tracks used vertical height (top to bottom)

        for (Parcel p : parcels) {
            // reject if too large for container at all
            if (p.getWidth() > containerWidth || p.getHeight() > containerHeight) {
                // can't ever place this parcel
                continue;
            }

            Shelf best = null;
            double bestLeftover = Double.POSITIVE_INFINITY;

            for (Shelf s : shelves) {
                if (s.canFit(p, containerWidth)) {
                    double leftover = s.freeWidth(containerWidth) - p.getWidth();
                    if (leftover < bestLeftover) {
                        bestLeftover = leftover;
                        best = s;
                    }
                }
            }

            if (best != null) {
                best.place(p);
                continue;
            }

            // create new shelf if there is vertical space left
            if (currentY + p.getHeight() <= containerHeight + 1e-9) {
                Shelf s = new Shelf(currentY, p.getHeight());
                s.place(p);
                shelves.add(s);
                currentY += p.getHeight();
            } else {
                // cannot place this parcel within the container height
            }
        }
    }
}
