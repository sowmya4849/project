package basics;

import java.util.Scanner;

public class StaticArray {

	public static void main(String[] args) {
		//declare 5 numbers array
    int X[]=new int[5];
   //store 5 numbers into array
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<5;i++)
    {
    	System.out.println("Enter a number");
    	X[i]=sc.nextInt();
    	
    }
    //sorting
    for(int i=0;i<5;i++)
    {
    	 for(int j=0;i<4;i++)
    	    {
    		 if(X[j]>X[j+1])
    		 {
    			 int temp=X[i];
    			 X[j]=X[j+1];
    			 X[j+1]=temp;
    		 }
    	    }
    }
  //display array nos after sorting
    	 for(int i=0;i<5;i++)
    	    { 
    		 System.out.print(X[i]+"");
    	    }
    }
	}


