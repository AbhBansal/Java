package heapSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Heap Sort, sorting an array of Integers. 
 */

/*
 * HeapSort class contains the logic for sorting according to Heap sort algorithm
 */

public class HeapSort {

	/*
	 * sort method sort the array in increasing order of integer. 
 	 * @var : aray is the reference of the array.
 	 * @return : void.
	 */
	
	public void sort(int aray[]) {
		int N = aray.length-1;
		for(int counter = N/2; counter>1 ; counter--) 
			sink(aray, counter, N);
		while(N>1) {
			swap(aray, 1, N);
			sink(aray,1,--N);
		}
	}
	
	/*
	 * sink method checks if the element at 2*K and 2*K+1 position is smaller then k element.
 	 * @var : aray is the reference of the array.
 	 * @var : kIndex is the index of kth element.
 	 * @var : noOfElement is the number of elements in the array.
 	 * @return : void
	 */
	
	private void sink(int[] aray, int kIndex, int noOfElements) {
		while(2*kIndex <= noOfElements) {
			int temp = 2*kIndex;
			if(temp < noOfElements && aray[temp] < aray[temp+1])
				temp++;
			if(aray[temp] < aray[kIndex])
				break;
			swap(aray, kIndex, temp);
			kIndex = temp;
		}
	}
	
	/*
	 * swap method is used to swap 2 elements in the array.
	 * @var : aray is the reference of the array.
	 * @var : iIndex is the first index of the position to be swapped.
	 * @var : jIndex is the second index of the position to be swapped.
	 * @return : void
	 */
	
	private void swap(int[] aray, int iIndex, int jIndex){
		int temp = aray[iIndex];
		aray[iIndex] = aray[jIndex];
		aray[jIndex] = temp;
	}
}
