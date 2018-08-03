package basics_otherbook;

import java.util.Scanner;

public class numbers2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=Integer.parseInt(sc.nextLine());                  
		for(int i=1;i<=x;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			//	System.out.print((char)(j+96));                 
			}
		//	System.out.print((char)(i+96));                 

			System.out.println(); //for next line
	}
	}

}
