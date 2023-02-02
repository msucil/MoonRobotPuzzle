package com.msucil.exercise.robot.service;

import com.msucil.exercise.robot.model.Command;
import com.msucil.exercise.robot.model.Direction;
import com.msucil.exercise.robot.model.Position;
import com.msucil.exercise.robot.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RobotCommandService implements CommandService {

    private static final Logger LOG = LoggerFactory.getLogger(RobotCommandService.class);
    private final Robot robot;

    public RobotCommandService(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void setPosition(int x, int y, Direction direction) {
        robot.setPosition(new Position(x, y, direction));
    }

    @Override
    public String command(String command) {
        final char[] commandArray = command.toUpperCase().toCharArray();

        final List<Command> commands = new ArrayList<>(commandArray.length);

        for (char c : commandArray) {
            commands.add(Command.getCommand(String.valueOf(c)));
        }

        for (Command cmd : commands) {
            final Position nextPosition = getNextPosition(cmd);
            LOG.info("Next position: {} after execution command: {}", nextPosition, cmd);
            robot.setPosition(nextPosition);
        }

        return robot.getPosition().toString();
    }

    private Position getNextPosition(Command command) {
        switch (command) {
            case R -> {
                return rotateClockWise(robot.getPosition());
            }
            case L -> {
                return rotateAntiClockWise(robot.getPosition());
            }
            case M -> {
                return incrementCoordinate(robot.getPosition());
            }
            default -> {
                return robot.getPosition();
            }
        }
    }

    private Position rotateClockWise(Position position) {
        switch (position.getDirection()) {
            case E -> {
                return new Position(position.getX(), position.getY(), Direction.S);
            }
            case S -> {
                return new Position(position.getX(), position.getY(), Direction.W);
            }
            case W -> {
                return new Position(position.getX(), position.getY(), Direction.N);
            }
            case N -> {
                return new Position(position.getX(), position.getY(), Direction.E);
            }
            default -> {
                return position;
            }
        }
    }

    private Position rotateAntiClockWise(Position position) {
        switch (position.getDirection()) {
            case E -> {
                return new Position(position.getX(), position.getY(), Direction.N);
            }
            case S -> {
                return new Position(position.getX(), position.getY(), Direction.E);
            }
            case W -> {
                return new Position(position.getX(), position.getY(), Direction.S);
            }
            case N -> {
                return new Position(position.getX(), position.getY(), Direction.W);
            }
            default -> {
                return position;
            }
        }
    }

    private Position incrementCoordinate(Position position) {
        switch (position.getDirection()) {
            case E -> {
                return new Position(position.getX() + 1, position.getY(), position.getDirection());
            }
            case S -> {
                return new Position(position.getX(), position.getY() - 1, position.getDirection());
            }
            case W -> {
                return new Position(position.getX() - 1, position.getY(), position.getDirection());
            }
            case N -> {
                return new Position(position.getX(), position.getY() + 1, position.getDirection());
            }
            default -> {
                return position;
            }
        }
    }
}
