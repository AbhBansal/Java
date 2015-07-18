package mergeSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Merge Sort, Sorting an array of Integer using an Auxiliary array. 
 */

/*
 * BetterMergeSort class contains the logic for sorting according to Merge sort algorithm
 */

public class BetterMergeSort {
	
	/*
	 * sort method sort the array in increasing order of integer. 
 	 * @var : Aray is the reference of the array.
 	 * @var : Auxiliary Array is used to perform merging.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */
	
	public void Sort(int[] Aray, int[] Aux, int low, int high) {
		if (low < high) {
			if (high - low > 11) {
				int mid = (low + high) / 2;
				Sort(Aray, Aux, low, mid);								// recursive call to the first half of the Array
				Sort(Aray, Aux, mid + 1, high);							// recursive call to the Second half of the Array
				Merge(Aray, Aux, low, mid, high);						// Merge the 2 half of the Array using auxiliary array
			} 
			else { 														// Insertion sort
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
 	 * @var : Auxiliary Array is used to perform merging.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : mid is the middle element i.e. between low and high.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */	
	
	private void Merge(int[] Aray, int[] Aux, int low, int mid, int high) {
		for (int i = low; i <= mid; i++)
			Aux[i] = Aray[i]; 											// Data is copied from Aray to Aux
		for (int i = mid + 1; i <= high; i++)
			Aux[i] = Aray[i]; 											// Data is copied from Aux to Aray
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) // Merger back to A
		{
			if ((j > high) || ((i <= mid) && (Aux[i] <= Aux[j])))
				Aray[k] = Aux[i++];
			else
				Aray[k] = Aux[j++];
		}
		return;
	}
}
