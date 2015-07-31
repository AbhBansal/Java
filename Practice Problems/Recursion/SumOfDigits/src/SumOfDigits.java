
public class SumOfDigits
{
	static int n=1;
	public static int Recursion(int n)
	{
		if(n/10==0)
			return n;
		else
		{
			return (n%10 + Recursion(n/10));
		}
	}
	
		public static void main(String[] args) 
	{
			int sum=Recursion(1234);
			System.out.println(sum);
	}
}