package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Direction;

public interface SpaceService {

    void setRobotPosition(int x, int y, Direction direction);

    String moveRobot(String command);
}
