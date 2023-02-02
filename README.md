# Covered by SAGE : Moon Robots puzzles
A squad of robots are to be landed by NASA on a plateau on Moon. This plateau, which is curiously rectangular, must be navigated by the robots so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
A robot's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the robot is in the bottom left corner and facing North.
In order to control a robot, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the robot spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).
## INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the robots that have been deployed. Each robot has two lines of input. The first line gives the robot's position, and the second line is a series of instructions telling the robot how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the robot's orientation.
Each robot will be finished sequentially, which means that the second robot won't start to move until the first one has finished moving.
OUTPUT:
The output for each robot should be its final co-ordinates and heading.

### INPUT AND OUTPUT:
#### Test Input:
5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM
#### Expected Output:
1 3 N

5 1 E

#### Write a solution considering below
1. Identify the objects
2. Follow OOPS principles
3. Loosely Coupled Code
4. Follow the design patterns
5. Unit Testing
6. Stop Jumping to solution and think about the problem.