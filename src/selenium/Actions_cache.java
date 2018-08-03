package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_cache {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		//select 5 th item in google cache
	    driver.findElement(By.name("q")).sendKeys("kalam");
	    Thread.sleep(5000);
	    Actions a=new Actions(driver);
	    for(int i=0;i<5;i++) {
	    	a.sendKeys(Keys.DOWN).build().perform();
	    	Thread.sleep(5000);
	    }
    	a.sendKeys(Keys.ENTER).build().perform();

	}

}
