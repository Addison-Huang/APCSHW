/*Addison Huang
  APCS2 pd02
  HW10 --  [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
  2018 02 28
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	return solveH(0);
    }

  
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col )
    {
	if (col ==  _board[0].length) {
	    return true;
	}
	for (int row = 0; row < _board[0].length; row ++) {
	    if (addQueen(row,col)) {
		addQueen(row,col);
		if (solveH(col+1)) {
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }

    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String s = "";
        for (int row = 0; row < _board.length; row++) {
            for (int col = 0; col < _board[0].length; col++) {
                if (_board[row][col] == 1) {
                    s += "Q";
                }
                else {
                    s += "-";
		}
                s += "  ";
            }
            s += "\n";
        }
        System.out.println(s);
    }




	//================= YE OLDE SEPARATOR =================

	/***
	 * <General description>
	 * precondition: board is full of 1s and 0s
	 * postcondition: places queen and updates the values on the chessboard
	 */
	private boolean addQueen(int row, int col){
	    if(_board[row][col] != 0){ //you can't add a queen to a non 0
		return false;
	    }
	    _board[row][col] = 1; //sets row col to 1
	    int offset = 1; 
	    while(col+offset < _board[row].length){ //marks which moves are impossible
		_board[row][col+offset]--;
		if(row - offset >= 0){
		    _board[row-offset][col+offset]--;
		}
		if(row + offset < _board.length){
		    _board[row+offset][col+offset]--;
		}
		offset++;
	    }
	    return true;
	}


    /***
     * <General description>
     * precondition: 
     * postcondition: 
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) { //updates values based on which moves are possible 
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: board is full of integers 
     * postcondition: board is printed
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	for (int i = 3; i < 9; i++)
	    {
		QueenBoard b = new QueenBoard(i);
		System.out.println("Solving " + i + "x" + i + ":\n");
		b.solve();
		b.printSolution();
		System.out.println("\n\n");
	    }
    }
}//end class
