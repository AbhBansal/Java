package mergeSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement and Analysis Merge Sort with different Algorithms, Sorting an array of Integer. 
 */

/*
 * ClientDriver class contains the logic for client testing i.e the functioning of Merge Sorting.
 * It creates an array of Integer then Sort method sorts the array using different Algorithms of Merge sort.
 */

public class ClientDriver {

	/*
	 * main function which drives the program, object of MergeSort, BetterMergeSort, EvenBetterMergeSort is created and sorting operations is performed to test.
	 */
	
	public static void main(String[] args) {
		System.out.println("Merge Sort");
		int n = Integer.parseInt(args[0]);
		int[] Aray = new int[n];
		int[] Aux = new int[n]; 												// Auxiliary Array
		MergeSort mSort = new MergeSort();										// Object of MergeSort
		BetterMergeSort bmSort = new BetterMergeSort();							// Object of BetterMergeSort
		EvenBetterMergeSort ebmSort = new EvenBetterMergeSort();				// Object of EvenBetterMergeSort
		for (int i = 0; i < n; i++) {
			Aray[i] = n - i;
		}
		
		long start = System.currentTimeMillis();
		mSort.Sort(Aray, 0, n - 1);												// Merge Sort Sorting method is invoked.
		long last = System.currentTimeMillis();
		
		for (int j = 0; j < Aray.length - 1; j++) {
			if (Aray[j] > Aray[j + 1]) {
				System.out.println("Sorting failed :-(");
				return;
			}
		}
		System.out.println("Merge Sort was Successfull!! :-)");
		System.out.println("Execution time of Sorting is : " + (last - start) + "ms");
		
		System.out.println();
		System.out.println("Better Merge Sort");
		for (int i = 0; i < n; i++) {
			Aray[i] = n - i;
		}
		
		start = System.currentTimeMillis();
		bmSort.Sort(Aray, Aux, 0, n - 1);										// BetterMerge Sort Sorting method is invoked.
		last = System.currentTimeMillis();
		
		for (int j = 0; j < Aray.length - 1; j++) {
			if (Aray[j] > Aray[j + 1]) {
				System.out.println("Sorting failed :-(");
				return;
			}
		}
		System.out.println("Better Merge Sort was Successfull!! :-)");
		System.out.println("Execution time of Sorting is : " + (last - start) + "ms");

		System.out.println();
		System.out.println("Even Better Merge Sort");
		for (int i = 0; i < n; i++) {
			Aray[i] = n - i;
			Aux[i] = n - i;
		}
		
		start = System.currentTimeMillis();
		int c = ebmSort.Sort(Aray, Aux, 0, n - 1);								// EvenBetterMerge Sort Sorting method is invoked.
		last = System.currentTimeMillis();
		
		if (c % 2 == 0) {
			for (int j = 0; j < Aray.length - 1; j++) {
				if (Aray[j] > Aray[j + 1]) {
					System.out.println("Sorting failed :-(");
					return;
				}
			}
		} else {
			for (int j = 0; j < Aux.length - 1; j++) {
				if (Aux[j] > Aux[j + 1]) {
					System.out.println("Sorting failed :-(");
					return;
				}
			}
		}
		System.out.println("Even Better Merge Sort was Successfull!! :-)");
		System.out.println("Execution time of Sorting is : " + (last - start) + "ms");
	}
}
