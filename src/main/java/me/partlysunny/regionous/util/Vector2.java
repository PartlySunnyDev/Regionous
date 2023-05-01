package me.partlysunny.regionous.util;

import org.bukkit.Location;

public class Vector2 {

    private float a;
    private float b;

    public Vector2(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float distanceSquared(Vector2 other) {
        return (float) (Math.pow(other.a - a, 2) + Math.pow(other.b - b, 2));
    }

    public float distance(Vector2 other) {
        return (float) Math.sqrt(distanceSquared(other));
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void set(float a, float b) {
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

    public float lengthSquared() {
        return (float) (Math.pow(a, 2) + Math.pow(b, 2));
    }

    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public static Vector2 fromLocationXZ(Location location) {
        return new Vector2((float) location.getX(), (float) location.getZ());
    }

}
