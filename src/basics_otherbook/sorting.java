package basics_otherbook;

import java.util.Scanner;

public class sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create static array
				int x[]=new int[5];
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter 5 values");
				for(int i=0;i<5;i++)
				{
					x[i]=sc.nextInt();
				}
				//sorting
				for(int i=0;i<5;i++)
				{
					for(int j=0;j<4;j++)
					{
						if(x[j]>x[j+1])
						{
							int temp=x[j];
							x[j]=x[j+1];
							x[j+1]=temp;
						}
					}
				}
				//Display array
				for(int i=0;i<5;i++)
				{
					System.out.println(x[i]);                          
				}
	}

}
