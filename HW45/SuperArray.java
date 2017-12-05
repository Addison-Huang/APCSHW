/*Addison Huang
IntroCsPd1
HW45- In America, the Driver sits on the left
2017 12 03
*/
public class SuperArray extends java.lang.Object implements List
{
    private Object[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new Object[10];
	_size = 0;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of SuperArray
    private void expand()
    {
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor -- return value at specified index
    public Object get( int index )
    {
	if (index < 0 || index >= size()) { 
	    throw new java.lang.IndexOutOfBoundsException("Your index was out of bounds");
	}
	return _data[index];
    }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public Object set( int index, Object o )
    {
	if (index < 0 || index >= size()) { 
	    throw new java.lang.ArrayIndexOutOfBoundsException("Your index was out of bounds");
	}
	Object temp = _data[index];
	_data[index] = o;    
	return temp;
    }


    //adds an item after the last item
    public boolean add( Object o )
    {
	add( _size, o );
	return true;
    }


    //inserts an item at index
    public void add( int index, Object o)
    {
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	
        _size++;
	
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; //each slot gets value of left neighbor
	}
	_data[index] = o;
	
        if (index < 0 || index >= size()) {
	    throw new java.lang.IndexOutOfBoundsException("Your index was out of bounds");
	}
    
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    //returns removed value
    public Object remove( int index )
    {
	if (index < 0 || index >= size()) {
	    throw new java.lang.IndexOutOfBoundsException("Your index was out of bounds");
	}
	Object retObj = _data[index];
	for( int i = index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_size--;
	return retObj;
    }


    //return number of meaningful items in _data
    public int size()
    {
	return _size;
    }



    //main method for testing
    public static void main( String[] args )
    {
	List  mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);
	
	mayfield.add("hi");
	mayfield.add("bye");
	mayfield.add("sigh");
	mayfield.add("cry");
	mayfield.add("why");
	
	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	
	mayfield.add(3,"weee");
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,"pew");
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,"yay");
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	

    }//end main()


}//end class


