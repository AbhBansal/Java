package mergeSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Merge Sort, Sorting an array of Integer. 
 */

/*
 * MergeSort class contains the logic for sorting according to Merge sort algorithm
 */

public class MergeSort {
	
	/*
	 * sort method sort the array in increasing order of integer. 
 	 * @var : Aray is the reference of the array.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */
	
	public void Sort(int[] Aray, int low, int high) {
		if (low < high) {
			if (high - low > 11) {
				int q = (low + high) / 2;
				Sort(Aray, low, q);									// recursive call to the first half of the Array
				Sort(Aray, q + 1, high);							// recursive call to the Second half of the Array
				Merge(Aray, low, q, high);							// Merge the 2 half of the Array
			} 
			else { 													// Insertion sort
				for (int i = low, j = i; i < high; j = ++i) {
					int ai = Aray[i + 1];
					while (ai < Aray[j]) {
						Aray[j + 1] = Aray[j];
						if (j-- == low) {
							break;
						}
					}
					Aray[j + 1] = ai;
				}
			}
		}
	}

	/*
	 * Merge method merge the 2 parts of the array, keeping the order of array as sorted.
 	 * @var : Aray is the reference of the array.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : mid is the middle element i.e. between low and high.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */	
	
	private void Merge(int[] Aray, int low, int mid, int high) {
		int ls = mid - low + 1;
		int rs = high - mid;
		int[] L = new int[ls]; 										// Dynamic Memory for L
		int[] R = new int[rs]; 										// Dynamic Memory for R
		for (int i = low; i <= mid; i++)
			L[i - low] = Aray[i];
		for (int i = mid + 1; i <= high; i++)
			R[i - (mid + 1)] = Aray[i];
		int i = 0;
		int j = 0;
		for (int k = low; k <= high; k++) {
			if ((j >= rs) || ((i < ls) && (L[i] <= R[j])))
				Aray[k] = L[i++];
			else
				Aray[k] = R[j++];
		}
		return;
	}
}
