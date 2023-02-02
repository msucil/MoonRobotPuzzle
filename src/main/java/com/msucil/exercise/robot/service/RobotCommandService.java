package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Space;

public class RobotCommandService implements CommandService {
    private final Space space;

    public RobotCommandService(Space space) {
        this.space = space;
    }

    @Override
    public void setPosition(int x, int y, char direction) {
    }

    @Override
    public String command(String command) {
        return null;
    }
}
