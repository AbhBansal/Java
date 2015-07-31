
public class XPowerNModP
{
	static int n=1;
	public static int Recursion(int x,int n,int p)
	{	
		int temp;
		if(n==1)
			return x;
		else
		{
			temp=Recursion(x,n/2,p);
			if(n%2==0)
				return (temp*temp) % p;
			else
				return (x*temp*temp) % p;
		}
	}
	
		public static void main(String[] args) 
	{
			int Power=Recursion(2,2,3);
			System.out.println(Power);
	}
}