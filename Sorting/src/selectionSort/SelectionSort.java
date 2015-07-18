package selectionSort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Selection Sort, Sorting an array of Students according to Rank. 
 */

import student.Student;

/*
 * SelectSort class contains the logic for sorting according to Selection sort algorithm
 */

public class SelectionSort {

	/*
	 * swap method is used to swap 2 elements in the students array.
	 * @var : stud is the reference of the student array.
	 * @var : a is the first index of the position to be swapped.
	 * @var : b is the second index of the position to be swapped.
	 * @return : void
	 */
	
	private void swap(Student[] stud, int a, int b){
		Student temp = stud[a];
		stud[a] = stud[b];
		stud[b] = temp;
	}
	
	/*
	 * sort method sort the student array according to rank of the student. 
 	 * @var : stud is the reference of the student array.
 	 * @return : sorted student array.
	 */
	
	public Student[] sort(Student[] stud) {
		for (int inCounter = 0; inCounter < stud.length; inCounter++) {
			Student min = stud[inCounter];
			int minPosition = inCounter;
			for (int outCounter = inCounter + 1; outCounter < stud.length; outCounter++) {
				if(min.compareTo(stud[outCounter])==1){							// student class compareTo method is used to compare 2 elements
					min = stud[outCounter];
					minPosition = outCounter;
				}
			}
			swap(stud,inCounter,minPosition);
		}
		return stud;
	}
}
