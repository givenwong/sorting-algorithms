package basics.sort;

/*
 * Quick sort is in place; Merge sort needs extra space.
 * At the beginning of each iteration of loop, elements from "fromIndex+1" to "j" are lower in order 
 * than element at "fromIndex".
 * At the beginning of each iteration of loop, elements from "j+1" to "i-1" are higher 
 * than or equal to element at "fromIndex" in order.
 * If the element at "i" is lower than element at "fromIndex", we need to place it in the "lower" section 
 * by swapping it with element at "j+1".
 * */

public class QuickSort {

	public static void quickSort(Object[] a, int fromIndex, int toIndex) {
	      
		  // in each recursion, use the fromIndex as the pivot
		  // this very important as 
		  Object d;
	      // check if there are more than one elements
		  // otherwise it is the base case
	      if (toIndex-1>fromIndex) {
	         // j points to the last element which is <= pivot
	    	 int j = fromIndex;
	         for (int i=j+1; i<toIndex; i++) {
	            if (((Comparable)a[fromIndex]).compareTo(a[i])>0) {
	               j++; // j is for saving ; i is for scanning
	               d = a[i];
	               a[i] = a[j];
	               a[j] = d;
	            }
	         }
	         
	         d = a[j];
	         a[j] = a[fromIndex];
	         a[fromIndex] = d;
	         
	         quickSort(a, fromIndex, j+1);
	         quickSort(a, j+1, toIndex);
	      }
	      
	   }
	}
