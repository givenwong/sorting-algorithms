package basics.sort;
/* 
 * Each iteration of  i, bubbles the max of the unsorted to the sorted
 * Elements to be sorted are stored from "fromIndex" to "toIndex-1" inclusive.
At the beginning of each iteration of loop "i", elements from "i+1" to "toIndex-1" are sorted.
At the beginning of each iteration of loop "j", elements from "fromIndex" to "j+1" are not sorted.
At the end of each iteration of loop "i", element at "i" will be the element with the highest order in the un-sorted section.
The "break" statement is there just in case when the un-sorted section happen to be already sorted
 * */

public class BubbleSort {
	
	public static void bubbleSort(Object[] a, int fromIndex, int toIndex) {
	      Object d;
	      
	      for (int i=toIndex-1; i>fromIndex; i--) {
	    	 // in each round, assume the un-sorted part is already sorted 
	         boolean isSorted = true;
	         
	         for (int j=fromIndex; j<i; j++) {
	            if (((Comparable)a[j]).compareTo(a[j+1])>0) {
	               isSorted = false;
	               d = a[j+1];
	               a[j+1] = a[j];
	               a[j] = d;
	            }
	         }
	         // if it is really sorted, there is no need to go to the next round
	         if (isSorted) 
	        	 break;
	      } 
	      	      
	   }
	}
