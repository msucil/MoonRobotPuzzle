package com.msucil.exercise.robot.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(){
    }

    public Position(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return getX() == position.getX() && getY() == position.getY() && getDirection() == position.getDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getDirection());
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
