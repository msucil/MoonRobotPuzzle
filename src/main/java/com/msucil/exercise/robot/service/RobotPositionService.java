package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Position;

public class RobotPositionService implements PositionService {
    @Override
    public Position rotateClockWise(Position position) {
        switch (position.getDirection()) {
            case E -> {
                return new Position(position.getX(), position.getY(), Direction.S);
            }
            case S -> {
                return new Position(position.getX(), position.getY(), Direction.W);
            }
            case W -> {
                return new Position(position.getX(), position.getY(), Direction.N);
            }
            case N -> {
                return new Position(position.getX(), position.getY(), Direction.E);
            }
            default -> {
                return position;
            }
        }
    }

    @Override
    public Position rotateAntiClockWise(Position position) {
        switch (position.getDirection()) {
            case E -> {
                return new Position(position.getX(), position.getY(), Direction.N);
            }
            case S -> {
                return new Position(position.getX(), position.getY(), Direction.E);
            }
            case W -> {
                return new Position(position.getX(), position.getY(), Direction.S);
            }
            case N -> {
                return new Position(position.getX(), position.getY(), Direction.W);
            }
            default -> {
                return position;
            }
        }
    }

    @Override
    public Position moveForward(Position position) {
        switch (position.getDirection()) {
            case E -> {
                return new Position(position.getX() + 1, position.getY(), position.getDirection());
            }
            case S -> {
                return new Position(position.getX(), position.getY() - 1, position.getDirection());
            }
            case W -> {
                return new Position(position.getX() - 1, position.getY(), position.getDirection());
            }
            case N -> {
                return new Position(position.getX(), position.getY() + 1, position.getDirection());
            }
            default -> {
                return position;
            }
        }
    }
}
