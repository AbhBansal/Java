
public class Driver {

	public static void main(String[] args) {
		WeightedQuickUnion WQU = new WeightedQuickUnion(8);
		System.out.println("Weighted Quick Union");
		System.out.println(WQU.connected(1, 4));
		WQU.union(1,4);
		System.out.println(WQU.connected(1, 4));
		WQU.union(2,5);
		WQU.union(3,5);
		WQU.union(1,5);
		System.out.println(WQU.connected(5, 4));
		for(int counter = 0 ; counter < 7 ; counter++)
			System.out.println(counter + " and "+ (counter + 1) +" are connected "+   WQU.connected(counter, counter+1));
		
		
	}

}
