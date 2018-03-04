import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.*;
 
public class InsertionSort {
	
	  private long startTime;
	  private long stopTime;
	  private long elapsedTime;
	  private long elapsedTimeInMs;
    
    public void insertionSort(int[] arr) {
    	startTime = System.nanoTime();
	
        for (int i = 1; i < arr.length; i++) {
		
		   //storing value 
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
				//moving through array to find proper location
                arr[j] = arr[j - 1];
                j--;
            }
			
			//moving stored value back into array
            arr[j] = valueToSort;
        }
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        elapsedTimeInMs = TimeUnit.NANOSECONDS.toMicros(elapsedTime);
        
    }
 
    public static void printArray(int[] B) {
        //System.out.println(Arrays.toString(B));
    }
 
    public static void populateArray(int[] B) {
        for (int i = 0; i < B.length; i++) {
            B[i] = (int) (Math.random() * 100);
        }
    }
    
    public String measuredTimeNS()
    {
  	  //System.out.println(this.elapsedTime);
  	  String result;
  	  result = Long.toString(elapsedTime);
  	  return result;
    }
    
    public String measuredTimeMS()
    {
  	  //System.out.println(this.elapsedTimeInMs);
  	  String result;
  	  result = Long.toString(elapsedTimeInMs);
  	  return result;
    }
}