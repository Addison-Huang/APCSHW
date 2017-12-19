/*Team Unicorn Dogs -- Muhammad Kashf Mashrafi and Addison Huang
  APCS pd1
  HW #55: Never Fear, Big Oh is here!
  2017 12 14 */

import java.util.ArrayList;

public class SortTester {
    public static void main( String [] args ) {
	System.out.println("--- Best and Worst Case Scenario of BubbleSort ");
	/*In BubbleSort, the best case scenario is when ArrayList is ordered in a way that any value at index i will always be less than the value at index i + 1. This is because in bubbleSort, a swap will only be made if the index at i is greater than the index at i + 1. There will always be the same amount of comparisons done in total for each ArrayList of size n, but there will be a different amount of swaps everytime. The best case scenario is the one that takes up the least memory, and swaps take more memory then comparisons. Therefore, the ArrayList that takes the least amount of swaps is the best case scenario. The inverse of this statement is also true. The worst case scenario is the one that takes the most amount of swaps, which is when the ArrayList is ordered in a way that any value at index i is greater than the value at index i +1.
	 
	System.out.println("---- Start Best Case  ---- ");
	ArrayList<Comparable> bestCaseBub = new ArrayList<Comparable>();
	bestCaseBub.add(1);
	bestCaseBub.add(3);
	bestCaseBub.add(5);
	bestCaseBub.add(7);
        bestCaseBub.add(12);
	System.out.println(bestCaseBub);
	MySorts.bubbleSort(bestCaseBub);
	System.out.println(bestCaseBub);
	System.out.println("---- End Best Case ----" );
	System.out.println("");
	System.out.println("---- Start Worst Case ----");
	ArrayList<Comparable> worstCaseBub = new ArrayList<Comparable>();
	worstCaseBub.add(12);
	worstCaseBub.add(7);
	worstCaseBub.add(5);
	worstCaseBub.add(3);
        worstCaseBub.add(1);
	System.out.println(worstCaseBub);
	MySorts.bubbleSort(worstCaseBub);
	System.out.println(worstCaseBub);
	System.out.println("---- End Worst Case  ----");
	System.out.println("");

	System.out.println("--- Best and Worst Case Scenario of SelectionSort ");
	/*There is no best or worst case scenario of SelectionSort. In slection sort, a swap is made with every pass, therefore there will always be a total of n-1 passes in an ArrayList of size n. Even if a number is instaintated in it's FRP, it is swapped with itself. */
        
	System.out.println("---- Start Best Case  ---- ");
	ArrayList<Comparable> bestCaseSel = new ArrayList<Comparable>();
	bestCaseSel.add(7);
	bestCaseSel.add(1);
	bestCaseSel.add(5);
	bestCaseSel.add(12);
        bestCaseSel.add(3);
	System.out.println(bestCaseSel);
	MySorts.selectionSort(bestCaseSel);
	System.out.println(bestCaseSel);
	System.out.println("---- End Best Case ----" );
	System.out.println("");
	System.out.println("---- Start Worst Case  ----");
	ArrayList<Comparable> worstCaseSel = new ArrayList<Comparable>();
	worstCaseSel.add(12);
	worstCaseSel.add(7);
	worstCaseSel.add(5);
	worstCaseSel.add(3);
        worstCaseSel.add(1);
	System.out.println(worstCaseSel);
	MySorts.selectionSort(worstCaseSel);
	System.out.println(worstCaseSel);
	System.out.println("---- End Worst Case ----");
	System.out.println("");

	System.out.println("--- Best and Worst Case Scenario of InsertionSort ");
	/* The worst case scenario of InsertionSort is when the ArrayList is presented in a decending order, much like BubbleSort. This is because multiple swaps must be made to get the last index of the newly expanded partition all the way to the front of the ArrayList, to put it in acending order. The best case scenario is when the list is already in acending order because as the partition range increases, swaps are not made because the ArrayList is already sorted.*/
	System.out.println("---- Start Best Case ---- ");
	ArrayList<Comparable> bestCaseIns = new ArrayList<Comparable>();
	bestCaseIns.add(12);
	bestCaseIns.add(7);
	bestCaseIns.add(5);
	bestCaseIns.add(3);
        bestCaseIns.add(1);
	System.out.println(bestCaseIns);
	MySorts.insertionSort(bestCaseIns);
	System.out.println(bestCaseIns);
	System.out.println("---- End Best Case ----" );
	System.out.println("");
	System.out.println("---- Start Worst Case ----");
	ArrayList<Comparable> worstCaseIns = new ArrayList<Comparable>();
	worstCaseIns.add(1);
	worstCaseIns.add(3);
	worstCaseIns.add(5);
	worstCaseIns.add(7);
        worstCaseIns.add(12);
	System.out.println(worstCaseIns);
	MySorts.insertionSort(worstCaseIns);
	System.out.println(worstCaseIns);
	System.out.println("---- End Worst Case ----");
	System.out.println("");
	

    }//end main
}
