package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box {
    private final double width;
    private final double height;
    private final List<Parcel> placed = new ArrayList<>();
    private static final double EPS = 1e-9;

    public Box(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public boolean canPlaceAt(Parcel parcel, double x, double y) {
        if (x + parcel.getWidth() - EPS > width) return false;
        if (y + parcel.getHeight() - EPS > height) return false;
        if (x < -EPS || y < -EPS) return false;

        for (Parcel p : placed) {
            boolean noOverlap = (x + parcel.getWidth() <= p.getX() + EPS) ||
                                (p.getX() + p.getWidth() <= x + EPS) ||
                                (y + parcel.getHeight() <= p.getY() + EPS) ||
                                (p.getY() + p.getHeight() <= y + EPS);
            if (!noOverlap) return false;
        }
        return true;
    }

    public boolean placeTopLeft(Parcel parcel) {
        if (placed.isEmpty()) {
            double startY = height - parcel.getHeight();
            if (canPlaceAt(parcel, 0.0, startY)) {
                parcel.placeAt(0.0, startY);
                placed.add(parcel);
                return true;
            }
            return false;
        }

        List<double[]> candidates = new ArrayList<>();
        candidates.add(new double[]{0.0, height - parcel.getHeight()});

        for (Parcel p : placed) {
            candidates.add(new double[]{p.getX() + p.getWidth(), p.getY()});
            candidates.add(new double[]{p.getX(), p.getY() - parcel.getHeight()});
        }

        candidates.sort(Comparator.<double[]>comparingDouble(a -> -a[1])  // y desc
                .thenComparingDouble(a -> a[0])); // x asc

        for (double[] pos : candidates) {
            if (canPlaceAt(parcel, pos[0], pos[1])) {
                parcel.placeAt(pos[0], pos[1]);
                placed.add(parcel);
                return true;
            }
        }
        return false;
    }

    public double usedArea() {
        return placed.stream().mapToDouble(Parcel::area).sum();
    }

    public double remainingArea() {
        return width * height - usedArea();
    }

    public List<Parcel> getPlaced() { return placed; }

    @Override
    public String toString() {
        return String.format("Box(%.2f x %.2f) placed=%d used=%.2f remain=%.2f",
                width, height, placed.size(), usedArea(), remainingArea());
    }
}