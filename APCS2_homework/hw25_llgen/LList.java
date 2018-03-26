public class LList<T> implements List<T>{ 

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
    public boolean add( T newVal )
    {
	addLast(newVal);
	return true;
    }

    //adds a node with cargo newVal at index
    public void add (int index,T newVal) {
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
    public T remove(int index)
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
	    T ret = temp.getNext().getCargo();
	    temp.setNext(temp.getNext().getNext());
	    temp.getNext().setPrev(temp);
	    _size --;
	    return ret;
	}
    }
       
    
    public T get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	T retVal;
	DLLNode tmp = _head; //create alias to head
	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public T set( int index, T newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	T oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------

    //--------------v  Helper methods  v--------------

    //helper function to add a node to the front
    public void addFirst( T newVal) {
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
    public void addLast(T newVal) {
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
    public T removeFirst() {
	T ret = _head.getCargo();
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
    public T removeLast() {
	T ret = _tail.getCargo();
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
    public T toString()
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
