package basics;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {

	public static void main(String[] args) {
		//declare dynamic array
ArrayList<Integer>x=new ArrayList<Integer>();
//get limit from keyboard

    Scanner sc=new Scanner(System.in);
    System.out.println("Enter array size");
    int n=sc.nextInt();
	System.out.println("Enter "+n+" number");

    for(int i=0;i<n;i++)
    {
    	x.add(sc.nextInt());
    	
    }
    //sorting
    for(int i=0;i<n;i++)
    {
    	 for(int j=0;i<n-1;i++)
    	    {
    		 if(x.get(i)>x.get(j+1))
    		 {
    			 int temp=x.get(j);
    			 x.set(j, x.get(j+1));
    			 x.set(j+1, temp);
    		 }
    	    }
    }
  //display array nos after sorting
    	 for(int i=0;i<n;i++)
    	    { 
    		 System.out.print(x.get(i)+"");
    	    }
    }
	}


