package crossValidationNearestNeighbors;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement cross validation evaluation of the k-nearest-neighbors algorithm.
 */


import java.io.*;

/*
 * CrossValidation class computes the cross validation of the k-nearest-neighbors where k is 1,2,3,4,5
 * @var : k is the value of the k for k fold cross validation.
 * @var : m is the number of training example.
 * @var : t is the number of permutation.
 * @var : permutationMatrix is the Matrix of different permutations of examples.
 * @var : gridMatrix is the Matrix of the input grid
 * @var : exampleTable is the table which stores the x1, x2 and y for each example.
 * @var : gridValues is the matrix which stores entire grid according to k-nearest neighbors with k = 1,2,3,4,5
 * @var : error is the matrix which stores error for each permutation and each value of k in k-nearest neighbors
 */

public class CrossValidation {
	private int k=0, m=0, t=0;
	private int[][] permutationMatrix = null;
	private int[][] gridMatrix = null;
	private int[][] exampleTable = null;
	private int[][][] gridValues = null;
	double error[][] = null;

	/*
	 * kCrossValidation is the method which calculates the error and sigma for the given set of examples.
	 * @return : void
	 */
	
	public void kCrossValidation() throws Exception{
		processFirstFile();											//process First input file
		processSecondFile();										//process Second input file
		int[] permutation = new int[m];
		Double[] distance = new Double[permutationMatrix[0].length];
		int low=0, high=0;
		int y[] = new int[5]; 
		error = new double[permutationMatrix.length+2][5];
		int countPos= 0 , countNeg = 0;
		int sizeOfChunk = permutationMatrix[0].length/k;
		for(int turnCounter = 0; turnCounter<permutationMatrix.length;turnCounter++){
			for (int foldCounter = 1; foldCounter <= k; foldCounter++) {
				low = ((foldCounter-1)*sizeOfChunk);
				high = (foldCounter*sizeOfChunk);
				high = high + (((permutationMatrix[0].length - high) <= (permutationMatrix[0].length%k)) ? ((permutationMatrix[0].length - high)) : 0);
				for(int inCounter=low; inCounter<high && inCounter<permutation.length; inCounter++) {
					for(int inInCounter = 0;inInCounter<permutation.length;inInCounter++) {
						distance[inInCounter]=0.0;
						for(int i=0;i<permutationMatrix[0].length;i++){
							permutation[i]=permutationMatrix[turnCounter][i];
						}
						if(inInCounter>=low && inInCounter<high)
							continue;
						distance[inInCounter]=distance(exampleTable[permutation[inCounter]][0], exampleTable[permutation[inCounter]][1], exampleTable[permutation[inInCounter]][0], exampleTable[permutation[inInCounter]][1]);
					}
					sort(distance, permutation);					
					for(int i=1;i<=5;i++){
						countPos=0;
						countNeg=0;
						for(int j=1;j<=i;j++){
							for(int x=sizeOfChunk+(high%sizeOfChunk);x<sizeOfChunk+(high%sizeOfChunk)+i&&x<permutationMatrix[0].length;x++){
								if(exampleTable[permutation[x]][2]==1)
									countPos++;
								else
									countNeg++;
							}
							if(countPos>countNeg)
								y[i-1] = 1;
							else
								y[i-1] = 0;		
						}
						if(y[i-1]!=exampleTable[permutationMatrix[turnCounter][inCounter]][2]){
							error[turnCounter][i-1]++;
							error[permutationMatrix.length][i-1]++;
						}
					}
				}
			}
		}
		labelGrid();
		printOutput();
	}
	
	/*
	 * processFirstFile reads the data from first file and process the details for cross validation
	 * 
	 * 2 9 3
	 * 0 1 2 3 4 5 6 7 8 
 	 * 8 1 2 3 4 5 6 7 0
	 * 4 0 8 2 6 3 7 1 5
	 * 
	 * First line has 3 numbers:
	 * k m t
	 * and next files has the permutations.
	 * 
	 * @return : void
	 */
	
