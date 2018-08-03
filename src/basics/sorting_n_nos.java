package basics;

import java.util.Scanner;

public class sorting_n_nos {

	public static void main(String[] args) {
		//declare 5 nos array
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no:of elements");
		int n=sc.nextInt();
		int x[]=new int[n];
		//store 5nos
		System.out.println("Enter all nos");
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
			
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				if(x[j]>x[j+1] ){
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
					
				}
			}
		}
		//display 5 nos 
		for(int i=0;i<n;i++) {
			System.out.print(x[i]+"");
		}

	}

}
