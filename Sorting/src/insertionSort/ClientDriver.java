package insertionSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Insertion Sort, Sorting an array of Students according to Rank. 
 */

import student.Student;

/*
 * ClientDriver class contains the logic for client testing i.e the functioning of Insertion Sorting.
 * It creates an array of Student class then Sort method sorts the array using Insertion sorting.
 */

public class ClientDriver {
	
	/*
	 * main function which drives the program, object of InsertionSort is created and sorting operations is performed to test.
	 */
	
	public static void main(String[] args) {
		InsertionSort iSort = new InsertionSort();									// Object of InsertionSort
		Student stud[] = new Student[10000];										// Student array
		int studSize = stud.length;
		for (int counter = 0; counter < stud.length; counter++) {
			stud[counter] = new Student(counter, studSize);
		}
		System.out.println("Unsorted Students according to Rank");
		
		for (int counter = 0; counter < stud.length; counter++) {
			System.out.println("Student Name: " + stud[counter].getName() + ", Rank: " + stud[counter].getRank());
		}
		long start = System.currentTimeMillis();
		stud = iSort.sort(stud);													// Insertion Sort Sorting method is invoked.
		long last = System.currentTimeMillis();
		System.out.println();
		System.out.println("Sorted Students according to Rank");
		for (int counter = 0; counter < stud.length; counter++) {
			System.out.println("Student Name: " + stud[counter].getName() + ", Rank: " + stud[counter].getRank());
		}
		System.out.println();
		System.out.println("Total time Insertion Sort take to Sort " + stud.length + " Students is "+ (last-start) + "ms");
	}
}
