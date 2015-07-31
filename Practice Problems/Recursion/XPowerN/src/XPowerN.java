
public class XPowerN
{
	static int n=1;
	public static int Recursion(int x,int n)
	{	
		int temp;
		if(n==0)
			return 1;
		else
		{
			temp=Recursion(x,n/2);
			if(n%2==0)
				return (temp*temp);
			else
				return (x*temp*temp);
		}
	}
	
		public static void main(String[] args) 
	{
			int Power=Recursion(2,4);
			System.out.println(Power);
	}
}