package com.msucil.exercise.robot.model;

import java.util.Objects;

public class Space {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Space space)) return false;
        return getMinX() == space.getMinX() && getMinY() == space.getMinY() && getMaxX() == space.getMaxX() && getMaxY() == space.getMaxY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMinX(), getMinY(), getMaxX(), getMaxY());
    }
}
