package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotPositionServiceTest {

    PositionService positionService = new RobotPositionService();

    @Test
    void rotateClockWiseShouldChangeDirectionInClockwise() {
        Position position = new Position(0, 0, Direction.E);
        Position newPosition = positionService.rotateClockWise(position);

        assertNotNull(newPosition);
        assertEquals(position.getX(), newPosition.getX());
        assertEquals(position.getY(), newPosition.getY());
        assertEquals(Direction.S, newPosition.getDirection());
    }

    @Test
    void rotateAntiClockWiseShouldChangeDirectionInAntiClockwise() {
        Position position = new Position(0, 0, Direction.E);
        Position newPosition = positionService.rotateAntiClockWise(position);

        assertNotNull(newPosition);
        assertEquals(position.getX(), newPosition.getX());
        assertEquals(position.getY(), newPosition.getY());
        assertEquals(Direction.N, newPosition.getDirection());
    }

    @Test
    void moveForwardShouldIncrementYCoordinate() {
        Position position = new Position(0, 0, Direction.N);

        Position newPosition = positionService.moveForward(position);

        assertNotNull(newPosition);
        assertEquals(position.getX(), newPosition.getX());
        assertEquals(1, newPosition.getY());
        assertEquals(position.getDirection(), newPosition.getDirection());

    }
}