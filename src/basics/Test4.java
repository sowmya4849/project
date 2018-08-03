package basics;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		int l=sc.nextInt();
		for(int i=1;i<=l;i++)
		{
			for(int j=1;j<=l-i;j++)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)                               
			{
				System.out.print("*");
			}
			for(int m=1;m<i;m++)
			{
				System.out.print("*");
			}
			System.out.println();
		}


	}

}
