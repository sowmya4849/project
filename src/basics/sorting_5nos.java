package basics;

import java.util.Scanner;

public class sorting_5nos {

	public static void main(String[] args) {
		int n;
		//declare 5 nos array
		int x[]=new int[5];
		//store 5nos
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter all nos");
		for(int i=0;i<5;i++) {
			x[i]=sc.nextInt();
			
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<4;j++) {
				if(x[j]>x[j+1] ){
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
					
				}
			}
		}
		//display 5 nos 
		for(int i=0;i<5;i++) {
			System.out.print(x[i]+" ");
		}
	}

}
