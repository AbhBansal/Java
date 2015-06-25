
public class Driver {

	public static void main(String[] args) {
		QuickUnion QU = new QuickUnion(8);
		System.out.println("Quick Union");
		System.out.println(QU.connected(1, 4));
		QU.union(1,4);
		System.out.println(QU.connected(1, 4));
		QU.union(2,5);
		QU.union(3,5);
		QU.union(1,5);
		System.out.println(QU.connected(5, 4));
		for(int counter = 0 ; counter < 7 ; counter++)
			System.out.println(counter + " and "+ (counter + 1) +" are connected "+   QU.connected(counter, counter+1));
		
		
	}

}
