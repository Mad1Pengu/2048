import java.util.Random;

public class Board {
 
	private int[][] board; // holds state of game
	private Random rnd = new Random(); // setup random # generator
	private int size = 0;
	//What instance variable can you add to keep track of the size or the number of tiles occupied?
	
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		
		// instantiate the board
		board = new int[4][4];
		populateOne();
		populateOne();
	}

	/*
	 * return a String representation of the 2D array board
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 1 2 3
	 * 
	 * 4 5 6
	 */

	
	// overriding a method is when a "child"
	// class implement the exact same method
	// that its parent class has
	public String toString() {
		
		/*
		 * Use the String formatter to pad the numbers with leading 0s
		 * so that the print out does not become jagged
		 * An example is shown below. 
		 * String str = String.format("%04d", 9);  // 0009  
		 * int x = 30;
		 * System.out.println(String.format("%04d",x));
		 *     
		 */
		String builder = "";
			//setup loops to visit
			//every spot possible
		for(int r = 0; r < board.length; r++) {
			if(r > 0){
			builder += "\n";
			}
			for(int c = 0; c < board[0].length; c++) {
				builder += String.format("%04d",board[r][c]);
				builder += " ";
			}
		}
		
		//Inserting New Lines
		//builder += String.format("%04d",board[0][0]);
		//builder += "\n"; forces next content to next line
		//write nested loop to traverse
		//determine when next line
		//4x4 matrix
		
		
		
		
		
		return builder;
	}

	/*
	 * set one of the empty spaces (at random)
	 * to a 2 or 4 (90/10 chance). an empty spot is defined to be a 0 element
	 * Must use the Random class object rnd.
	 * Example Use of rnd object.
	 * 
	 * int randomNum = rnd.nextInt(10); //returns a number in range [0 10) (not
	 * inclusive on the 10)
	 */

	public void populateOne() {
		
		// is there an empty spot?
		// for randomness, generate a row and column
		// check if that tile is empty, if it is NOT empty,
		// generate another set of row and column
		// what happens if the entire board is full??! 
		int row = rnd.nextInt(4);
		int col = rnd.nextInt(4);
		int random = rnd.nextInt(10);
		
		while(board[row][col] != 0) {
		row = rnd.nextInt(4);
		col = rnd.nextInt(4);
		int count = 0;
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				if(board[r][c] != 0) {
					count++;
				}else {
					count = 0;
				}
			}
		}
		if(count == 16) {
			eraseBoard();
		}
		}
		
		if(random == 0) {
			board[row][col] = 4;
		}else {
			board[row][col] = 2;
		}
		
		
			
}
	public void eraseBoard() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length;c++) {
				board[r][c] = 0;
			}
		}
	}
	

	/*
	 * 
	 * Given an array of integers, slide all non-zero elements to the right.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2]->[0 0 2 2]
	 * [2 8 0 2]->[0 2 8 2]
	 * [4 0 0 0]->[0 0 0 4]
	 */

	public void slideRight(int[] row) {
		for(int r = 0; r < row.length - 1; r++) {
			if(row[r] != 0 && row[r+1] == 0) {
				row[r+1] = row[r];
				row[r] = 0;
				if(r > 0) {
				if(row[r-1] != 0) {
					row[r] = row[r-1];
					row[r-1] = 0;
					if(r > 1) {
					if(row[r-2] != 0) {
						row[r-1] = row[r-2];
						row[r-2] = 0;
					}
					}
				}
			}
		}
	}
}

	

	/*
	 * 
	 * Move the numbers as far to the right as they can go
	 * aka the numbers are trying to move to the right-most
	 * empty spaces. This method must utilize the slideRight(int[] row) method
	 * must utilize the helper method above for full credit.
	 * param: a valid row of 2048 where 0s are "empty" spots
	 * effect: row is modified so all numbers are to the right side
	 * return: none
	 */

	public void slideRight() {
		int[] row = new int[4];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				row[c] = board[r][c];
			}
			slideRight(row);
			for(int c = 0; c < row.length; c++) {
				board[r][c] = row[c];
			}
		}
		// go through 2D array, move all digits as far right as possible
		//setup a loop to grab ONE row at a time from 2d array board
	
		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the left.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2] -> [2 2 0 0]
	 * [2 0 0 2] -> [2 2 0 0]
	 */

	public void slideLeft(int[] arr) {
		for(int r = arr.length-1; r > 0; r--) {
			if(arr[r] != 0 && arr[r-1] == 0) {
				arr[r-1] = arr[r];
				arr[r] = 0;
			
				if(r < arr.length-1) {
				if(arr[r+1] != 0) {
					arr[r] = arr[r+1];
					arr[r+1] = 0;
				
				
					if(r < arr.length-2) {
					if(arr[r+2] != 0) {
						arr[r+1] = arr[r+2];
						arr[r+2] = 0;
						}
					}
				}
			}
		}
	}
}
			
		


	/*
	 * Slide all the numbers to the left so that
	 * 
	 * all of the empty spaces are on the right side
	 */

	public void slideLeft() {
		
		// grabbing a row from a 2D array
		// if it's called arr then arr[i] grabs ONE row!
		int[] row = new int[4];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				row[c] = board[r][c];
			}
			slideLeft(row);
			for(int c = 0; c < row.length; c++) {
				board[r][c] = row[c];
			}
		}
		
		
		//visit every single row in the 2D array
		//call the slideLeft method that takes in one argument
		
		
	}

	/**
	 * Given a 2D array and a column number, return a 1D array representing the
	 * elements in the given column number.
	 */
	public int[] getCol(int[][] data, int c) {
		
		//you can also add print out statements here
		int[] col = new int[4];
		for(int r = 0; r < data.length; r++) {
			col[r] = data[r][c];
		}
		return col;
		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the top.
	 * 
	 * zero elements are considered open spots.
	 */

	public void slideUp(int[] arr) {
		/* calls a helper method */
		// do not rewrite logic you already have!
		int total = 0;
		for(int i = 0; i < 4; i++) {
			if(arr[i] == 0) {
				total++;
			}
		}
		for(int i = 0; i < total; i++) {
			for(int r = 0; r < 3; r++) {
				if(arr[r] == 0) {
				arr[r] = arr[r+1];
				arr[r+1] = 0;
				}
			}
			}
		}

	/*
	 * 
	 * Slide all elements in the board towards the top.
	 * 
	 * You must use slideUp and getCol for full credit.
	 */
	public void slideUp() {
		for(int c = 0; c < 4; c++) {
			int[] col = getCol(board, c);
			slideUp(col);
			for(int i = 0; i < 4; i++) {
				board[i][c] = col[i];
			}
		}
		//visit every column index
		//grab each column as an array using getCol -> keep track of it in a 1d array
		// variable/reference
		//have slideLeft perform manipulation on the array
		// copy over the 1D array representation of the column
		// back to the 2D board array
		
		
		
	}

	public void slideDown(int[] arr) {
		int total = 0;
		for(int i = 3; i >= 0; i--) {
			if(arr[i] == 0) {
				total++;
			}
		}
		for(int i = 0; i < total; i++) {
			for(int r = 3; r > 0; r--) {
				if(arr[r] == 0) {
				arr[r] = arr[r-1];
				arr[r-1] = 0;
				}
			}
			}
		}

	/*
	 * slide all the numbers down so that any
	 * empty space is at the top
	 * You must use slideDown and getCol for full credit.
	 */

	public void slideDown() {
	for(int c = 0; c < 4; c++) {
		int[] col = getCol(board, c);
		slideDown(col);
		for(int i = 0; i < 4; i++) {
			board[i][c] = col[i];
		}
	}
	}

	/*
	 * Given the 2D array, board, combineRight will take adjacent numbers that
	 * are the same and combine them (add them).
	 * After adding them together, one of the numbers is zeroed out. For
	 * example, if row 0 contained [0 0 4 4],
	 * a call to combineRight will produce [0 0 0 8]. If row 1 contained [2 2 2
	 * 2], a call to combineRight will
	 * produce [0 4 0 4].
	 * 
	 * Notice that the left element is zeroed out.
	 */

	public void combineRight() {
		for(int r = 0; r < 4; r++) {
			for(int c = 3; c > 0; c--) {
				if(board[r][c] == board[r][c-1]) {
					board[r][c] *= 2;
					board[r][c-1] = 0;
				}
			}
		}
	}

	/*
	 * same behavior as combineRight but the right element is zeroed out when
	 * two elements are combined
	 */

	public void combineLeft() {
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 3; c++) {
				if(board[r][c] == board[r][c+1]) {
					board[r][c] *= 2;
					board[r][c+1] = 0;
				}
			}
		}
	}
	
	/*
	 * same behavior as combineRight but the bottom element is zeroed out when
	 * two elements are combined
	 */

	public void combineUp() {
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 4; c++) {
				if(board[r][c] == board[r+1][c]) {
					board[r][c] *= 2;
					board[r+1][c] = 0;
				}
			}
		}
	}

	/*
	 * same behavior as combineRight but the top element is zeroed out when two
	 * elements are combined
	 */

	public void combineDown() {
		for(int r = 3; r > 0; r--) {
			for(int c = 0; c < 4; c++) {
				if(board[r][c] == board[r-1][c]) {
					board[r][c] *= 2;
					board[r-1][c] = 0;
				}
			}
		}
	}


	
	
	/* reminder: these are the methods that will ultimately invoke
	 * a series of methods
	 * 
	 * the combine and slide methods should not worry about each other's methods
	 */
	public void left() {
		//1) numbers slide to the left
		//2) combine
		//3) slide
		slideLeft();
		combineLeft();
		slideLeft();
	}

	public void right() {
		slideRight();
		combineRight();
		slideRight();
	}

	public void up() {
		slideUp();
		combineUp();
		slideUp();
	}

	public void down() {
		slideDown();
		combineDown();
		slideDown();
	}
	
	

	public boolean gameOver() {
		return false;
	}

	public int[][] getBoard() {
		return board;
	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
	}

}
