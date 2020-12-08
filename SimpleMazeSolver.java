/**
*COMPILATION: 'javac SimpleMazeSolver.java'
*EXECUTION: 'java SimpleMazeSolver'
*/
/**
*This Maze Solver program can solve any maze that does not have dead-ends and has only one solution.
*One of my first Java programs. It is very basic and uses a greedy algorithm that checks all possible neighbors before making a decision.
*Uploaded to GitHub, December 2020
*@author Urjeet Deshmukh, August 2019
*/

import java.io.*;
import java.util.*;


public class SimpleMazeSolver{

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);	// Scanner will allow user input
		// Introduction of MazeSolution
		System.out.println("\nThis maze solution calculator can calculate the correct path for any maze that does not have dead-ends and has only one solution.\n");

		System.out.print("What is the width of the maze? Enter a number: ");	// Ask user for width
		int width = Integer.parseInt(scanner.nextLine());	// Initialize width to user input

		System.out.print("What is the length of the maze? Enter a number: ");	// Ask user for length
		int length = Integer.parseInt(scanner.nextLine());	// Initialize length to user input

		char[][] board = new char[length][width];	// Initialize board[][] to user's width and length
		System.out.println("\nEnter your maze. Use '#' to denote closed spaces. Leave a blank space ' ' to denote open spaces." + 
			" Use 'S' for the starting position and 'F' for the finishing position." +
			 " Press Enter after each line to input the next line of the maze.\n");	// Explain instructions and ask user to input maze

		for (int i = 0; i < length; i++){	// Iterate over row of inputted maze
			String row = scanner.nextLine();	// Scan row by row 
			for (int j = 0; j < width; j++){
				board[i][j] = row.charAt(j);	// Initialize board[][] with character at column while scanning
			}
		}

		System.out.println("Solution: " + mazeSolver(board, width, length));	// Output solution and call greedy algorithm mazeSolver
	}

	/**
	*This is the method that uses a greedy algorithm to iterate over open spaces and check neighbors of each open space.
	*@param board is the 2-dimensional array initialized to the length and width containing data of "#" (closed spaces), " " (open spaces)
	*"S" (start of the maze) and "F" (finish or end of the maze)
	*@param width the int width of the board
	*@param length the int length of the board
	*@return String of letters denoting the solution path of the specific maze, "D" (down), "R" (right), "U" (up), and "L" (left)
	*/
	public static String mazeSolver(char[][] board, int width, int length){
		int startX = -1;	// Initialize x value of board to -1 as value is unknown
		int startY = -1;	// Initialize y value of board to -1 as value is unknown

		for (int i = 0; i < length; i++){	// Iterate over row of board[][]
			for (int j = 0; j < width; j++){	// Iterate over column of board[][]
				if (board[i][j] == 'S'){	// Find where the board contains "S" to indicate "start"
					startX = j;	// Set x start marker at column
					startY = i;	// Set y start marker at row
				}
			}
		}

		if (startX == -1 || startY == -1){	// If x and y values are still not intialized to a value other than -1
			System.out.println("Error. No 'Start' specified.");	// Then board was not inputted correctly
			return "No Solution.";	// Return
		}

		int currentX = startX;	// Use new variables as indexes over the board[][]
		int currentY = startY;
		String path = "";	// String path to include the solution path as solutions are found

		while(board[currentY][currentX] != 'F'){	// While the iteration has not found "F" indicating "Finish"
			if (currentY + 1 < length && board[currentY + 1][currentX] != '#'){	// If the index below is less than length and does not have "#" (closed space)
				path += 'D';	// Can index down so add "D" to solution
				currentY += 1;	// Increment y value as it has moved one index down
			}else if (currentX + 1 < width && board[currentY][currentX + 1] != '#'){	// If the index right is less than width and does not have "#" (closed space)
				path += 'R';	// Can index right so add "R" to solution
				currentX += 1;	// Increment x value as it has moved one index right
			}else if (currentY - 1 >= 0 && board[currentY - 1][currentX] != '#'){	// If the index up is greater than 0 (can't be less than length) and does not have "#" (closed space)
				path += 'U';	// Can index up so add "U" to solution
				currentY -= 1;	// Decrement y value as it has moved one index up
			}else if (currentX - 1 >= 0 && board[currentY][currentX - 1] != '#'){	// If the index up is greater than 0 (can't be less than width) and does not have "#" (closed space)
				path += 'L';	// Can index left so add "L" to solution
				currentX -= 1;	// Decrement x value as it has moved one index left
			}else{
				System.out.println("Error. Maze has a dead-end.");	// Checked all 4 directions and all directions had a closed space, dead end reached
				return "No Solution.";	// Return 
			}
		}

		return path;	// Return solution path
	}
}