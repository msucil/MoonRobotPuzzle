package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Position;
import com.msucil.exercise.robot.model.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RobotCommandServiceTest {

    private final Robot robot = new Robot();
    private final CommandService commandService = new RobotCommandService(robot);

    @Test
    void setPositionShouldSetNewPosition() {
        commandService.setPosition(1, 1, Direction.N);

        assertNotNull(robot.getPosition());
        assertEquals(1, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.N, robot.getPosition().getDirection());
    }

    @Test
    void commandShouldSetNewPosition() {
        Position position = new Position(1,2, Direction.E);
        robot.setPosition(position);

        String nextPosition = commandService.command("L");
        System.out.println(robot.getPosition());

        assertNotNull(nextPosition);
        assertEquals(Direction.N, robot.getPosition().getDirection());

        String nextPostion = commandService.command("LM");

        assertEquals(Direction.W, robot.getPosition().getDirection());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());
    }

    @Test
    void commandShouldMoveToNewCoordinate(){
        robot.setPosition(new Position(1,2, Direction.N));
        String currentPosition = commandService.command("LMLMLMLMM");

        assertNotNull(currentPosition);

        assertEquals(1, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
        assertEquals(Direction.N, robot.getPosition().getDirection());

        robot.setPosition(new Position(3, 3, Direction.E));
        currentPosition = commandService.command("MMRMMRMRRM");

        assertNotNull(currentPosition);

        assertEquals(3, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
        assertEquals(Direction.E, robot.getPosition().getDirection());

    }
}