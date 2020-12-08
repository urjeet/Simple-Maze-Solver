#SimpleMazeSolver
***
One of my first Java programs, this is an implementation of a greedy algorithm to solve a maze. This maze solution calculator can calculate the correct path for any maze that does not have dead-ends and has only one solution. Users will be asked to input width, length, and the maze itself.
*Program Written in August 2019* 
*Pushed to Github in December 2020*

**COMPILATION:** :
    javac SimpleMazeSolver.java

**EXECUTION:** :
    java SimpleMazeSolver

Follow the instructions that are outputted.

When entering the maze, use ``S`` for the starting position and ``F`` for the finishing position. 
Use ``#`` to denote closed spaces. Leave a blank space ``' '`` to denote open spaces.
Press <kbd>Enter</kbd> after each line to input the next line of the maze.

The solution will be outputted as a String of letters. ``U`` for *Up*, ``D`` for *Down*, ``R`` for *Right*, and ``L`` for *Left*.
Each letter defines a singular move starting from the Start index to the Finish index.

Error handling has not been implemented so inputting illegal arguments will result in a ``Exception`` being thrown and the crashing of the program.