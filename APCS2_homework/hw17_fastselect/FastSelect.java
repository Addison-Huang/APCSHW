/*Addison Huang
  APCS2 pd2
  HW17 -- So So Fast
  2018 03 12
*/

/*BIG OH STUFF
best case: index of the pivot is y -1, runtime O(n)
worst case: index of the pivot is 0 and y = array length, runtime O(n^2)
 */

/* ALGORITHM
1) Starts with the y-1 as the pivot position
2) if the index of the pivot is y-1, return value at the index
3) if the index of the pivot is greater than y-1, return fastSelect but with range [left, pivot-1]
4) if the index of the pivot is less than y-1, return fastSelect but with range [pivot+1,right]
 */
public class FastSelect {
    //helper methods
    //elements to the left of the pivot are less than or equal to the pivot
    //elements to the right are greater than the pivot
    public static int partition( int[] arr, int left, int right, int pivot) {
	int v = arr[pivot];
	swap( pivot, right, arr);
	int s = left;
	for( int i = left; i < right; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;
	    }
	}
	swap(s,right,arr);

	return s;
    }

    //swaps x with y
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }
    
    //prints out the array
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }
    //end helper methods

    
    public static int fastSelect(int[] arr, int y) {
	return fastSelect(arr, 0, arr.length-1, y);
    }
    
    public static int fastSelect(int[] arr, int left, int right, int y) {
	//stores the value of where the first pivot is
	int pivot = partition(arr,left,right,y-1);
	//pivot index is y-1
	if (pivot == (y - 1))
	    return arr[pivot];
	//pivot index is greater than the y -1, so look to the left
	else if (pivot > y - 1)
	    return fastSelect(arr,left,pivot-1,y);
	//pivot index is less than y- 1, so look to the right
	else
	    return fastSelect(arr,pivot+1,right,y);
    }

    //main method for testing
    public static void main(String[] args) {
	int[] arr1 = new int[] {7,1,5,12,3};
	System.out.print("array1: ");
	printArr(arr1);
	for (int i = 1; i <= arr1.length; i++) {
	    System.out.print(i+"th element: ");
	    System.out.println(fastSelect(arr1, i));
	    printArr(arr1); //i noticed that after this is run the array is sorted
	    System.out.println();
	}
	System.out.print("best case: ");
	int[] arr2= new int[]{1,3,5,7,12};
	System.out.println(fastSelect(arr2, 1)); //looks for the smallest element starts at index 0
	System.out.print("worst case: ");
	int[] arr3 = new int[]{12,7,5,3,1};
	System.out.println(fastSelect(arr3,1)); //looks for the smallest element but starts at index 0
	
	
	
    }
}
