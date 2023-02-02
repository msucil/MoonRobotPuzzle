package com.msucil.exercise.robot.model;

import java.util.Objects;

public class Surface {
    private final int x;

    private final int y;

    public Surface(int x, int maxY) {
        this.x = x;
        this.y = maxY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surface surface)) return false;
        return getX() == surface.getX() && getY() == surface.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Surface{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
