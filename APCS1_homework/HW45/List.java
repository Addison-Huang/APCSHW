/***************************
 * interface ListInt
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
    int size();

    boolean add(Object x );

    void add( int index, Object x ); 

    Object get( int index );

    Object set( int index, Object x );

    Object remove(int index);


}//end interface ListInt
