/*Addison Huang
APCS1 pd1
HW 38 -- Put it Together
2017 11 21 */

/*
  First a String[][] is initiated
  toPopulate() is used to fill the array with Strings of length 3 or 4
  The array is printed
  User input is taken on the row and columns of the terms that are to be switched
  The terms are switched
  The array is printed again
 */
import cs1.Keyboard;

public class Swapper {
    //instace var that has the whole alphabet 
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //Populates array x with Strings of length 3 or 4
    public static void toPopulate(String[][] x) { 
	for (int c=0; c <x.length; c++ ) { //chooses the column
	    for (int b=0; b < x[0].length; b++) { //chooses the row
		x[c][b] = ""; //changes the String at column, row to empty string
		if(Math.random() < 0.5) { //randomizer for String length 3 or 4
		    int counter = 0; 
		    while (counter < 3) { //creates a random string of length 3
			int marker = (int) (Math.random() * 26);
			x[c][b] += alphabet.substring(marker,marker +1);
			counter +=1;
		    }
		    x[c][b] += "  | ";
		}
		else {
		    int counter = 0;
		    while (counter < 4) { //creates a random string of length 4
			int marker = (int) (Math.random() * 26);
			x[c][b] += alphabet.substring(marker,marker +1);
			counter +=1;
		    }
		    x[c][b] += " | ";
		}
	    }
	}
    }//end toPopulate

    //helper function, turns arrays to strings
    public static String Stringify(String[] array) {
	String retstr = "";
	for (String x: array) {
	    retstr += x + " ";
	}
	return retstr;
    }
    
    //prints out the array 
    public static void print2(String[][] a ) {
	
	for(String[] x: a) {
	    System.out.println(Stringify(x));
	}
    }

    //swaps the two Strings at point (a, b) and (c, d) 
    public static void swap(int a, int b, int c, int d, String[][] x) {
	String holder = x[a][b];
	x[a][b] = x[c][d];
	x[c][d] = holder;
    }

    

    public static void main(String[] args) {
	System.out.println("Here is your array: ");

	String[][] array = new String[4][4];
	toPopulate(array);
	System.out.println("------------------------------");
	print2(array);
	System.out.println("------------------------------");
	System.out.println("");
	System.out.println("****NOTE****");
	System.out.println("THE FIRST ROW IS ROW 0, SECOND IS ROW 1, AND SO ON");
	System.out.println("THE FIRST COLUMN IS ROW 0, SECOND IS COLUMN 1, AND SO ON");
	System.out.println("************");
	System.out.println("");
	System.out.print("Select the row of the first term you want to switch: ");
	int Row1 = Keyboard.readInt();
	System.out.print("Select the column of the first term you want to switch: ");
	int Column1 = Keyboard.readInt();
	System.out.print("Select the row of the second term you want to switch: ");
	int Row2 = Keyboard.readInt();
	System.out.print("Select the column of the second term you want to switch: ");
	int Column2 = Keyboard.readInt();
	swap(Column1, Row1, Column2, Row2, array);
	System.out.println("");
	System.out.println("-------------");
	print2(array);
	System.out.println("-------------");
	
    }
}