	private void processFirstFile()  throws Exception {
		FileInputStream fis = new FileInputStream("first.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str = br.readLine();
		k = Integer.parseInt(str.substring(0, str.indexOf(' ')));
		m = Integer.parseInt(str.substring(str.indexOf(' ')+1,str.lastIndexOf(' ')));
		t = Integer.parseInt(str.substring(str.lastIndexOf(' ')+1));
		permutationMatrix = new int[t][m];
		int permuatationNum = 0;
		while (str != null) {
			str = br.readLine();
			if(str!=null) {
				String[] temp =str.split(" ");
				for(int counter=0; counter<m; counter++) {
					permutationMatrix[permuatationNum][counter]=Integer.parseInt(temp[counter]);				
				}
				permuatationNum++;
			}
		}
		fis.close();
		br.close();
	}
	
	/*
	 * processSecondFile reads the data from Second file and process the details for cross validation
	 * 
	 * 4 5
	 * . + . . −
	 * . + . − −
	 * . + . . -
	 * . + . . −
	 * 
	 * First line has 2 numbers, number of rows and number of columns
	 * Remaining lines has the Grid Matrix
	 * 
	 * @return : void
	 */
	
	private void processSecondFile() throws Exception {
		FileInputStream fis = new FileInputStream("Second.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str = br.readLine();
		int gridRows = Integer.parseInt(str.substring(0, str.indexOf(' ')));
		int gridCols = Integer.parseInt(str.substring(str.indexOf(' ')+1));
		gridMatrix = new int[gridRows][gridCols];
		exampleTable = new int[gridRows+gridCols][3];
		int rowCounter =0 ;
		int examplesCounter = 0;
		while (str != null) {
			str = br.readLine();
			if(str!=null) {
				String[] temp =str.split(" ");
					for(int j=0; j<gridCols; j++) {
						if(temp[j].equals("+")) {
							gridMatrix[rowCounter][j] = 1;
							exampleTable[examplesCounter][0] = j;
							exampleTable[examplesCounter][1] = rowCounter;
							exampleTable[examplesCounter][2] = 1;
							examplesCounter++;
						}
						else if(!temp[j].equals(".")) {
							gridMatrix[rowCounter][j] = 0;
							exampleTable[examplesCounter][0] = j;
							exampleTable[examplesCounter][1] = rowCounter;
							exampleTable[examplesCounter][2] = 0;
							examplesCounter++;
						}
						else
							gridMatrix[rowCounter][j] = 2;							
				}
				rowCounter++;
			}
		}
		fis.close();
		br.close();
	}
	
	/*
	 * distance method calculates the distance between 2 points on coordinates system
	 * @var : x1 is the x coordinate of 1st point
	 * @var : y1 is the y coordinate of 1st point
	 * @var : x2 is the x coordinate of 2nd point
	 * @var : y2 is the y coordinate of 2nd point
	 * @return double i.e the distance between the 2 points
	 */
	
	private static double distance(int x1, int y1, int x2, int y2)
    {
		return Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
    }
	
	/*
	 * swap method swap the 2 elements of the distance array
	 * @var : distance is the reference of the Distance array 
	 * @var : a1 is the reference of the permutation array
	 * @var : a & b are the index of array which needs to be swapped
	 * @return void
	 */
	
	private static void swap(Double[] distance, int[] a1, int a, int b){
		Double temp = distance[a];
		distance[a] = distance[b];
		distance[b] = temp;
		
		int temp1 = a1[a];
		a1[a] = a1[b];
		a1[b] = temp1;
	}
	
	/*
	 * sort method sort the distance array and permutation array
	 * @var : distance is the reference of the Distance array
	 * @var : permutation is the reference of the Permutation array
	 * @return : void
	 */
	
	private static void sort(Double[] distance, int[] permutation) {
		for (int inCounter = 0; inCounter < distance.length; inCounter++) {
			for (int outCounter = inCounter; outCounter >0; outCounter--) {
				if(distance[outCounter].compareTo(distance[outCounter-1])==-1){
					swap(distance,permutation,outCounter,outCounter-1);
				}
				else
					break;
			}
		}
	}
	
	/*
	 * labelGrid method labels the entire grid according to the k-nearest neighbor
	 * @return : void
	 */
	
	private void labelGrid() throws Exception{
		processFirstFile();
		processSecondFile();
		gridValues = new int[5][gridMatrix.length][gridMatrix[0].length];
		Double[] distance = new Double[exampleTable.length];
		int[] acopy = new int[exampleTable.length];
		for(int inCounter=0; inCounter<gridMatrix.length; inCounter++) {
			for(int inInCounter = 0;inInCounter<gridMatrix[inCounter].length;inInCounter++) {
				if(gridMatrix[inCounter][inInCounter]==2){
					for(int i= 0 ; i< exampleTable.length ; i++){
						distance[i] = 0.0;
						distance[i] = distance(exampleTable[i][0], exampleTable[i][1], inInCounter, inCounter);						
					}
					for(int i=0;i<acopy.length;i++){
						acopy[i]=i;
					}
					sort(distance, acopy);
					for(int i=0;i<5;i++){
						int countPos=0;
						int countNeg=0;
						for(int j=0;j<=i;j++){
							if(exampleTable[acopy[j]][2]==1)
								countPos++;
							else
								countNeg++;
						}
						if(countPos>countNeg)
							gridValues[i][inCounter][inInCounter] = 1;
						else
							gridValues[i][inCounter][inInCounter] = 0;
					}
				}
				else {
					for(int i=0;i<5;i++){
					gridValues[i][inCounter][inInCounter] = gridMatrix[inCounter][inInCounter];
					}
				}
				
			}
		}		
	}
	
	/*
	 * printOutput method print the error, sigma and entire grid.
	 * @return : void
	 */
	
	
	private void printOutput() {
		for(int i= 0; i< 5; i++){
			error[permutationMatrix.length+1][i]=(error[permutationMatrix.length][i])/(permutationMatrix[0].length*permutationMatrix.length);
			double variance = 0.0;
			for(int j=0;j<permutationMatrix.length;j++){
				variance = variance + (((error[j][i]/permutationMatrix[0].length) - (error[permutationMatrix.length+1][i])) * ((error[j][i]/permutationMatrix[0].length) - (error[permutationMatrix.length+1][i])));
			}
			variance = Math.sqrt((variance / (double)(permutationMatrix.length - 1)));
			System.out.println("K = "+(i+1)+" e = "+error[permutationMatrix.length+1][i]+" sigma = "+variance);
			for(int inCounter=0; inCounter<gridMatrix.length; inCounter++) {
				for(int inInCounter = 0;inInCounter<gridMatrix[inCounter].length;inInCounter++) {
					System.out.print((gridValues[i][inCounter][inInCounter] ==1 ? '+' : '-') +" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
