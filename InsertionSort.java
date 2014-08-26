package basics.sort;

/* Elements to be sorted are stored from "fromIndex" to "toIndex-1" inclusive.
At any given time, elements from "fromIndex" to "i-1" are sorted.
At any given time, elements from "i" to "toIndex-1" are not sorted.
The element at location "i" needs to be inserted at location "j", 
and all elements from "j" to "i-1" need to be shifted to the right by one location
 * */

public class InsertionSort {
	
	public static void insertionSort(Object[] a, int fromIndex, int toIndex) {
	      
		Object temp;
	      
	      for (int i=fromIndex+1; i<toIndex; i++) {
	          // a[i] is the element to be inserted
	    	  temp = a[i];
	    	  // j is the correct position for insertion
	         int j = i;
	         while (j>fromIndex && ((Comparable)a[j-1]).compareTo(temp)>0) {
	             // shift down one by one
	        	 a[j] = a[j-1];
	            j--;
	         }
	         a[j] = temp;
	      }
	      
	      
	   }
	}