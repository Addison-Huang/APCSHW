/*Addison Huang
APCS PD 1
HW47 -- Ascending
2017 12 06*/
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
      _data = new ArrayList<Comparable>();
  }


  public String toString()
  {
    
      return _data.toString(); //placeholder
  }


  public Comparable remove( int index )
  {
     return _data.remove(index);
  }


  public int size()
  { 
      return _data.size(); //placeholder 
  }

    
  public Comparable get( int index )
  { 
      return _data.get(index); //placeholder  
  }


  public void add(Comparable newVal)
  {
      for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        _data.add( p, newVal );
        return;
	    }
    }
    _data.add( newVal );  }



  // main method solely for testing purposes
  public static void main( String[] args )
  {
 
    OrderedArrayList Franz = new OrderedArrayList();
    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );
    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
  }//end main()

}//end class OrderedArrayList
