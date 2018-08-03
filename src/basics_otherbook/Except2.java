package basics_otherbook;

import java.util.Scanner;

public class Except2 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		System.out.println("Enter another number");
		int y=sc.nextInt();
		if(y==0)
		{
			throw new ArithmeticException();
		}
		int z=x/y;
		System.out.println(z);	
	}

}
