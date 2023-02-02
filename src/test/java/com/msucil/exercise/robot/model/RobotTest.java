package com.msucil.exercise.robot.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void testRobot(){
        Position position = new Position(10, 10, Direction.N);
        Robot robot = new Robot(position);

        assertNotNull(robot.getPosition());
        assertEquals(position, robot.getPosition());
        assertEquals(position.getX(), robot.getPosition().getX());
        assertEquals(position.getY(), robot.getPosition().getY());
        assertSame(position.getDirection(), robot.getPosition().getDirection());
    }
}