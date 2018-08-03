package basics;

import java.util.Scanner;

public class primenos2_1to100 {


	public static void main(String[] args) {
		 int i =0;
	       int j =0;
	       //Empty String
	       String  primeNumbers = "";

	       for (i = 1; i <= 100; i++)         
	       { 		  	  
	          int counter=0; 	  
	          for(j =i; j>=1; j--)
		  {
	             if(i%j==0)
		     {
	 		counter = counter + 1;
	            //	 counter=1; 
		     }
		  }
		  if (counter ==2)
		  {
		     //Appended the Prime number to the String
		     primeNumbers = primeNumbers + i + " ";
		  }	
	       }	
	       System.out.println("Prime numbers from 1 to 100 are :");
	       System.out.println(primeNumbers);
	}

}
