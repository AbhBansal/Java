package knuthShuffling;

import java.util.Random;

public class KnuthShuffling {
	
	public static void main(String args[]) {
		int pack[] = new int[52];
		Random randomGenerator = new Random();
		System.out.println("Pack of cards before Shuffling");
		for (int counter = 0; counter < pack.length; counter++) {
			pack[counter] = counter + 1;
			System.out.println("At " + (counter+1) + " place : "+ pack[counter]);
		}
		
		for (int counter = 0; counter < pack.length; counter++) {
			int randomNo = randomGenerator.nextInt(counter+1);
			swap(pack,counter,randomNo);
		}
		
		System.out.println("Pack of cards after Shuffling");
		for (int counter = 0; counter < pack.length; counter++) {
			System.out.println("At " + (counter+1) + " place : "+ pack[counter]);
		}
	}
	
	public static void swap(int[] pack,int a, int b){
		int temp = pack[a];
		pack[a]= pack[b];
		pack[b] = temp;
	}
}
