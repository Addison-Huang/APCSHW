/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

/* Addison Huang
   APCS pd2
   HW 24 -- On the DLL
   2018 03 26
*/
public class LList implements List{ 

    //instance vars
    private DLLNode _head, _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = _tail = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    //adds a node to the end of the list
    public boolean add( String newVal )
    {
	addLast(newVal);
	return true;
    }

    //adds a node with cargo newVal at index
    public void add (int index,String newVal) {
	if (index < 0 || index > _size)
	    throw new IndexOutOfBoundsException();
	else if (index == _size) 
	    addLast(newVal);
	DLLNode newNode = new DLLNode(newVal, null, null);
	if (index == 0)
	    addFirst(newVal);
	else {
	    DLLNode temp1 = _head;
	    for (int i = 0; i < index - 1; i++)
		temp1 = temp1.getNext();
	    DLLNode temp2 = temp1.getNext();
	    newNode.setNext(temp2);
	    newNode.setPrev(temp1);
	    temp1.setNext(newNode);
	    temp2.setPrev(newNode);
	    _size+=1;
	}
    }
    
    //remove node at pos index, return its cargo
    public String remove(int index)
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	else if (index == 0)
	    return removeFirst();
	else if (index ==size()-1)
	    return removeLast();
	else {	
	    DLLNode temp= _head;
	    for (int i = 0; i < index-1; i++) {
		temp = temp.getNext();
	    }
	    String ret = temp.getNext().getCargo();
	    temp.setNext(temp.getNext().getNext());
	    temp.getNext().setPrev(temp);
	    _size --;
	    return ret;
	}
    }
       
    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	String retVal;
	DLLNode tmp = _head; //create alias to head
	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------

    //--------------v  Helper methods  v--------------

    //helper function to add a node to the front
    public void addFirst( String newVal) {
	_head = new DLLNode(newVal, null, _head);
	if (_size == 0) {
	    _tail = _head;
	}
	
	else {
	    _head.getNext().setPrev(_head);
	}
	_size++;
    }

    //helper function to add a node to the back
    public void addLast(String newVal) {
	_tail = new DLLNode(newVal, _tail, null);
	if (_size == 0) {
	    _head = _tail;
	}
	else {
	    _tail.getPrev().setNext(_tail);	    
	}
	_size ++;
    }

    //helper function to remove the first Node
    public String removeFirst() {
	String ret = _head.getCargo();
	if (size() ==1) {
	    _head = _tail = null;
	}
	else {
	    _head = _head.getNext();
	    _head.setPrev(null);
	}
	_size --;
	return ret;
    }

    //helper functin to remove the last Node
    public String removeLast() {
	String ret = _tail.getCargo();
	if (size() == 1) {
	    _head = _tail = null;
	}
	else {
	    _tail = _tail.getPrev();
	    _tail.setNext(null);
	}
	_size--;
	return ret;
    }


    //--------------^  Helper methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
    }

}//end class LList
