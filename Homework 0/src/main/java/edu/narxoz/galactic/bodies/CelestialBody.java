package main.java.edu.narxoz.galactic.bodies;
public abstract class CelestialBody {
    private String name;
    private double x;
    private double y;
    protected CelestialBody(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double distanceTo(CelestialBody other) {
        if (other == null) throw new IllegalArgumentException("Can't be null");
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}