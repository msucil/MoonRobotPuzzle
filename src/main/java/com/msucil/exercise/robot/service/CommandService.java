package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Robot;

public interface CommandService {

    Robot initialize(int x, int y, String direction);

    String execute(Robot robot, String command);
}
