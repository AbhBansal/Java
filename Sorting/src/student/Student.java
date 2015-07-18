package student;

import java.util.Random;

/*
 * Student class contains the details like name and rank of a student.
 * It implements the Comparable interface which will help us in comparing 2 students according to Rank
 * @var : name is the name of the Student.
 * @var : Rank is the Rank of the Student.
 */

public class Student implements Comparable<Student>{
	
	String name;
	int Rank;

	/*
	 * Constructor of Student class which gives random name and Rank to each student.
	 */
	
	public Student(int id, int size) {
		Random randomGenerator = new Random();
		Rank = randomGenerator.nextInt(size) + 1; 
		name = (char)(id+65) + "" + id;
	}

	// Get method for name
	
	public String getName() {
		return name;
	}

	// Set method for name
	
	public void setName(String name) {
		this.name = name;
	}

	// Get method for Rank
	
	public int getRank() {
		return Rank;
	}

	// Set method for Rank
	
	public void setRank(int rank) {
		Rank = rank;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * Override compareTo Method to compare 2 students according to Rank.
	 */
	
	@Override
	public int compareTo(Student o) {
		if(this.Rank<o.getRank())
			return -1;
		else if(this.Rank>o.getRank())
			return 1;
		else
			return 0;
	}

}
