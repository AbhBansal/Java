package shellsort;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement Shell Sort, Sorting an array of Students according to Rank. 
 */

import student.Student;

/*
 * Shellsort class contains the logic for sorting according to Shell sort algorithm
 */

public class Shellsort {

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
		int h=1;
		while(h < (stud.length / 3))
			h = ( 3 * h ) + 1;
		while(h>=1) {
			for (int inCounter = h; inCounter < stud.length; inCounter++) {
				for (int outCounter = inCounter; outCounter >= h; outCounter-=h) {
					if(stud[outCounter].compareTo(stud[outCounter-h])==-1){
						swap(stud,outCounter,outCounter-h);
					}
					else
						break;
				}
			}
			h = h/3;
		}
		return stud;
	}
}
