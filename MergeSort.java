package basics.sort;

// merge sort needs extra space so not widely used
public class MergeSort {
	
	public static void mergeSort(Object[] a, int fromIndex, int toIndex) {
		  // the extra space
		  Object[] temp = new Object[toIndex]; 
	      mergeSortInternal(a, temp, fromIndex, toIndex);
	   }
	
	   private static void mergeSortInternal(Object[] a, Object[] temp, int fromIndex, int toIndex) {
		  // there is only one element to sort 
	      if (toIndex-fromIndex<=1) {
	         return;
	      } else if (toIndex-fromIndex==2) { // toIndex is exclusive so only two integers to be sorted
	         if (((Comparable)a[fromIndex]).compareTo(a[toIndex-1])>0) {
	            temp[toIndex-1] = a[fromIndex];
	            temp[fromIndex] = a[toIndex-1];
	         }
	      } else {
	         int iMiddle = (toIndex+fromIndex)/2;
	         // after these two a's part I and part II are both sorted 
	         mergeSortInternal(a,temp,fromIndex,iMiddle);
	         mergeSortInternal(a,temp,iMiddle,toIndex);
	        
	         int iLeft = fromIndex;
	         int iRight = iMiddle;
	         
	         int i = fromIndex;
	         
	         while (iLeft<iMiddle && iRight<toIndex) {
	            if (((Comparable)a[iLeft]).compareTo(a[iRight])>0) {
	               temp[i] = a[iRight];
	               iRight++;
	            } else {
	               temp[i] = a[iLeft];
	               iLeft++;
	            }
	            i++;
	         }
	         while (iLeft<iMiddle) {
	            temp[i] = a[iLeft];
	            iLeft++;
	            i++;
	         }
	         while (iRight<toIndex) {
	            temp[i] = a[iRight];
	            iRight++;
	            i++;
	         }
	         
	         for(int t = fromIndex; t < toIndex; t++)
	             a[t] = temp[t];
	         // a is sorted now
	         
	      }
	   }
	}