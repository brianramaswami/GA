import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner;

String[] tableName = ['a','b','c','d','e','f','g','h'];

public class TSP
{

	// int[] seg = ["A","B"];

	public static void main(String args [] ) throws IOException
	{ 

		
		int[][] data = readFiles("Data.txt");
		printData(data);

		computeSegment(data);


		WordGuess WG1 = new WordGuess(args[0],args[1]);

        
        System.out.println();
		System.out.println("CONTENTS OF PARAMATER FILE");
        WG1.DisplayParams(); //Uncomment to display the contents of the parameter file
        System.out.println("pop before evolution");
	// WG1.DisplayPop(); //Uncomment to display the population before evolution
        

        WG1.EvolveTDSP();
	// System.out.println("pop after evolution");
        // WG1.DisplayPop(); //Uncomment to display the population after evolution
        System.out.println();
        WordGuess WG2 = new WordGuess(args[0],args[1]);
        WG2.EvolveTDDP();
        System.out.println();
        // WG1.EvolveTSP();

	}


	public static void printData(int[][] data){
		for(int [] row : data){
			System.out.println(Arrays.toString(row));
		}

	}

	public static int computeSegment(int[][] data){
		int [] y = data[2];
		int z = y[1];
		System.out.println(z);
		return z;
		
	}

	public static int [][] readFiles(String file)  throws IOException
	{
		File f = new File(file);
		Scanner s = new Scanner(f);

		// first row (^2 if you want the full matrix)
		int numTimes = s.nextInt();
		int rowNum = numTimes;
		int colNum = numTimes;
		numTimes = numTimes * numTimes;

		int[] dataArray = new int[numTimes];
		
		for (int i = 0; i < dataArray.length; i ++){
			dataArray[i] = s.nextInt();
		}

		int array2d[][] = new int[rowNum][colNum];


		for(int i=0; i<rowNum;i++){
		   for(int j=0;j<colNum;j++){
			   array2d[i][j] = dataArray[(j*rowNum) + i]; 
		   }
		}
		

		return array2d;

	}
}


