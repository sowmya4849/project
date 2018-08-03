package Seleniumdriver;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selection_deselection_sorting {
/*angular
	python
	Ruby
	Graphic Design
	Javascript*/
	public static void main(String[] args) throws Exception {

        int n;
        String temp;
        Scanner s = new Scanner(System.in);
        System.out.println("no of items to select:");
        n = s.nextInt();
        String names[] = new String[n];
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter items to be selected:");
        for(int i = 0; i < n; i++)
        {
            names[i] = s1.nextLine();
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (names[i].compareTo(names[j])>0) 
                {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }

            }

        }

        System.out.print("Names in Sorted Order:");
        for (int i = 0; i < n - 1; i++) 
        {     	
            System.out.print(names[i] + ",");
        }

        System.out.print(names[n - 1]);
    	System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://semantic-ui.com/modules/dropdown.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		WebElement e=driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
            e.click();
            Actions a=new Actions(driver);   	 
    			 for (int i=0; i<n; i++){
    				 while(2>1) {

    		         	String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");

    	            	if(x.equalsIgnoreCase(names[i])) {
    	            		a.sendKeys(Keys.ENTER).build().perform();
    	        			break;
    	            	}
    	            	else {
    	            		a.sendKeys(Keys.DOWN).build().perform();
    	                }
		            }
    			 }		
    			 //deselect icon 1st selcted icon
    		     driver.findElement(By.xpath("(//*[@class='delete icon'])[1]")).click();
    		     //close site
    		     driver.close();
    	 }
}
