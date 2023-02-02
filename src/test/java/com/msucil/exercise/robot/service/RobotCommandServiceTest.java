package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Position;
import com.msucil.exercise.robot.model.Robot;
import com.msucil.exercise.robot.model.Surface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RobotCommandServiceTest {

    @Mock
    Surface surface;

    @Mock
    RobotPositionService positionService;

    @InjectMocks
    RobotCommandService commandService;

    @Test
    void testInitializeShouldReturnRobot() {

        Robot robot = commandService.initialize(22, 0, "E");
        assertNotNull(robot);

        assertEquals(22, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.E, robot.getPosition().getDirection());
    }

    @Test
    void executeShouldReturnAntiClockPosition(){
        Robot robot = new Robot(new Position(0, 0, Direction.E));

        when(positionService.rotateAntiClockWise(any())).thenReturn(new Position(0, 0, Direction.N));

       String position = commandService.execute(robot, "L");

       assertEquals("0 0 N", position);
    }

    @Test
    void executeShouldReturnClockWisePosition(){
        Robot robot = new Robot(new Position(0, 0, Direction.E));

        when(positionService.rotateClockWise(any())).thenReturn(new Position(0, 0, Direction.S));

        String position = commandService.execute(robot, "R");

        assertEquals("0 0 S", position);
    }

    @Test
    void executeShouldReturnPositionWithXIncrement(){
        Robot robot = new Robot(new Position(0, 0, Direction.E));

        when(positionService.moveForward(any())).thenReturn(new Position(1, 0, Direction.E));

        String position = commandService.execute(robot, "M");

        assertEquals("1 0 E", position);
    }
}