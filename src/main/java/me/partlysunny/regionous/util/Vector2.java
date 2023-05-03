package me.partlysunny.regionous.util;

import org.bukkit.Location;

public class Vector2 {

    private double a;
    private double b;

    public Vector2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static Vector2 fromLocationXZ(Location location) {
        return new Vector2((double) location.getX(), (double) location.getZ());
    }

    public double distanceSquared(Vector2 other) {
        return (double) (Math.pow(other.a - a, 2) + Math.pow(other.b - b, 2));
    }

    public double distance(Vector2 other) {
        return (double) Math.sqrt(distanceSquared(other));
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void set(double a, double b) {
        setA(a);
        setB(b);
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(a + other.a, b + other.b);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(a - other.a, b - other.b);
    }

    public Vector2 multiply(Vector2 other) {
        return new Vector2(a * other.a, b * other.b);
    }

    public Vector2 normalize() {
        return new Vector2(a / length(), b / length());
    }

    public double lengthSquared() {
        return (double) (Math.pow(a, 2) + Math.pow(b, 2));
    }

    public double length() {
        return (double) Math.sqrt(lengthSquared());
    }

}
