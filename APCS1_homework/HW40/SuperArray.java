/*Addison Huang
APCS1 pd01
HW 41 - Array of Steel
2017 11 27
*/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
      _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
      String retStr = "[";
      // for loop that copies every term in _data
      for (int i = 0; i < _data.length-1; i++) {
	  retStr += _data[i];
	  retStr += ",";
      }
      //adds the last term and closing bracket
      retStr = retStr + _data[_data.length-1] +  "]";
      return retStr;
  }


  //double capacity of SuperArray
  private void expand()
  {
      int len = _data.length; //var for storing the length of _data
      int[] _storage = new int[len];
      for (int i = 0; i < len; i++) {
	  _storage[i] = _data[i];
      }
       _data = new int[len*2];
      for (int i = 0; i < _storage.length; i++) {
	  _data[i] = _storage[i];
      }
      }


  //accessor -- return value at specified index
  public int get( int index )
  {
      return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
      int ret = get(index); //utilizes get
      _data[index] = newVal;
      return ret;
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }

  }//end main()


}//end class
