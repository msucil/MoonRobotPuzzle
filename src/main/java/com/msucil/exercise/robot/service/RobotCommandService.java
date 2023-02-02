package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.exception.InvalidCommandException;
import com.msucil.exercise.robot.exception.InvalidCoordinateException;
import com.msucil.exercise.robot.exception.InvalidDirectionException;
import com.msucil.exercise.robot.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RobotCommandService implements CommandService {

    private static final Logger LOG = LoggerFactory.getLogger(RobotCommandService.class);

    private final PositionService positionService;
    private final Surface surface;

    public RobotCommandService(Surface surface, PositionService positionService) {
        this.surface = surface;
        this.positionService = positionService;
    }

    @Override
    public Robot initialize(int x, int y, String direction) {
        Direction d = Direction.getDirection(direction);

        if (null == d) {
            LOG.error("Invalid direction: {}", direction);
            throw new InvalidDirectionException("Invalid Direction " + direction);
        }

        if (isInvalidCoordinate(x, y)) {
            LOG.error("Invalid coordinate x: {}, y: {}", x, y);
            throw new InvalidCoordinateException("Invalid coordinate x: " + x + ", y: " + y);
        }
        return new Robot(new Position(x, y, d));
    }

    @Override
    public String execute(Robot robot, String commands) {
        final char[] commandArray = commands.toUpperCase().toCharArray();

        for (char c : commandArray) {
            Command command = Command.getCommand(c);

            if (null == command) {
                LOG.error("Invalid Command: {}", c);
                throw new InvalidCommandException("Invalid Command " + c);
            }

            switch (command) {
                case L -> {
                    final Position position = positionService.rotateAntiClockWise(robot.getPosition());
                    robot.setPosition(position);
                }
                case R -> {
                    final Position position = positionService.rotateClockWise(robot.getPosition());
                    robot.setPosition(position);
                }
                case M -> {
                    final Position position = positionService.moveForward(robot.getPosition());

                    if (isInvalidCoordinate(position.getX(), position.getY())) {
                        throw new InvalidCoordinateException("Invalid Coordinate x: " + position.getX() + ", " + position.getY());
                    }

                    LOG.info("Command {}, Postion {}", command, position);

                    robot.setPosition(position);
                }
            }
        }

        return robot.getPosition().toString();
    }

    private boolean isInvalidCoordinate(int x, int y) {
        return 0 < x && 0 < y && surface.getX() < x && surface.getY() < y;
    }
}
