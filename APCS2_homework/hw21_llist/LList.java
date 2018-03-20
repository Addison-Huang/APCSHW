/*Addison Huang
APCS pd2
HW 21 --Rockin' Through the Night
2018-03-20*/
public class LList implements List {

    //instance vars
    private LLNode _first;
    private int _size;

    //constructor
    public LList() {
	_first = null; //default values
	_size = 0; //default values
    }

    //adds a node to the LList
    public boolean add(String newVal) {
	LLNode first = new LLNode (newVal, _first);
	_first = first;
	_size += 1;
	return true;
    }

    //gets the value at index
    public String get(int index) {
	if ( index >= size() || index <0 ) {//error handling
	    throw new IndexOutOfBoundsException();
	}
	LLNode temp = _first;
	//goes to the node at the desired index
	for (int i = 0; i <index; i++) {
	    temp = temp.getNext();
	}
	String ret = temp.getCargo(); //for code readability 
	return ret; 
    }

    //sets the node at index to newVal
    public String set(int index, String newVal) {
	if (index >= size() || index < 0) { //eror handling
	    throw new IndexOutOfBoundsException();
	}
	LLNode temp = _first;
	//goes to the node at the desired index
	for (int i = 0; i <index; i++) {
	    temp = temp.getNext();
	}
	return temp.setCargo(newVal); //returns old value
    }

    //accessor for size
    public int size() {
	return _size;
    }

    public String toString() {
	LLNode temp = _first;
	String retStr = "";
	while(temp != null) {
	    retStr += temp.getCargo() + " -> ";
	    temp = temp.getNext();
	}
	retStr += "null"; //always ends with null
	return retStr;
    }

    public static void main (String[] args) {
	LList test = new LList();
	System.out.println(test);
	System.out.println("size: " + test.size());

	test.add("Night");
	System.out.println(test);
	System.out.println("size: " + test.size() );

	test.add("the");
	System.out.println(test);
	System.out.println("size: " + test.size() );

	test.add("Through");
	System.out.println(test);
	System.out.println("size: " + test.size() );

	test.add("Rockin'");
	System.out.println(test);
	System.out.println("size: " + test.size() );
    }
}
       
	    
    
    
	
			      
