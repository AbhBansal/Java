package mergeSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Merge Sort, Sorting an array of Integer using an Auxiliary array but while merging data is not copied from Aray to Aux.
 * In 1 iteration Aray is Source and Aux is Destination, while in 2nd iteration it is opposite 
 */

/*
 * EvenBetterMergeSort class contains the logic for sorting according to Merge sort algorithm
 * @var: Flag is used to indicate the depth of recursion, if depth is same flag is zero, else 1.
 */

public class EvenBetterMergeSort {
	
	private int Flag = 0;

	/*
	 * sort method sort the array in increasing order of integer. 
 	 * @var : Aray is the reference of the array.
 	 * @var : Auxiliary Array is used to perform merging.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */
	
	public int Sort(int[] Aray, int[] Aux, int low, int high) {
		int h1 = 0, h2 = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			h1 = Sort(Aray, Aux, low, mid);							// recursive call to the first half of the Array
			h2 = Sort(Aray, Aux, mid + 1, high);					// recursive call to the Second half of the Array
			if (h1 != h2) 											// When it will not be power of 2 then h1!=h2 at some point
			{
				Flag = 1;
				if (h1 % 2 != 0) 									// h1 will always be greater then h2.
				{
					Merge(Aux, Aray, low, mid, high);				// Merge the 2 half of the Array when h1 != h2 and h1 is at an even level
				} else {
					Merge(Aray, Aux, low, mid, high);				// Merge the 2 half of the Array when h1 != h2 and h1 is at an odd level
				}
				return h1 + 1;
			}
			if (h1 % 2 == 0) {
				Merge(Aray, Aux, low, mid, high);					// Merge the 2 half of the Array when h1 == h2 and h1 is at an even level
			} else {
				Merge(Aux, Aray, low, mid, high);					// Merge the 2 half of the Array when h1 == h2 and h1 is at an odd level	
			}
			return h1 + 1;

		} else
			return 0;
	}

	/*
	 * Merge method merge the 2 parts of the array, keeping the order of array as sorted.
 	 * @var : Src is the Array to be merged.
 	 * @var : Dest is the Array in which merged array will be stored.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : mid is the middle element i.e. between low and high.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */	
	
	private void Merge(int[] Src, int[] Dest, int low, int mid, int high) 		// Src and Dest alternates data between A and B
	{
		int i = low;
		int j = mid + 1;
		if (Flag == 1) 															// When h1!=h2
		{
			for (int k = low; k <= high; k++) {
				if ((j > high) || ((i <= mid) && (Src[i] <= Dest[j])))
					Dest[k] = Src[i++];
				else
					Dest[k] = Dest[j++];
			}
			Flag = 0;
		} else 																	// When h1=h2
		{
			for (int k = low; k <= high; k++) {
				if ((j > high) || ((i <= mid) && (Src[i] <= Src[j])))
					Dest[k] = Src[i++];
				else
					Dest[k] = Src[j++];
			}
		}
		return;
	}
}
