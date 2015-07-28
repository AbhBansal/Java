package partition;

import java.util.Random;

public class FindKthItem {
	
	public int findKth(int[] Aray, int k) {
		shuffling(Aray);
		System.out.println("Array Values are:");
		printAray(Aray);
		k--;
		int low = 0;
		int high = Aray.length-1;
		while(high>low)
		{
			int j = partition(Aray, low, high);
			if(j<k)
				low = j+1;
			else if(j>k)
				high = j-1;
			else
				return Aray[k];
		}
		return Aray[k];
	}
	
	private int partition(int Aray[], int low, int high) {
		int i= low;
		int j= high + 1;
		while(true) {
			while(Aray[++i]<Aray[low])
				if(i==high)
					break;
			while(Aray[low]<Aray[--j])
				if(j==low)
					break;
			if(i>=j)
				break;
			swap(Aray,i,j);
		}
		swap(Aray,low,j);
		return j;
	}
	
	private void shuffling(int Aray[]) {
		Random randomGenerator = new Random();
		for (int counter = 0; counter < Aray.length; counter++) {
			int randomNo = randomGenerator.nextInt(counter+1);
			swap(Aray,counter,randomNo);
		}
	}

	private void swap(int[] Aray, int a, int b){
		int temp = Aray[a];
		Aray[a]= Aray[b];
		Aray[b] = temp;
	}
	
	private void printAray(int[] Aray) {
		for (int counter = 0; counter < Aray.length; counter++) {
			System.out.println(Aray[counter]);
		}
	}
}
