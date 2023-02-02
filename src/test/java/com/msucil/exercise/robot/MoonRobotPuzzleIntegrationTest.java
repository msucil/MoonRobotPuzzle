package com.msucil.exercise.robot;

import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Robot;
import com.msucil.exercise.robot.model.Surface;
import com.msucil.exercise.robot.service.RobotCommandService;
import com.msucil.exercise.robot.service.RobotPositionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoonRobotPuzzleIntegrationTest {

    @Test
    void testFirstUseCase(){
        Surface surface = new Surface(5, 5);
        final RobotCommandService robotService = new RobotCommandService(surface, new RobotPositionService());

        Robot robot = robotService.initialize(1, 2, "N");

        assertNotNull(robot);
        assertEquals(1, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());
        assertEquals(Direction.N, robot.getPosition().getDirection());

        String robotPosition = robotService.execute(robot, "LMLMLMLMM");
        assertNotNull(robotPosition);
        assertEquals("1 3 N", robotPosition);

        Robot robot2 = robotService.initialize(3, 3, "E");

        assertNotNull(robot2);
        assertEquals(3, robot2.getPosition().getX());
        assertEquals(3, robot2.getPosition().getY());
        assertEquals(Direction.E, robot2.getPosition().getDirection());

        String robot2Position = robotService.execute(robot2, "MMRMMRMRRM");
        assertNotNull(robotPosition);
        assertEquals("5 1 E", robot2Position);
    }
}