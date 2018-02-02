/*Team Keyboard Warriors -- Jude Grodesky, Addison Huang, Xinyi Huang 
Period 02
HW03 --
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
	int row = array.length -1 ;
	int column = 0;
	while ((column < array[0].length) && (row >= 0)) {
	    int selection = array[row][column];
	    if (selection == target) 
		return "(" + row + "," + column + ")";
	    else if (selection > target) 
		row =- 1;
	    else 
		column += 1;
	}
	return "(-1,-1)";
    }

    public static void main(String[] args) {
    }
}

 
