package basics.sort;
/*
Based on a max Heap

Data elements are stored in the input array between "fromIndex" and "toIndex", and it is easier to manage a heap array with index from "1" to "n", 
so I have to do some index conversions like "fromIndex+i-1"
 
Complete: the tree is completely filled except possibly the bottom level, which is filled from left to right
Order property: every node is greater than or equal to its children

1. Organize the entire collection of data elements as a binary tree stored in an array indexed from 1 to N, where for any node at index i, its two children, if exist, will be stored at index of 2*i, and 2*i+1.
2. Divide the binary tree into two parts, the top part in which data elements are in their original order, and the bottom part in which data elements are in heap order, where each node is in higher order than its children, if any.
3. Start the bottom part with the second half of the array, which contains only leaf nodes. Of course, it is in heap order, because leaf nodes have no child.
4. Move the last node from the top part to the bottom part, compare its order with its children, and swap its location with its highest order child, if its order is lower than any child. Repeat the comparison and swapping to ensure the bottom part is in heap order again with this new node added.
5. Repeat step 4 until the top part is empty. At this time, the bottom part becomes complete heap tree.
(Heapfying finished)
6. Now divided the array into two sections, the left section which contains a complete heap tree, and the right section which contains sorted data elements.
7. Swap the root node with the last node of the heap tree in the left section, and move it to the right section. Since the left section with the new root node may not be a heap tree any more, we need to repeat step 4 and 5 to ensure the left section is in heap order again.
8. Repeat step 7 until the left section is empty.
 * */

public class HeapSort {
	
	public static void heapSort(Object[] a, int fromIndex, int toIndex) {
	      
		  Object d;
		  // there are n numbers to sort
	      int n = toIndex - fromIndex;
	      // convert a into a heap
	      // this function is: heapfy the part of the tree from ith node to the nth node
	      // and it assumes the ith node is the sucker need to be properly inserted
	      // fromIndex is the global reference
	      for (int i=n/2; i>=1; i--) {
	         downHeap(a,i,n,fromIndex);
	      }
	      // a is already a heap
	      // a's first part is a heap that is from 1 to i
	      // the following is downward percolate to delete Max
	      for (int i=n; i>1; i--) {
	         d = a[fromIndex];
	         a[fromIndex] = a[fromIndex+i-1];
	         // from the ith to the nth is the sorted part
	         a[fromIndex+i-1] = d;
	         
	         downHeap(a,1,i-1,fromIndex);
	      }      
	   }
	
	
	   private static void downHeap(Object[] a, int i, int n, int fromIndex) {
	      
		   Comparable d = (Comparable)a[fromIndex+i-1];
	       // d is the new element inserted and need to find its proper position
		   // place d at the root and swap it all the way down
	      int child;
	      
	      while (i<=n/2) {
	         child = 2*i;
	         if (child<n && ((Comparable)a[fromIndex+child-1]).compareTo(a[fromIndex+child])<0) 
	            child++; // get the bigger child
	         if (d.compareTo(a[fromIndex+child-1])>=0) 
	        	 break;
	         
	         a[fromIndex+i-1] = a[fromIndex+child-1];
	         i = child;
	      }
	      
	      // i is now some child's index
	      a[fromIndex+i-1] = d;
	   }
	}