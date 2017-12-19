/*Team Unicorn Dogs -- Muhammad Kashf Mashrafi and Addison Huang
  APCS pd1
  HW #55: Never Fear, Big Oh Is Here!
  2017 12 13 */


import java.util.ArrayList ; 
public class MySorts {

    /* In a best case scenario, bubbleSort is O(n). This is because bubbleSort will simply just iterate through the ArrayList without making any changes. It'll take n passes to iterate an ArrayList of size n. In a worst case scenario, bubbleSort is O(N^2). It sorts only once per iteration and compares N-i elements every pass, where N is the size of ArrayList and i is the pass number.
     */
    public static void bubbleSort( ArrayList<Comparable> data) {
	int swapCtr = 0;
	int comparisonCtr = 0;
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );
	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		comparisonCtr += 1;
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
		    swapCtr += 1;
		    data.set( i, data.set(i+1,data.get(i)));
		    System.out.println("Index " + i + " swapped with index" + (i + 1));		       
		}
	    }
	}
	System.out.println("There was a total of " + swapCtr + " swaps made and " + comparisonCtr + " comparisons made.");
    }
				       

    /*The best and worst case of selectionSort is O(n^2). With every pass, it will compare n - pass# elements, where n is the size of the ArrayList. */
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	int swapCtr = 0;
	int comparisonCtr = 0;
	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass # " + (data.size()-pass) );//diag
	    maxPos = 0;
	    // System.out.println(data);
	    for( int i = 1; i <= pass; i++ ) {
		//System.out.println( "maxPos: " + maxPos );//diag
		//System.out.println( data );//diag
		comparisonCtr += 1;
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    swapCtr += 1;
	    System.out.println( "after swap: " +  data );//diag
	}
	System.out.println("There was a total of " + swapCtr + " swaps made and " + comparisonCtr + " comparisons made.");
	
    } //end selectionSort

    /* The best case of InsertionSort is O(N). It will only pass through the array once in the best case scenario. In the worst case scenario it will be O(N^2). In the worst case scenario it will compare (N-1) + (N-2) + (N-3) ... 2 + 1 elements. Using Gauss' formula, we will be comparing n(n-1+1)/2 elements, which is bound by n^2 */ 
    public static void insertionSort( ArrayList<Comparable> data )
    {
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort

       
}
