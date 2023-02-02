package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Position;

public interface PositionService {

    Position rotateClockWise(Position position);

    Position rotateAntiClockWise(Position position);

    Position moveForward(Position position);
}
