package basics;

import java.util.Scanner;

public class sorting_alphabets {

	public static void main(String[] args) {

		//declare 5 nos array
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no:of elements");
		int n=sc.nextInt();
		String x[]=new String[n];
		//store 5nos
		System.out.println("Enter all nos");
		for(int i=0;i<n;i++) {
			x[i]=sc.nextLine();
			
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(x[i].compareTo(x[j] )>0){
					String temp=x[i];
					x[i]=x[j];
					x[j]=temp;
					
				}
			}
		}

	//display 5 nos 
		for(int i=0;i<n-1;i++) {
			System.out.print(x[i]+",");
		}
		System.out.print(x[n-1]);

	}

}
