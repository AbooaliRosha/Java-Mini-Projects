
import java.util.Scanner;
public class Main 
{
	// initializing global variables to have make access easier over the program 
	public static String player1; // initializing first player's name

	public static String player2; // initializing second player's name

	public static int row; // initializing number of the row

	public static int column; // initializing number of the column

    // tracking the turns. This is true when player1 is playing and false when player2 is playing
	public static boolean player1IsPlaying = true;

	public static boolean gameEnd = false; // tracking if the game has ended

	public static int counter; // tracking the number of turns

	public static void main(String[] args) 
	{
	    Scanner userInput = new Scanner(System.in); // initializing scanner 

		char[][] grid = new char[3][3]; // initializing a (3 * 3) 2D array to create the tic tac toe board

		// initializing the board with dashes
		for (int i = 0; i < 3; i++) // looping over the rows
		{
			for (int j = 0; j < 3; j++) // looping over the columns
			{
				grid[i][j] = '-';  
			}
		}

		//starter of the game
		System.out.println("Welcome to Tic-Tac Toe game!"); 
		gettingNames(); // calling function to get the player's names
		System.out.println(player1 + " is X and " + player2 + " is O");
		System.out.println("LET'S BEGIN THE GAME");

		// tracking the game
		do 
		{
			// sending the according symbole and the coordinates to print it out in the function
		    printGrid(grid);

			// initializing palyers with X and O symboles
			char symbole = initializingSymboles(player1IsPlaying);

			// determining which player's turn it is
			if (player1IsPlaying) 
			{
				System.out.println(player1 + " should draw.");
			} 
			else 
			{
				System.out.println(player2 + " should draw.");
			}

			// getting user input for row
			System.out.print("Enter the row number: ");
			row = userInput.nextInt(); // getting user's input
			int realRow = checkingRow(row); // sending the value of the row to function and check if it's not out-of-bounds

			// getting user input for column
			System.out.print("Now enter the column number: ");
			column = userInput.nextInt();
			int realColumn = checkingColumn(column); // sending the value of the column to function and check if it's not out-of-bounds

			// checking if the spot is already full, while the spot is full ask the user to eneter valid cordinates
			while(grid[realRow][realColumn] != '-') 
			{
				System.out.println("ALREADY FULL! Try again: ");

				// getting user input for row
				System.out.print("Enter the row number: ");
				row = userInput.nextInt(); // getting user's input
				realRow = checkingRow(row); // check if not out-ofbounds

				// getting user input for column
				System.out.print("Now enter the column number: ");
				column = userInput.nextInt();
				realColumn = checkingColumn(column); // check if not out-of-bounds
			}

			// putting the symbole in the coordinates given
			grid[realRow][realColumn] = symbole; 

			// check for the winner
			if((checkRowWin(grid) ||  checkColWin(grid) || checkDiagonalWin(grid)) == true)
			{
				if(player1IsPlaying)
				{
					System.out.println(player1 + " is the winner.");
					gameEnd = true; // end of loop and game ends

				}
				else
				{
					System.out.println(player2 + " is the winner.");
				    gameEnd = true; // end of loop and game ends
				}

			}
			else if((checkRowWin(grid) ||  checkColWin(grid) || checkDiagonalWin(grid)) == false)
			{
				System.out.println("Unfinished. GAME IN PROGRESS");
				player1IsPlaying = switchPlayer(player1IsPlaying); // switch players
				counter++; // tracking the number of turns
			}

			int newCounter = counter; // initializing the value of counter to newCounter
			if(newCounter == 9)
			{
				System.out.println("Cat's game. No winner:(");
				gameEnd = true; // end if loop and game ends
			}

		}while(!gameEnd); // while game has not ended

		printGrid(grid); // printing the final grid

	}

	// starter and getting player names
	public static void gettingNames()
	{
		// initializing scanner 
	    Scanner userInput = new Scanner(System.in);

		System.out.println("Enter your name player one:");
		player1 = userInput.nextLine(); // getting user input

		System.out.println("Enter your naem player two:");
		player2 = userInput.nextLine();

	}

	// creating the board by 2D array
	public static void printGrid(char[][] grid)
	{
		System.out.print("  012\n");
		for (int i = 0; i < grid.length; i++) // looping over the rows
		{
			System.out.print(i+" ");
			for (int j = 0; j < grid[i].length; j++) // looping over the columns
			{
				System.out.print(grid[i][j]);
			}
			System.out.println(); // print space between columns
		}
	}

    // setting player's symboles
	public static char initializingSymboles(boolean currentPlayer)
	{
		if (currentPlayer)  //when palyer1 is playing return X
		{
			return 'X';
		}
		return 'O'; //when palyer2 is playing return O
	}

	// checking if the row number is not out-of-bounds
	public static int checkingRow(int row) 
	{
		// initializing scanner 
	    Scanner userInput = new Scanner(System.in);

		while(row >= 3 || row < 0) 
		{
			System.out.print("Out of bounds! Try again: ");
			row = userInput.nextInt();
		}
		return row; // return the row number
	}

	// check if the number of column is not out of the bounds
	public static int checkingColumn(int column) 
	{
		// initializing scanner 
	    Scanner userInput = new Scanner(System.in);

		while (column >= 3 || column < 0) 
		{
			System.out.print("Out of bounds! Try again: ");
			column = userInput.nextInt();
		}
		return column; // return the column number
	}

	// switching players
	public static boolean switchPlayer(boolean currentPlayer)
	{
		boolean player = true;  
	    if(currentPlayer == true) //if player1 is playing
	    {
	        player = false;  //don't switch
	    }
	    else
	    {
	        player = true;  //switch players
	    }
	    return player; 
	}

	// check if any rows is full
	public static boolean checkRowWin(char[][] grid)
	{
		for (int i = 0; i < grid.length; i++) // looping over rows
		{
			// if all the charachters in the row are equal toghether and the row is not equal to three empty spaces
			if ((grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2]) && (grid[i][0] != '-')) 
			{
				return true; // return the winner symbole
			}
		}
		return false;
	}

    // check if any column is full
	public static boolean checkColWin(char[][] grid)
	{
		for (int j = 0; j < grid.length; j++) // looping over columns
		{
			// if all the charachters in the column are equal toghether and the column is not equal to three empty spaces
			if ((grid[0][j] == grid[1][j]) && (grid[1][j] == grid[2][j]) && (grid[0][j] != '-')) 
			{
				return true; // return the winner symbole
			}
		}
		return false;
	}

    // check if any diagonal is full
	public static boolean checkDiagonalWin(char[][] grid)
	{
		if ((grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]) && (grid[0][0] != '-')) 
		{
			return true; // return the winner symbole

		} 
		// checking the other diagonal
		else if ((grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0]) && (grid[0][2] != '-')) 
		{
			return true; // return the winner symbole
		}

		return false;
	}

}
