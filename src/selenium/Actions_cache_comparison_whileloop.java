package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_cache_comparison_whileloop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		//select  item in google cache
	    driver.findElement(By.name("q")).sendKeys("kalam");
	    Thread.sleep(5000);
	    Actions a=new Actions(driver);
	    int c=0;
	    while(2>1)//infinite loop
	    {
	    	String x=driver.findElement(By.name("q")).getAttribute("value");
	    	if(x.equals("kalamandalam"))
	    	{
	    		a.sendKeys(Keys.ENTER).build().perform();
	    		break;
	    	}
	    	else {
	        	a.sendKeys(Keys.DOWN).build().perform();
	        	c=c+1;
	        	if(c>10)
	        	{
	        		a.sendKeys(Keys.ESCAPE).build().perform();
	        		break;
	        	}
	        	Thread.sleep(2000);
	    	}
	    }
	    driver.close();
	}

}
