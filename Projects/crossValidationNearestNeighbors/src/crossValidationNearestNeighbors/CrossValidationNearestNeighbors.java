package crossValidationNearestNeighbors;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement cross validation evaluation of the k-nearest-neighbors algorithm.
 */

/*
 * CrossValidationNearestNeighbors is the Client testing class
 */

public class CrossValidationNearestNeighbors {

	/*
	 * main method invokes the call to evaluate cross validation of k-nearest-neighbors
	 */
	
	public static void main(String[] args) throws Exception{
		CrossValidation CV = new CrossValidation();
		CV.kCrossValidation();
	}
}
