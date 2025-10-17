package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.util.ArrayList;
import java.util.List;

/**
 * Horizontal shelf used by the BFDH algorithm.
 */
public class Shelf {
    public final double y;        // vertical offset (from top or bottom consistently)
    public final double height;   // shelf height
    public double usedWidth = 0.0;
    public final List<Parcel> items = new ArrayList<>();

    public Shelf(double y, double height) {
        this.y = y;
        this.height = height;
    }

    public double freeWidth(double containerWidth) {
        return containerWidth - usedWidth;
    }

    public boolean canFit(Parcel p, double containerWidth) {
        return p.getHeight() <= height && p.getWidth() <= freeWidth(containerWidth);
    }

    /** Places parcel at the current usedWidth position (left-to-right). */
    public void place(Parcel p) {
        p.placeAt(usedWidth, y);
        items.add(p);
        usedWidth += p.getWidth();
    }
}
