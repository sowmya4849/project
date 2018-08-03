package Seleniumdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dropdown_divtag {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://semantic-ui.com/modules/dropdown.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		WebElement e=driver.findElement(By.xpath(
	  				"(//*[contains(@class,'fluid dropdown')])[1]"));
	  		Actions a=new Actions(driver);
	  		a.click(e).build().perform();
	  		Thread.sleep(5000);
	  		a.sendKeys("a").build().perform();
	  		Thread.sleep(5000);
	  		a.sendKeys(Keys.ENTER).build().perform();
	  		Thread.sleep(5000);
	  		a.sendKeys("c").build().perform();
	  		Thread.sleep(5000);
	  		a.sendKeys(Keys.ENTER).build().perform();
	  		Thread.sleep(5000);
	  		//De-select all items
	  		for(int i=4;i>=3;i--)
	  		{
	  			driver.findElement(By.xpath("(//*[contains(@class,'fluid dropdown')])[1]/child::*["+i+"]/child::*")).click();
	  		}
	  		driver.close();
	}

}
