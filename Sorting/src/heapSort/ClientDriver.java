package heapSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Heap Sort, sorting an array of Integers. 
 */

/*
 * ClientDriver class contains the logic for client testing i.e the functioning of Heap Sorting.
 * It creates an array of Integer then Sort method sorts the array using Heap sorting.
 */

public class ClientDriver {
	
	/*
	 * main function which drives the program, object of HeapSort is created and sorting operations is performed to test.
	 */
	
	public static void main(String[] args) {
		int[] aray = new int[1100];
		HeapSort hSort = new HeapSort();
		for(int counter=1;counter<aray.length;counter++){
			aray[counter] = aray.length - counter;
		}
		System.out.println("Array before Sorting");
		for(int counter=1;counter<aray.length;counter++){
			System.out.println(aray[counter]);
		}
		hSort.sort(aray);											// Heap Sort Sorting method is invoked.
		System.out.println("Array after Sorting");
		for(int counter=1;counter<aray.length;counter++){
			System.out.println(aray[counter]);
		}
	}
}
