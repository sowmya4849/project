package Seleniumdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Divtag_singleselect {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://semantic-ui.com/modules/dropdown.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		WebElement e=driver.findElement(By.xpath(
	  				"(//*[@class='ui dropdown'])[1]"));
	  		Actions a=new Actions(driver);
	  		a.click(e).build().perform();
	  		Thread.sleep(5000);
	  		for(int i=0;i<=2;i++) {
	  			a.sendKeys(Keys.DOWN).build().perform();
	  		}
  			a.sendKeys(Keys.ENTER).build().perform();
  			Thread.sleep(5000);
  			
  			WebElement e1=driver.findElement(By.xpath(
	  				"(//*[@class='ui selection dropdown'])[1]"));
  			a.click(e1).build().perform();
	  		a.sendKeys("f").build().perform();
	  		Thread.sleep(5000);
	  		a.sendKeys(Keys.ENTER).build().perform();
	  		Thread.sleep(5000);
	  		
	  	//close site
	  		driver.close();
	}

}
