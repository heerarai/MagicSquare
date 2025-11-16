//Authors: Suhani Rai, Vishnu Saravanakumar
//comments and exceptions
public class MagicSquare{
	/*An array that is gets initialized based on terminal input to make the square. */
	private static int[][] magicSquare;
	/*A boolean value that checks if the number entered would be considered a double even. */
	private static boolean isEvenSquareType;
	/*An integer value which is assigned based on what the user inputs for their magicSquare size. */
	private static int sideLength;
	/*An integer value that indicates the index of the row in the 2D array. */
	private static int row;
	/* An integer value that indicates the index of the column in the 2D array. */
	private static int col;
	/* Calls all the methods in order to make magicSquare. */
	public static void main(String args[]){
		sideLength = Integer.parseInt(args[0]);
		int rowNumber = Integer.parseInt(args[1]);
		int columnNumber = Integer.parseInt(args[2]);

		initializemagicSquare();
		makeSquare();
		printSumOfDiagonals();
		printRowColumnSum(rowNumber, columnNumber);
		try{
		    printSumOfDiagonals();
		    printRowColumnSum(rowNumber, columnNumber);
		}
		catch(NullPointerException e){}


		
	}
	/* Pre: magicSquare must be initialized and is a helper method for createOddSquare. 
       Post: Returns true if the index in magicSquare does not equal 0. */
	private static boolean isSpaceTaken(){
		/*If the index of magicSquare is equal to 0 returns true */
		if(magicSquare[row][col] == 0){
			return false;
		}
		return true;
	}
	/* Pre: magicSquare must be initialized and is a helper method for createOddSquare.
	   Post: Returns false if the row index is still within bounds of magicSquare.  */
	private static boolean isNotInRowBounds(){
		/*If the index of row in magicSquare is less than 0, meaning not in bounds, returns true. */
		if(row < 0){
			return true;
		}
		return false;
	}
	/* Pre: magicSquare must be initialized and is a helper method for createOddSquare.
	   Post: Returns false if the colum index is within the bounds of magicSquare. */
	private static boolean isNotInColumnBounds(){
		/*If the index of column in magicSquare is greater than the greatest index of magicSquare, returns true. */
		if(col > sideLength - 1){
			return true;
		}
		return false;
	}

