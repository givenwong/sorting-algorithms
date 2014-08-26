package basics.sort;
// where "fromIndex" is inclusive, and "toIndex" is exclusive
// Elements to be sorted are stored from "fromIndex" to "toIndex-1" inclusive.
// At any given time, elements from "fromIndex" to "i-1" are sorted.
// At any given time, elements from "i" to "toIndex-1" are not sorted.
public class SelectionSort {
	
	public static void selectionSort(Object[] a, int fromIndex, int toIndex) {
	      Object d;
	      // i is for the insertion of each round
	      for (int i=fromIndex; i<toIndex; i++) {
	    	 // k is for the min 
	         // i is the new position
	    	 int k = i;
	         for (int j=i+1; j<toIndex; j++) {
	            if (((Comparable)a[k]).compareTo(a[j])>0) {
	               k = j;
	            }
	         }
	         
	         d = a[i];
	         a[i] = a[k];
	         a[k] = d;
	      }   
	   }
	}