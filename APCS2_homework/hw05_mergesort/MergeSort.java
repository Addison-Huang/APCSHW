/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
Divide the array into halves until each resulting array is of size 1. Merge two arrays together by putting the smallest of the two in the front, followed by the second smallest, etc. 

  ======================================*/
/*Addison Huang
APCS2 pd2
HW #05: Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
2018-02-07
*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      int[] sorted = new int[a.length+b.length];
      int acounter = 0;
      int bcounter = 0;
      int sortedcounter = 0;
      while ((acounter < a.length) && (bcounter < b.length)) {
	  if (a[acounter] < b[bcounter]) {
	      sorted[sortedcounter] = a[acounter];
	      acounter += 1;
	  }
	  else {
	      sorted[sortedcounter] = b[bcounter];
	      bcounter += 1;
	  }
	  sortedcounter +=1;
      }
      if (acounter == a.length) {
	  while (bcounter < b.length) {
	      sorted[sortedcounter] = b[bcounter];
	      bcounter += 1;
	      sortedcounter += 1;
	  }
      }
      else {
	  while (acounter < a.length) {
	      sorted[sortedcounter] = a[acounter];
	      acounter +=1;
	      sortedcounter +=1;
	  }
      }	  
      return sorted;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
      if (arr.length == 1)
	  return arr;
      else {
	  int[] arr1 = new int[arr.length/2];
	  int[] arr2 = new int[arr.length-(arr.length/2)];
	  int counter = 0;
	  for (int arr1c = 0; arr1c < arr1.length; arr1c++) {
	      arr1[arr1c] = arr[counter];
	      counter +=1;
	  }
	  for (int arr2c = 0; arr2c < arr2.length; arr2c++) {
	      arr2[arr2c] = arr[counter];
	      counter +=1;
	  }
	  return merge(sort(arr1),sort(arr2));
      }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

   
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      int[] arr8 = {0,9,9,9,17,23,42,63,512};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr8: ");
      printArray( merge(arr4,arr8) );
      
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
  }//end main()

}//end class MergeSort
