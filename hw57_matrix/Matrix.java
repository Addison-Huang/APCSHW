/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/

/*Addison Huang
APCS pd1
HW #57 -- How Deep Does the Rabbit Hole Go? 
2017 12 19
*/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
      matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
      return matrix[1].length;
  }


    
  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
      return matrix[r-1][c-1];
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty() 
  {
      for (int row = 0; row < matrix[1].length; row ++) {
	  for (int column = 0; column < matrix.length; column++) {
	      if (matrix[row][column] != null)
		  return false;
	  }
      }
      return true;
	      
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal )
  {
      Object ret = get(r,c);
      matrix[r-1][c-1] = newVal;
      return ret;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
      String retStr = "";
      for (int row = 0; row < matrix[1].length; row ++) {
	  retStr += "| ";
	  for (int column = 0; column < matrix.length; column++) {
	      retStr = retStr + matrix[row][column] + " ";
	  }
	  retStr = retStr + "|\n";
      }
      return retStr;
  }

  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide ) 
  {
      if ((this.size() == ((Matrix)rightSide).size()) && (this.matrix.length == ((Matrix)rightSide).matrix.length)) {
	  for (int row = 1; row < this.size(); row ++) {
	       for (int column = 1; column < this.matrix.length; column++) {
		   if (this.get(row,column) != ((Matrix)rightSide).get(row,column))
		       return false;
	       }
	   }
      }
      else 
	  return false;
      return true;
	  
  }

  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
      for (int i = 1; i <= matrix.length; i++)
	  set(i, c2, set(i, c1, get(i,c2)));
  }
    
    
  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
      for (int i = 1; i <=size(); i++)
	  set(r2, i, set(r1, i, get(r2,i)));

  }

    
  //main method for testing
  public static void main( String[] args ) 
  {
      Matrix joe = new Matrix();
      System.out.println("joe");
      System.out.print(joe);
      System.out.println("Is Joe Empty?: " + joe.isEmpty()); //t
      Matrix bob = new Matrix(3);
      System.out.println("bob");
      bob.set(1,1,5);
      System.out.print(bob);
      System.out.println("Is Bob Empty?: " + bob.isEmpty()); //f
      Matrix low = new Matrix();
      System.out.println("low");
      System.out.print(low);
      Matrix far = new Matrix();
      for (int row = 1; row <= far.matrix[1].length; row ++) {
	  for (int column = 1; column <= far.matrix.length; column++) {
	      far.set(row,column, Math.random());
	  }
      }
      System.out.println("far");
      System.out.println(far);
      System.out.println("Is joe equal to low?: " + joe.equals(low)); //t
      System.out.println("Is bob equal to low?: " + bob.equals(low)); //f
      System.out.println("Is far equal to low?: " + far.equals(low)); //f
      far.swapColumns(1,2);
      System.out.println("far after swapping columns");
      System.out.println(far);
      far.swapRows(1,2);
      System.out.println("far after swapping rows");
      System.out.println(far);
      System.out.println("---------------------------------");
      System.out.println("");
      Matrix ko = new Matrix(5);
      for (int row = 1; row <= ko.matrix[1].length; row ++) {
	  for (int column = 1; column <= ko.matrix.length; column++) {
	      ko.set(row,column, (int)(Math.random()*100));
	  }
      }
      System.out.println("ko");
      System.out.println(ko);
      ko.swapRows(1, 4);
      System.out.println("ko after swapping rows 1 and 4");
      System.out.println(ko);
      ko.swapColumns(2, 5);
      System.out.println("ko after swapping columns 2 and 5");
      System.out.println(ko);
      
  }

}//end class Matrix
