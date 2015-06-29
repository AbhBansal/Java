
public class Driver {

	public static void main(String[] args) {
		QuickFind QF = new QuickFind(8);
		System.out.println("Quick Find");
		System.out.println(QF.connected(1, 4));
		QF.union(1,4);
		System.out.println(QF.connected(1, 4));
		QF.union(2,5);
		QF.union(3,5);
		QF.union(1,5);
		System.out.println(QF.connected(5, 4));
		for(int counter = 0 ; counter < 7 ; counter++)
			System.out.println(counter + " and "+ (counter + 1) +" are connected "+   QF.connected(counter, counter+1));
		
		
	}

}
