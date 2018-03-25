//Addison Huang
//APCS2 pd2
//HW18 -- QuickSort
//2018-03-13
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): calls qHelp
 * qHelp chooses the leftmost value as the pivot
 * partitions the range to the left of the pivot  and the range to the right of the pivot
 * stops when the range is less than or equal to 1
 *
 * 2a. Worst pivot choice and associated runtime: 
 * pivot is the greatest value in the array
 * runtime is O(n^2) because partition runs in O(n) time and you will need to iterate through every value in the array
 *
 * 2b. Best pivot choice and associated runtime:
 * pivot is the median value in the array
 * runtime is O(nlogn) because partition runs in O(n) time and the divide and conquer sort runs in O(logn)
 * 3. Approach to handling duplicate values in array:
 * qsort keeps running until the range is <= 1
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    //partitions array
    //values to the left of the pivot are less than the pivot
    //values to the right of the pivot are greater than the pivot
    //returns position of pivot
    public static int partition( int array[], int left, int right, int pvtPos)
    {
	int v = array[pvtPos];
	swap( pvtPos, right, array);
	int s = left;
	for( int i = left; i < right; i++ ) {
	    if ( array[i] <= v) {
		swap( i, s, array );
		s+=1;
	    }
	}
	swap(s,right,array);
	return s;
    }

    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    { 
	qHelp(d,0,d.length-1);
    }//end qsort

    /******************************************************
     *void qHelp(int[], int, int)
     *@param d -- array of ints to be sorted in place
     *@param left -- index of the leftmost value
     *@param right -- index of the rightmost value
     *****************************************************/
    public static void qHelp(int[] d, int left, int right) {
	if (left >= right) //if the range is 1 or less
	    return;  
	int pvtPos = partition(d,left,right,left); //pivot is the left value
	qHelp(d,left,pvtPos-1); //everything to the left of the pivot
	qHelp(d, pvtPos+1, right); //everything to the right of the pivot
    }//end qHelp
    
    //main method for testing
    public static void main( String[] args ) {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
