package basics_otherbook;

import java.util.Scanner;

public class even_odd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Get data from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter a number");
				int x=Integer.parseInt(sc.nextLine());
				//validation
				if(x%2==0)
				{
					System.out.println(x+" is even number");            
				}
				else
				{
					System.out.println(x+" is odd number");
				}
				

	}

}
