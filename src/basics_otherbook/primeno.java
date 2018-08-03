package basics_otherbook;

import java.util.Scanner;

public class primeno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Get data from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter a number");
				int x=Integer.parseInt(sc.nextLine());
				int flag=0;
				for(int i=2;i<x;i++)
				{
					if(x%i==0)
					{
						flag=1;
					}
				}
				if(flag==0)
				{
					System.out.println(x+" is prime number");           
				}
				else
				{
					System.out.println(x+" is not prime");
				}

	}

}
