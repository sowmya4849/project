package Seleniumdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class items_dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://semantic-ui.com/modules/dropdown.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		WebElement e=driver.findElement(By.xpath(
	  				"//*[text()='Select Friend']"));
	  		Actions a=new Actions(driver);
	  		a.click(e).build().perform();
	  		Thread.sleep(5000);
	  		//collect items in dropdown
	  		List<WebElement>l=driver.findElements(By.xpath("//*[@class='menu transition visible']/div"));
	       for(int i=0;i<l.size();i++) {
	    	   String x=l.get(i).getAttribute("data-value");
	    	   System.out.println(x);
	       }
	  		//close site
	       driver.close();
	}

}
