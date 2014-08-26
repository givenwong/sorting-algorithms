package basics.sort;

import java.util.*;

/*
 * Radix sort is sort from the LSD to the MSD making use of the stability of the sorting
 * For each digit, the sorting is bucket sort to achieve linear performance so Radix is also linear
 * */

public class RadixSort {

	public void radixSort (int[ ] data) {
		boolean flag = true;
		int divisor = 1;
		Queue[ ] buckets = new Queue[10];

		for (int i = 0; i < 10; i++)
			buckets[i] = new LinkedList();  // LinkedList as the queue

		while (flag) {
			flag = false;
				// first copy the values into buckets
			for (int i = 0; i < data.length; i++) {
				int hashIndex = (data[i] / divisor) % 10;
				if (hashIndex > 0) flag = true;
				buckets[hashIndex].offer(new Integer(data[i]));
			}
				// then copy the values back into vector
			divisor *= 10;
			int i = 0;
			for (int j = 0; j < 10; j++) {
				while (! buckets[j].isEmpty()) {
					Integer ival = (Integer) buckets[j].poll();
					data[i++] = ival.intValue();
				}
			}
		}
	}
}
