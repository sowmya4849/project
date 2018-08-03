package Seleniumdriver;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selection_deselction {
/*angular
	python
	Ruby
	Graphic Design
	Javascript*/
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("no:of items to select");
		int n=Integer.parseInt(sc.nextLine());
		ArrayList<String>al=new ArrayList<String>();
		System.out.println("Enter items to be selected");
		for(int i=0;i<n;i++) {
			al.add(sc.nextLine());
		}
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://semantic-ui.com/modules/dropdown.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		WebElement e=driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
            e.click();
            Actions a=new Actions(driver);
            //select items
            for(int i=0;i<n;i++) {  	
            	while(2>1) {
            		String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");
            		
            		if(x.equalsIgnoreCase(al.get(i))) {
            			a.sendKeys(Keys.ENTER).build().perform();
            			break;
            		}
            		else {
            			a.sendKeys(Keys.DOWN).build().perform();
            			Thread.sleep(2000);
            		}
            	}
          }   
            //deselect icon 1st selcted icon
            driver.findElement(By.xpath("(//*[@class='delete icon'])[1]")).click();
            //close site
            driver.close();
	}

}
