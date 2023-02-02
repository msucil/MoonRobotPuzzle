package com.msucil.exercise.robot.model;

import java.util.Objects;

public class Robot {
    private Position position;

    public Robot(){
        this.position = new Position(0, 0, Direction.E);
    }

    public Robot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return getPosition().equals(robot.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
