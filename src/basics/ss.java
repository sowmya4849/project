/**
 * 
 */
package basics;

import java.util.Scanner;

public class ss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n,temp;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter no of values");
         n=s.nextInt();
         int a[]=new int [n];
         System.out.println("Enter all values");

        for(int i=0;i<n;i++) {
        	a[i]=s.nextInt();
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
            	 if (a[i] > a[j]) 
                 {
                     temp = a[i];
                     a[i] = a[j];
                     a[j] = temp;
                 }
            }

        }	
        System.out.println("Ascending order...");
        for (int i = 0; i < n - 1; i++) 
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[n - 1]);
        
      
       
	}

}
