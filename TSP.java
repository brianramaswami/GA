import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner;	

public class TSP
{

	public static void main(String args [] ) throws IOException
	{ 

		
		int[] data = readFiles("Data.txt");
		System.out.println(Arrays.toString(data));	

	}

	public static int [] readFiles(String file)  throws IOException
	{
		File f = new File(file);
		Scanner s = new Scanner(f);

		// first row (^2 if you want the full matrix)
		int numTimes = s.nextInt();
		numTimes = numTimes * numTimes;

		int[] dataArray = new int[numTimes];
		
		for (int i = 0; i < dataArray.length; i ++)
			dataArray[i] = s.nextInt();
		
		return dataArray;

	}

}