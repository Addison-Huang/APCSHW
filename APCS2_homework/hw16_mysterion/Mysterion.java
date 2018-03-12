/*Addison Huang
APCS2 pd 02
HW16 -- About Face
2018 03 08
*/

public class Mysterion {

    public static int quickSort(int[] arr, int lo, int hi, int pivot ) {
	int v = arr[pivot];
	swap(pivot ,hi ,arr);
	int s = lo;
	for (int i=s;i < hi-1; i++) {
	    if (arr[i] < v) {
		swap(s, i,arr);
		s += 1;
	    }
	}
	swap (hi,s,arr);
	return s;
    }

    private static int[] swap (int index1, int index2, int[] array) {
	int temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
	return array;
    }

    private static String arrayToString(int[]array) {
	String retStr = "";
	for (int i:array) {
	    retStr += i;
	    retStr +=", ";
	}
	return retStr;
    }
	    


    public static void main(String[] args) {
	int[] array1 = new int[]{7,1,12,5,3};
	System.out.println("Orginal: " + arrayToString(array1));
	quickSort(array1,0,4,2);
	System.out.println("Mysterioned: " + arrayToString(array1));
	int[] array2 = new int[]{7,1,5,12,3};
	System.out.println("Orginal: " + arrayToString(array2));
	quickSort(array2,0,4,2);
	System.out.println("Mysterioned: " + arrayToString(array2));
	int[] array3 = new int[]{1,5,3,7, 12};
	System.out.println("Orginal: " + arrayToString(array3));
	quickSort(array3,0,4,2);
	System.out.println("Mysterioned: " + arrayToString(array3));
	
    }
}
