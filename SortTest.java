package basics.sort;

import java.util.*;

public class SortTest {
	
   static int arraySize = 10;
   static HyObject[] dataArray;
   static int numberOfTests = 1000;
   
   public static void main(String[] arg) {
   
	  if (arg.length>0) {
         arraySize = Integer.parseInt(arg[0]);
      }
      
	  dataArray = new HyObject[arraySize];
      long sortTime = 0;
      Date startTime;
      
      for (int j=0; j<numberOfTests; j++) {
         HyObject.setRandom(j);
         for (int i=0; i<arraySize; i++) {
            dataArray[i] = new HyObject();
         }
         startTime = new Date();
//       HyArrays.mySort(dataArray, 0, arraySize);
         Arrays.sort(dataArray, 0, arraySize);
         sortTime += (new Date()).getTime() - startTime.getTime();
//       dump(dataArray, 0, arraySize);
      }
      sortTime = sortTime/numberOfTests;
      System.out.println("Array size: "+arraySize);
      System.out.println("Average sorting time: "+sortTime
         +" milliseconds");
      System.out.println("Number of tests: "+numberOfTests);
      printTimeInfo(sortTime, arraySize);
   }
   public static void printTimeInfo(long t, int n) {
      double nFactor = ((double)t)/(n/1000);
      double nnFactor = ((double)t)/((n/1000)*n);
      double log2n = Math.log((double) n)/Math.log(2.0);
      double ngFactor = ((double)t)/((n/1000)*log2n);
      System.out.println("Performance: "+nFactor
         +" O(N) nanoseconds");
      System.out.println("Performance: "+ngFactor
         +" O(N*Log2(N)) nanoseconds");
      System.out.println("Performance: "+nnFactor
         +" O(N*N) nanoseconds");
   }
   public static void dump(Object[] a, int fromIndex, int toIndex) {
      for (int i=fromIndex; i<toIndex; i++) {
         System.out.println("a["+i+"]: "+a[i].toString());
      }
   }
}