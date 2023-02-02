package com.msucil.exercise.robot.model;

public enum Direction {
    E, W, N, S;

    public static Direction getDirection(String direction){
        return switch (direction) {
            case "E" -> E;
            case "W" -> W;
            case "N" -> N;
            case "S" -> S;
            default -> null;
        };
    }
}
