package basics.sort;

import java.util.*; 

public class HyObject implements Comparable {
   // data is for the value; keyValue is for the key (index)
   // sorting is based on the key	
   private Object data;
   private int keyValue;
   private static Random randomGenerator;

   public static void setRandom(int s) {
      randomGenerator = new Random(s);
   }
   
   public HyObject() {
      data = null;
      keyValue = randomGenerator.nextInt();
   }
   
   @Override
   public int compareTo(Object d) {
      if (this.keyValue > ((HyObject)d).keyValue) {
         return 1;
      } else if (this.keyValue < ((HyObject)d).keyValue) {
         return -1;
      } else {
         return 0;
      }
   }
   
   public String toString() {
      return String.valueOf(keyValue);
   }
}