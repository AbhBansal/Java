package quickSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Quick Sort, Sorting an array of Students according to Rank. 
 */

import student.Student;

/*
 * ClientDriver class contains the logic for client testing i.e the functioning of Quick Sorting.
 */

public class ClientDriver {

	/*
	 * main function which drives the program, object of QuickSort is created and sorting operations is performed to test.
	 */
	
	public static void main(String[] args) {
		Student stud[] = new Student[50];
		QuickSort QS = new QuickSort();					// Object of QuickSort class.
		QS.sort(stud);									// Quick Sort Sorting method is invoked.
	}
}
