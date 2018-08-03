package basics_otherbook;

import java.util.Scanner;

public class reversegivenno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		long x=Integer.parseInt(sc.nextLine());
		long y=0;
		while(x!=0)
		{
			int d=(int) (x%10); //get last digit
		//	System.out.println(d);
			y=y*10+d; //add to reverse
		//	System.out.println(y);
			x=(int)x/10; //remove last digit
	//		System.out.println(x);
		}
		System.out.println(y);
	}

}
