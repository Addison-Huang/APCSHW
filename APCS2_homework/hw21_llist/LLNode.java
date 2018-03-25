/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/
/*Addison Huang
APCS pd02
HW21a -- We Got a Little Ol’ Convoy...
2018 03 20 */

public class LLNode {
    
    //instance vars
    private String _cargo; //the car that can only be a string
    private LLNode _next; //the cdr that points to the next node

    // constructor
    //sets _cargo = data
    //sets _next = next
    public LLNode (String data, LLNode next) {
	_cargo = data;
	_next = next;
    }
	


    //--------------v  ACCESSORS  v--------------
    //accessor for cargo
    public String getCargo() {
	return _cargo;
    }

    //accessor for the next
    public LLNode getNext() {
	return _next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    //mutator for cargo
    //sets _cargo = cargo
    //returns _cargo prior to the change
    public String setCargo(String cargo) {
	String temp = getCargo();
	_cargo = cargo;
	return temp;
	
    }

    //mutator for next
    //sets _next = next
    //returns _next prior to the change
    public LLNode setNext(LLNode next) {
	LLNode temp = getNext();
	_next = next;
	return temp;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() {
	return _cargo.toString();
    }


    //main method for testing
    public static void main( String[] args ) {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
	LLNode first = new LLNode( "run", null ); //makes a node
	first.setNext( new LLNode( "jump", null ) ); //makes a 2nd node
	first.getNext().setNext( new LLNode( "hop", null ) ); //makes a 3rd node
	//I noticed that LLNodes are created from left to right
	
    }//end main

}//end class LLNode
