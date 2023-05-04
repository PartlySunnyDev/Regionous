package me.partlysunny.regionous.util;

import org.bukkit.Location;

public class Loc2D {

    private double x;
    private double z;

    public Loc2D(double x, double z) {
        this.x = x;
        this.z = z;
    }

    public static Loc2D fromLocationXZ(Location location) {
        return new Loc2D(location.getX(), location.getZ());
    }

    public double distanceSquared(Loc2D other) {
        return Math.pow(other.x - x, 2) + Math.pow(other.z - z, 2);
    }

    public double distance(Loc2D other) {
        return Math.sqrt(distanceSquared(other));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void set(double x, double z) {
        setX(x);
        setZ(z);
    }

    public Loc2D add(Loc2D other) {
        return new Loc2D(x + other.x, z + other.z);
    }

    public Loc2D subtract(Loc2D other) {
        return new Loc2D(x - other.x, z - other.z);
    }

    public Loc2D multiply(Loc2D other) {
        return new Loc2D(x * other.x, z * other.z);
    }

    public Loc2D normalize() {
        return new Loc2D(x / length(), z / length());
    }

    public double lengthSquared() {
        return (double) (Math.pow(x, 2) + Math.pow(z, 2));
    }

    public double length() {
        return (double) Math.sqrt(lengthSquared());
    }

}
