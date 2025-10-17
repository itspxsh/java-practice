package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

public class Parcel {
    private final double width;
    private final double height;
    private double x = Double.NaN;
    private double y = Double.NaN;
    private boolean placed = false;
    private final String id;

    public Parcel(String id, double width, double height) {
        this.id = id == null ? "" : id;
        this.width = width;
        this.height = height;
    }

    public Parcel(double width, double height) {
        this("", width, height);
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getX() { return x; }
    public double getY() { return y; }
    public boolean isPlaced() { return placed; }
    public String getId() { return id; }

    public double area() { return width * height; }
    public double maxSide() { return Math.max(width, height); }

    public void placeAt(double x, double y) {
        this.x = x;
        this.y = y;
        this.placed = true;
    }

   @Override
    public String toString() {
        // แก้ไขให้แสดงเฉพาะ ID, WxH, Area และสถานะ (placed/not placed)
        if (placed) {
            return String.format("Parcel[%s] (%.2f x %.2f) (Area: %.2f) - PLACED", 
                id, width, height, area());
        } else {
            return String.format("Parcel[%s] (%.2f x %.2f) (Area: %.2f) - SKIPPED", 
                id, width, height, area());
        }
    }
}