package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

public class cache_javaScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.get("http://www.google.com");
		//fill textbox
	    driver.findElement(By.name("q")).sendKeys("kalam");
	    Thread.sleep(5000);
	    //get options visible in auto-complete/cache
	    List<WebElement>l=driver.findElements(By.xpath("//*[@role='presentation']/div/div[2]"));
	    System.out.println(l.size());
	    for(int i=0;i<l.size();i++) {
	    	js.executeScript("var x=arguments[0].textContent;window.alert(x);", l.get(i));
	    	String y=driver.switchTo().alert().getText();
	    	driver.switchTo().alert().dismiss();
	    	System.out.println(y);
	    	if(y.equals("kalamandir")) {
	    		driver.findElement(By.name("q")).clear();
	    		driver.findElement(By.name("q")).sendKeys(y);
	    		Thread.sleep(5000);
	    		break;
	    	}
	    	
	    }
	//close site
	    driver.close();
	}

}
