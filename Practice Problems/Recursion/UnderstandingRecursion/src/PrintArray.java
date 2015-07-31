
public class PrintArray 
{
	static int n=1;
	public static void Recursion(int k)
	{
		int i=0;
		while(n!=10)
		{
			n++;
			k++;
			i++;
			System.out.println("UP Hello n= " + n + " i=" +i +" k="+k );
			Recursion(k);
			System.out.println("DOWN Hello n= " + n + " i=" +i +" k="+k );
		}
	}
	
		public static void main(String[] args) 
	{
		Recursion(1);
	}
}
