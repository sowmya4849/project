package Seleniumdriver;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class IsMultple {

	public static void main(String[] args) {
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.switchTo().frame("iframeResult");
	    WebElement e=driver.findElement(By.name("cars"));
	    Select s=new Select(e);
	    if(s.isMultiple()) {
	    	System.out.println("multiselect"); 
	    }
	    else {
	    	System.out.println("not multiselect"); 
	    }
	    Actions a=new Actions(driver);
	    a.keyDown(Keys.CONTROL).build().perform();
	    a.click(s.getOptions().get(3)).build().perform();
	    a.click(s.getOptions().get(1)).build().perform();
	    a.keyUp(Keys.CONTROL).build().perform();
	   String x= s.getFirstSelectedOption().getText();
	  System.out.println(x);
	    s.deselectAll();
//close site 
	    driver.close();
	}

}
