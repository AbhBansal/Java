
public class PrintDigitsBinHexRev
{
	static char dig[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public static int Recursion_Bin(int n)
	{
		if(n==1)
			return 1;
		else
		{
			int temp=Recursion_Bin(n/2);
			temp = temp * 10 + (n %2);
			return temp;
		}
	}
	public static void Recursion_Hex(int n)
	{
		if(n<16)
		System.out.print(dig[n%16]);		
		else
		{
			Recursion_Hex(n/16);
			System.out.print(dig[n%16]);
		}
	}
	
		public static void main(String[] args) 
	{
			int Binary = Recursion_Bin(5);
			System.out.println(Binary);
			Recursion_Hex(1243);
	}
}