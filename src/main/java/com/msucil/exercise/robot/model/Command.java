package com.msucil.exercise.robot.model;

public enum Command {
    L,R,M;

    public static Command getCommand(String command){
        return switch (command) {
            case "L" -> L;
            case "R" -> R;
            case "M" -> M;
            default -> null;
        };
    }
}
