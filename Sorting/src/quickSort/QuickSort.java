package quickSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Quick Sort, Sorting an array of Students according to Rank. 
 */

import java.util.Random;
import student.Student;

/*
 * QuickSort class contains the logic for sorting according to Quick sort algorithm
 */

public class QuickSort {

	/*
	 * sort method creates, shuffle the student array and call the main sorting method. 
 	 * @var : stud is the reference of the student array.
 	 * @return : void.
	 */
	
	public void sort(Student[] stud) {
		createStudents(stud);								// Creates a Student array
		shuffling(stud);									// Shuffling of the elements in the array.
		System.out.println("Before Soting");
		printStud(stud);
		System.out.println("---------");
		sort(stud, 0, stud.length-1);						// Call the main logic of Sorting method.
		System.out.println();
		System.out.println("After Sorting according to Rank");
		printStud(stud);
	}
	
	/*
	 * sort method sort the student array according to rank of the student. 
 	 * @var : stud is the reference of the student array.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : void.
	 */
	
	private void sort(Student[] stud, int low, int high) {
		if(high<=low)
			return;
		int j = partition(stud, low, high);						// call Partition method to divide the array in 2 parts 
		sort(stud, low, j-1);									// recursive call to the first partition	
		sort(stud, j+1, high);									// recursive call to the second partition
	}
	
	/*
	 * partition method partition the stud array into 2 parts keeping key element in middle,
	 * element in the first part are less then key and 2nd part are greater then key.
 	 * @var : stud is the reference of the student array.
 	 * @var : low is the lower range of array to be sorted.
 	 * @var : high is the upper range of array to be sorted.
 	 * @return : int is the index of the partition
	 */
	
	private int partition(Student stud[], int low, int high) {
		int i= low;
		int j= high + 1;
		while(true) {
			while(stud[++i].compareTo(stud[low])==-1)
				if(i==high)
					break;
			while(stud[low].compareTo(stud[--j])==-1)
				if(j==low)
					break;
			if(i>=j)
				break;
			swap(stud,i,j);
		}
		swap(stud,low,j);
		return j;
	}
	
	/*
	 * shuffling method shuffles the student array, it is required for good performance of Quick sort
 	 * @var : stud is the reference of the student array.
 	 * @return : void
	 */
	
	private void shuffling(Student stud[]) {
		Random randomGenerator = new Random();
		for (int counter = 0; counter < stud.length; counter++) {
			int randomNo = randomGenerator.nextInt(counter+1);
			swap(stud,counter,randomNo);
		}
	}

	/*
	 * swap method is used to swap 2 elements in the students array.
	 * @var : stud is the reference of the student array.
	 * @var : a is the first index of the position to be swapped.
	 * @var : b is the second index of the position to be swapped.
	 * @return : void
	 */
	
	private void swap(Student[] stud, int a, int b){
		Student temp = stud[a];
		stud[a]= stud[b];
		stud[b] = temp;
	}
	
	/*
	 * printStud method prints the student array.
	 * @var : stud is the reference of the student array.
	 * @return : void 
	 */
	
	private void printStud(Student[] stud) {
		for (int counter = 0; counter < stud.length; counter++) {
			System.out.println("Student Name: " + stud[counter].getName() + ", Rank: " + stud[counter].getRank());
		}
	}
	
	/*
	 * createStudents method creates a random Student array.
	 * @var : stud is the reference of the student array.
	 * @return : void.
	 */
	
	private void createStudents(Student[] stud) {
		for (int counter = 0; counter < stud.length; counter++) {
			stud[counter] = new Student(counter, stud.length);
		}
	}
}
