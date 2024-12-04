package BasicMath;

import java.util.Scanner;

public class DecimalToBinary {
	public static void main(String[] args) {
	//	Scanner sc=new Scanner(System.in);
		//toConvertDecimalToBinary(sc.nextInt());
	System.out.println(binaryToDecimal(1010, 0));	
	}
	public static void toConvertDecimalToBinary(int no)
	{
		
		if(no!=0)
		{
			toConvertDecimalToBinary(no/2);
			System.out.print(no%2);
		}
	}
	
//	
	public static int binaryToDecimal(int no,int pow)
	{
		
		if(no==0)
		{
			return 0;
		}
		
		int lastDegit=no%10;
		
		return (lastDegit * ((int) Math.pow(2, pow))) + binaryToDecimal(no/10, pow+1);
	}
	

}
