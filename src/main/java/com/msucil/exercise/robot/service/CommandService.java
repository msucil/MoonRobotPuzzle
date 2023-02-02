package com.msucil.exercise.robot.service;

public interface CommandService {

    void setPosition(int x, int y, char direction);

    String command(String command);
}
