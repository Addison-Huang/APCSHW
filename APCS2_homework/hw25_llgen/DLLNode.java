/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T>
{
    private T _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    //constructor --intializes instance vars
    public DLLNode (T value, DLLNode next, DLLNode prev) {
	_cargo= value;
	_nextNode = next;
	_prevNode = prev;
    }

    //-----------v ACCESSORS v------------
    //accessor for _cargo
    public T getCargo() {
	return _cargo;
    }

    //accessor for _nextNode
    public DLLNode getNext() {
	return _nextNode;
    }

    //accessor for _prevNode
    public DLLNode getPrev() {
	return _prevNode;
    }

    //----------^ ACCESSORS ^-------------

    //--------------v  MUTATORS  v--------------
    //mutator for _cargo
    public T setCargo( T newCargo ) {
	T foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    //mutator for _nextNode
    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    //mutator for _prevNode
    public DLLNode setPrev( DLLNode newPrev) {
	DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------

    // override inherited toT
    public T toString() {
	return _cargo.toString();
    }
    
    public static void main(String[] args) {
    }
}//end class DLLNode
