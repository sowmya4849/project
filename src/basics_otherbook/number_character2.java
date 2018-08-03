package basics_otherbook;

import java.util.Scanner;

public class number_character2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		int l=sc.nextInt();
		int c=97;
		int d=1;
		for(int i=1;i<=l;i++)
		{
			if(i%2==0)
			{
				for(int j=1;j<=i;j++)
				{
					System.out.print((char)(c));                
				}
				c=c+1;
			}
			else
			{
				for(int k=1;k<=i;k++)
				{
					System.out.print(d);
				}
				d=d+1;
			}
			System.out.println();
		}

	}

}
