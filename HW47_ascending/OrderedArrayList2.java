/*Addison Huang
APCS pd01
HW 47 -- ascending
2017 12 06 
*/

/*I wasn't sure if this was the assignment but I tried to do it to the best of my ability */

public class OrderedArrayList
{
    private  Object[] _data; //instance vars
    private  int _size;

    //helper function for add 
    public void helpAdd(Object x, int index) {
	if ( _size >= _data.length )
	    expand();

	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; //each slot gets value of left neighbor
	}

	_data[index] = x;
	_size++;
    }

    //adds the values sorted from least value to greatest value
    public void add(Object x, int index) {
	int counter = 0;
	while (counter < _size) {
	    if (get(counter) == x) {
		helpAdd( x, index);
	    }
	    counter +=1;
	}
	add(x);
	
    }
    //adds at the last index
    public boolean add( Object newVal )
    {
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();

	_data[_size] = newVal;
	_size++;

	return true;
    }

    //returns Object at specific index
    public Object get( int index )
    {
	return _data[index];
    }

    //doubles storage
    private void expand()
    {
	Object[] temp = new Object[ _data.length * 2 ];

	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];

	_data = temp;
    }

    //sorts the arraylist
    public void sort() {
	Object [] temp = new Object[_data.length];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = new Object[temp.length];
	for (Object x: temp) {
	    add(x,0);
	}
    }
					 			    
    public static void main( String[] args ) {	
    }
}
