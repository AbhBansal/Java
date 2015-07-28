package partition;

public class ClientDriver {

	public static void main(String[] args) {

		FindKthItem findK = new FindKthItem();
		
		int Aray[] = new int[1000];
		for (int counter = 0; counter < Aray.length; counter++) {
			Aray[counter] = counter+1;
		}
		int k = 5;
		int kthElement = findK.findKth(Aray, k);
		System.out.println();
		System.out.println(k + "th Item is : "  + kthElement);
	}

}
