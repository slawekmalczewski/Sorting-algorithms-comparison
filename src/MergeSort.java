import java.util.concurrent.TimeUnit;

public class MergeSort {
     
	
    private int[] array;
    private int[] tempMergArr;
    private int length;
    private long startTime;
    private long stopTime;
    private long elapsedTime;
    private long elapsedTimeInMs;
	
    public void sort(int inputArr[]) {
	
		//initialising private member variables
        this.array = inputArr;
        this.length = inputArr.length;
		//creating new array to use in merging 
        this.tempMergArr = new int[length];
		
        //calling mergesort using start and end of array
        doMergeSort(0, length - 1);          
    }
	
	
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
    	startTime = System.nanoTime(); 
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			
		
			
            // Step below  sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Step below sorts the right side of the array
			
            doMergeSort(middle + 1, higherIndex);
			
			
			System.out.println() ;
			
            mergeParts(lowerIndex, middle, higherIndex);			
        }
        
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        elapsedTimeInMs = TimeUnit.NANOSECONDS.toMicros(elapsedTime);
        
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		
		
		//assign to temporary array
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
		
		
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
    
    public String measuredTimeNS()
    {
  	  System.out.println(this.elapsedTime);
  	  String result;
  	  result = Long.toString(elapsedTime);
  	  return result;
    }
    
    public String measuredTimeMS()
    {
  	  System.out.println(this.elapsedTimeInMs);
  	  String result;
  	  result = Long.toString(elapsedTimeInMs);
  	  return result;
    }
}