	/* Post: Initializes magicSquare and returns true if it is even.*/
	public static void initializemagicSquare(){
		/*If sideLength is odd then initializes magicSquare and isEvenSquareType is set to false. */
		if(sideLength % 2 == 1){
			magicSquare =  new int[sideLength][sideLength];
			isEvenSquareType = false;
		}
		/*If sideLength is divisible by 4, then magicSquare is initialized and isEvenSquareType is set to true. */
		else if(sideLength % 4 == 0){
			magicSquare =  new int[sideLength][sideLength];
			isEvenSquareType = true;
		}
		/*If other 2 statements are false, asks user to enter a valid number for the methods to use. */
		else{
			System.out.println("Please enter an odd or double even value!");
		}
	}
	/*Pre: magicSquare must be initialized.
   Post: Sets the values of all the indices of magicSquare based off of how createOddSquare is played. */
	public static void createOddSquare(){
		col = (sideLength/2 );
		row = 0;
		/*Starts at the value 1, goes through the entire 2D array, magicSquare. */
		for(int i = 1; i <= sideLength*sideLength; i++){
			magicSquare[row][col] = i;
			row -= 1;
			col += 1;
			/*If isNotInColumnBounds and isNotInRowBounds are both true, adds 2 to the row index, and subtracts 1 from column index. */
			if(isNotInColumnBounds() && isNotInRowBounds()){
				row += 2;
				col -= 1;
			}
			/* If isNotInColumnBounds is true, then sets the column index to 0. */
			else if(isNotInColumnBounds()){
				col = 0;
			}
			/*If isNotInRowBounds is true, then sets the row index to the max index of rows in magicSquare. */
			else if(isNotInRowBounds()){
				row =	sideLength - 1;
			}
			/*If isSpaceTaken is true, then increases the row index by 2, and decreases the column index by 1. */
			else if(isSpaceTaken() == true){
			 	row += 2;
			 	col -= 1;
			}
			
		}
	}
	/* Pre: magicSquare is initialized and is a helper method for createDoubleEvenSquare.
	   Post: The top 4 corners of magicSquare is set to its corresponding value based off of doubleEven values. */
	private static void fillCornerSquares(){
		int quarterLength = sideLength/4;
		/*Goes through 1/4 of magicSquare at the top left part of magicSquare and sets the values of that area corresponding to its index. */
		for(int row = 0; row < (quarterLength); row++){
			for(int col = 0; col < (quarterLength); col++){
				magicSquare[row][col] = (sideLength * row) + col + 1;
			}
		}
		/*Goes through 1/4 of magicSquare at the top right part of magicSquare and sets the values of that area corresponding to its index. */
		for(int row = 0; row < (quarterLength); row++){
			for(int col = (sideLength) - 1; col > (sideLength) - (quarterLength) - 1; col--){
				magicSquare[row][col] = (sideLength * row) + col + 1;
			}
		}
		/*Goes through 1/4 of magicSquare at the bottom left part of magicSquare and sets the values of that area corresponding to its index. */
		for(int row = sideLength - (quarterLength); row < sideLength; row++){
			for(int col = 0; col < (quarterLength); col++){
				magicSquare[row][col] = (sideLength * row) + col + 1;
			}
		}
		/*Goes through 1/4 of magicSquare at the bottom right part of magicSquare and sets the values of that area corresponding to its index. */
		for(int row = sideLength - (quarterLength); row < sideLength; row++){
			for(int col = (sideLength) - 1; col > (sideLength) - (quarterLength) - 1; col--){
				magicSquare[row][col] = (sideLength * row) + col + 1;
			}
		}		

	}
	/* Pre: magicSquare is initialized and is a helper method for createDoubleEvenSquare.
	    Post: Sets the indices of the middle section of magicSquare to the correct values corresponding to their index based off of createDoubleEvenSquare values. */
	private static void fillMiddleSquare(){
		int quarterLength = sideLength/4;
		/*Loops through magicSquare starting at the 1/4 of the length of magicSquare and sets the values corresponding
		to those indices. */
		for(int rowNum = quarterLength; rowNum < quarterLength + sideLength/2; rowNum++){
			for(int colNum = quarterLength; colNum < quarterLength + sideLength/2; colNum++){
				magicSquare[rowNum][colNum] = sideLength*rowNum + colNum + 1;
			}
		}
	
	}
	/* Pre: magicSquare must be initialized and is a helper method for createDoubleEvenSquare.
	   Post: Sets the indices of magicSquare that are not fillMiddleSquare or cornerSquare to their corresponding values for createDoubleEvenSquare. */
	private static void fillRemainderValues(){
		int quarterLength = sideLength/4;
		/*Goes through the remaining values at the top of the magicSquare and sets the values 
		corresponding to those indices. */
		for(int rowNum = 0; rowNum < quarterLength; rowNum++){
			for(int colNum = quarterLength; colNum < sideLength - quarterLength; colNum++){
				magicSquare[rowNum][colNum] = sideLength*sideLength - sideLength*rowNum - colNum;
			}
		}
		/*Goes through the remaining values at the bottom of the magicSquare and sets the values 
		corresponding to those indices. */
		for(int rowNum = quarterLength + sideLength/2; rowNum < sideLength; rowNum++){
			for(int colNum = quarterLength; colNum < sideLength - quarterLength; colNum++){
				magicSquare[rowNum][colNum] = sideLength*sideLength - sideLength*rowNum - colNum;
			}
		}
		/*Goes through the remaining values at the left side of the magicSquare and sets the values 
		corresponding to those indices. */
		for(int rowNum = quarterLength; rowNum < quarterLength + sideLength/2; rowNum++){
			for(int colNum = 0; colNum < quarterLength; colNum++){
				magicSquare[rowNum][colNum] = sideLength*sideLength - sideLength*rowNum - colNum;
			}
		}
		/*Goes through the remaining values at the right side of the magicSquare and sets the values 
		corresponding to those indices. */
		for(int rowNum = quarterLength; rowNum < sideLength - quarterLength; rowNum++){
			for(int colNum = quarterLength + sideLength/2; colNum < sideLength; colNum++){
				magicSquare[rowNum][colNum] = sideLength*sideLength - sideLength*rowNum - colNum;
			}
		}
	}



