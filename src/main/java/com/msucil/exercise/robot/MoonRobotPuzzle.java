package com.msucil.exercise.robot;

import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Robot;
import com.msucil.exercise.robot.model.Surface;
import com.msucil.exercise.robot.service.RobotCommandService;
import com.msucil.exercise.robot.service.RobotPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoonRobotPuzzle {

    private static final Logger LOG = LoggerFactory.getLogger(MoonRobotPuzzle.class);

    public static void main(String[] args) {
        Surface surface = new Surface(5, 5);
        final RobotCommandService robotService = new RobotCommandService(surface, new RobotPositionService());

        Robot robot = robotService.initialize(1, 2, "N");

		String command1 = "LMLMLMLMM";
        String robotPosition = robotService.execute(robot, command1);

        LOG.info("Robot Position after executing command: {} is {}", "LMLMLMLMM", robotPosition);


        Robot robot2 = robotService.initialize(3, 3, "E");

		String command2 = "MMRMMRMRRM";
        String robot2Position = robotService.execute(robot2, command2);
		LOG.info("Robot Position after executing command: {} is {}", "MMRMMRMRRM", robot2Position);
    }

}
