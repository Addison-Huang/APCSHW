/*Team Keyboard Warriors -- Jude Grodesky, Addison Huang, Xinyi Huang 
  Period 02
  HW03 -- I Am Still Searching
  2018-02-02
*/

/*Start at the bottom left. 
  if value == target, return coordinates
  if value > target, move up one
  if value < target, move right one
  repeat until coordinates found or you reach the boundaries of the matrix
  if value not in matrix return (-1, -1)
*/

public class MatrixFinder {

    public static String matrixSearch(int[][] array, int target) {
	int row = array.length -1 ; //bottom
	int column = 0; //left
	while ((column < array[0].length) && (row >= 0)) { //check if the value is inside the boundary
	    if ( array[row][column]  == target) //value == target
		return "(" + row + "," + column + ")"; //return coordinates
	    else if (array[row][column] > target) //value > target
		row --; // move up
	    else //value < target
		column ++; //move right up
	}
	return "(-1,-1)"; //value not found in matrix
    }

    public static void arraytoString(int[][]array) {//convert an array to  String
	String retStr= "";
	for (int row = 0; row < array.length; row ++) {
	    for (int column = 0; column < array[0].length; column ++) {
		retStr = retStr + array[row][column] + " ";
	    }
	    retStr += "\n";
	}
	System.out.println(retStr);
    }
        

    public static void main(String[] args) {
	System.out.println("------------------------------------");
	System.out.println("Matrix 1:");
	int[][] matrix1 = new int[1][1];
	matrix1[0][0] = 5;
	arraytoString(matrix1);
	System.out.print("Where is 5 in matrix 1? ");
	System.out.println(matrixSearch(matrix1, 5)); //should be (0,0)
	System.out.print("Where is 6 in matrix 1? ");
	System.out.println(matrixSearch(matrix1, 6)); //should be (-1,-1)
	int[][] matrix2 = new int[5][5];
	int value = 0;
	for (int row = 0; row < matrix2.length; row ++) {
	    for (int column = 0; column < matrix2[0].length; column ++) {
		matrix2[row][column] = value;
		value +=1;
	    }
	}
	System.out.println("------------------------------------");
	System.out.println("Matrix 2:");
	arraytoString(matrix2);
	System.out.print("Where is 17 in matrix 2? ");
	System.out.println(matrixSearch(matrix2, 17)); //should be (3,2)
	System.out.print("Where is 20 in matrix 2? ");
	System.out.println(matrixSearch(matrix2, 20)); //should be (4,0)
	System.out.print("Where is 4 in matrix 2? ");
	System.out.println(matrixSearch(matrix2, 4)); //should be (0,4)
	System.out.print("Where is 25 in matrix 2? ");
	System.out.println(matrixSearch(matrix2, 25)); //should be (-1,-1)
	System.out.println("------------------------------------");

	int[][] matrix3 = new int[3][3];
	int value1 = 0;
	for (int row = 0; row < matrix3.length; row ++) {
	    for (int column = 0; column < matrix3[0].length; column ++) {
		matrix3[row][column] = value1;
		value1 +=2;
	    }
	}
	System.out.println("------------------------------------");
	System.out.println("Matrix 3:");
	arraytoString(matrix3);
	System.out.print("Where is 17 in matrix 3? ");
	System.out.println(matrixSearch(matrix3, 17)); //should be (-1,-1)
	System.out.print("Where is 40 in matrix 3? ");
	System.out.println(matrixSearch(matrix3, 40)); //should be (-1,-1);
	
	
    }
}

 
