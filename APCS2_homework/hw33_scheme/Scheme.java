/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Iterates through the input from right to left
 *   2. Whitespace is removed  
 *   3. Closing parens, numbers, and ops are pushed onto a stack until an open parens is reached
 *   4. The operation is performed on the numbers that are popped from the stack until a closing parens is reached
 *   5. The result of the operation is pushed onto the stack without the parens
 *   6. Repeat steps 2-5 for success 
 *
 * STACK OF CHOICE: LLStack  by Addison Huang
 * b/c 
 * LinkedLists are more fresh in my mind and it has a cooler name than ArrayLists.
 * I don't think it matters because the runtimes of both are similar.
 *
 ******************************************************/
/*Addison Huang
APCS2 pd2
HW 33 - What a Racket
2018 04 13
*/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
      String retVal = ""; //return string
      String[] Arr = expr.split("\\s+"); //splits expr on whitespace
      Stack<String> Latkes  = new LLStack<String>(); //instantiate a new LLStack
      //traverses the String from right to left
      for (int i = Arr.length - 1; i > -1; i--) {
	  if (Arr[i].equals("(")) { //checks for open parens
	      String op = Latkes.pop(); //sets op equal to Latkes.pop(), should always be an operation
	      if (op.equals("+")) { //conditional to check for +
		  Latkes.push(unload(1,Latkes));
	      }
	      else if (op.equals("-")) { //checks for -
		  Latkes.push(unload(2,Latkes));
	      }
	      else if (op.equals("*")) { //checks for *
		  Latkes.push(unload(3,Latkes));
	      }
	  }
	  else {
	      Latkes.push(Arr[i]); //pushes only numbers, ops, and closing parens
	  }
      }
      retVal = Latkes.pop(); //the Stack should be only 1 value
      return retVal;
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers ) 
  {
      int retVal = Integer.parseInt(numbers.pop()); //parses the Strings in numbers for Integers
      while (!(numbers.peek().equals(")"))) { //while the top of numbers is not a closing parens
	  int nextVal = Integer.parseInt(numbers.pop()); //parses the top of the Stack for an Integer
	  if (op == 1) { //+
	      retVal = retVal + nextVal;
	  }
	  else if (op == 2) { //-
	      retVal = retVal - nextVal;
	  }
	  else if (op == 3) {//*
	      retVal = retVal * nextVal;
	  }
      }
      if (numbers.peek().equals(")")) { //checks for closing parens
	  numbers.pop(); //if yes, remove the closing parens
      }
      return retVal + ""; //returns retVal , the + "" is needed to make it a String
  } //end unload
    


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4   
  }//main

}//end class Scheme
