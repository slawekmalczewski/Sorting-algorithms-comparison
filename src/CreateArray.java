import java.util.*;
import java.io.*;
 
public class CreateArray {
	
	private int Size;

		
	//Constructor
	CreateArray(int aSize)
	{
		Size = aSize;
	}
	

	//Methods
	
	public void setArraySize(int n)
	{
		Size = n;
	}
	
	public int getArraySize()
	{
		return Size;
	}
	
	public int[] populateArray()
	{
		int A[] = new int[Size];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * 100);
        }
        
        return A;
	}
	
	
}