	/*Pre: magicSquare must be initialized; fillCornerSquares must exist, fillMiddleSquare must exist, and fillRemainderValues must exist.
	 Post: All the indices of magicSquare will be set to the correct value of createDoubleEvenSquare based on user input. */
	public static void createDoubleEvenSquare(){
		fillCornerSquares();
		fillMiddleSquare();
		fillRemainderValues();
	}

	/* Pre: magicSquare must be initialized.
	   Post: Prints out all the values of magicSquare with a space… */
	public static void printmagicSquare(){
		int highestDigits = String.valueOf(sideLength * sideLength).length();
		/*Goes through magicSquare and prints out each value in printf format. */
		for(int i = 0; i < magicSquare.length; i++){
			for(int j = 0; j < magicSquare[0].length; j++){
				System.out.format("%" + (highestDigits + 1) + "d", magicSquare[i][j]);
			}
			System.out.println();
		}
	}
	
	/* Pre: magicSquare must be initialized; createOddSquare or createDoubleEvenSquare must have been called. 
	  Post: Prints out the sum of the values of the diagonal elements of magicSquare. */
	public static void printSumOfDiagonals(){
		System.out.println("Diagonals: ");
		int sum = 0;
		/*Goes through magicSquare from the top left, to print out all the values of the left diagonal of magicSquare and gets their sum. */
		for(int i = 0; i < magicSquare.length; i++){
			System.out.print(magicSquare[i][i] + " + " );
			sum += magicSquare[i][i];
		}
		System.out.println(" = " + sum);

		sum = 0;
		/*Goes through magicSquare from the top right, to print out all the values of the right diagonal of magicSquare and gets their sum. */
		for(int i = 0; i < sideLength; i ++){
			System.out.print(magicSquare[i][(sideLength - 1) - i] + " + ");
			sum+= magicSquare[i][(sideLength - 1) - i];
		
		}
		System.out.println(" = " + sum);

	}

	/* Pre: magicSquare is initialized; either createOddSquare or evenSquare has been called.
	    Post: Prints out the sum of the row that the user inputted. */
	public static void printRowColumnSum(int rowNum, int colNum){
		if(rowNum < sideLength && colNum < sideLength && colNum > 0 && rowNum > 0){
			System.out.println("Row " + rowNum);
			int rowSum = 0;
			/*Goes through the user inputted row number, and prints out all the values in that row, and finds their sum. */
			for(int col = 0; col < sideLength; col++){
				System.out.print(magicSquare[rowNum][col] + " + ");
				rowSum += magicSquare[rowNum][col];
			}
			System.out.println(" = " + rowSum);

			System.out.println("Column " + colNum);
			int colSum = 0;
			/*Goes through the user inputted column number, and prints out all the values in that column, and finds their sum */
			for(int i = 0; i < sideLength; i++){
				System.out.print(magicSquare[i][colNum] + " + ");
				colSum += magicSquare[i][colNum];
			}
			System.out.println(" = " + colSum);
		}
		else{
			System.out.println("Please enter a row and column number less than sidelength and greater than 0");
		}
	}


		


	/* Pre: magicSquare is initialized; createOddSquare and createDoubleEvenSquare exist.
	    Post: Calls createDoubleEvenSquare or createOddSquare 	depending on what the boolean value of isEvenSquareType is. */
	public static void makeSquare(){
		/*If isEvenSquareType is true, then calls the method createDoubleEvenSquare, else calls the method createOddSquare. */
		if(isEvenSquareType == true){
			createDoubleEvenSquare();
		}
		else{
			createOddSquare();
		}
		printmagicSquare();
	}
}




