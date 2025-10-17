package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

/**
 * Simple parcel model used by the solver.
 */
public class Parcel {
    private final String id;
    private final double width;
    private final double height;

    // position after packing (top-left origin assumed)
    private double x = -1;
    private double y = -1;
    private boolean placed = false;

    public Parcel(String id, double width, double height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public String getId() { return id; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getX() { return x; }
    public double getY() { return y; }
    public boolean isPlaced() { return placed; }

    public void placeAt(double x, double y) {
        this.x = x;
        this.y = y;
        this.placed = true;
    }

    public double area() { return width * height; }

    @Override
    public String toString() {
        return String.format("%s (w=%.2f, h=%.2f) placed=%s at (%.2f, %.2f)",
                id, width, height, placed, x, y);
    }
}
