package Seleniumdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Move_To_Element {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://www.flipkart.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		if(driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).isDisplayed()) {
	  			driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
	  		}
	  		//move mouse pointer to an element
	  		Actions a=new Actions(driver);
	  		WebElement e=driver.findElement(By.xpath("//*[text()='Women']"));
	  		a.moveToElement(e).build().perform();
	  		//close site
	  		driver.close();
	}

}
