package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iSDisplayed_Selected_Enabled {

	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	      driver.get("https://www.mercurytravels.co.in");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         //click on flights
         driver.findElement(By.xpath("//*[@id='flights']")).click();
         WebElement e=driver.findElement(By.xpath("(//*[@id='tripType'])[2]"));
         if(e.isDisplayed()) {
        	 if(e.isEnabled()) {
        		 e.click();
        		 //check oneway is selected or not
        		 if(e.isSelected()) {
        			 System.out.println("selected");
        		 }
        		 else {
        			 System.out.println("not selected");
        		 }
        	 }else {
        		 System.out.println("disabled");
        	 }
         }else {
        	 System.out.println("not displayed");
         }
         //close site
         driver.close();
	}

}
