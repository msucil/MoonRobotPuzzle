package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Direction;

public interface CommandService {

    void setPosition(int x, int y, Direction direction);

    String command(String command);
}
