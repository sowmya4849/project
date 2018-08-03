package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Automatingsliders {

	public static void main(String[] args) throws Exception {
		 System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	      driver.get("http://jqueryui.com/slider");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        WebElement e=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
        	Actions a =new Actions(driver);
        	int x=e.getLocation().getX();
        	int y=e.getLocation().getY();
        //	slide from left to right
        	a.dragAndDropBy(e, x+200, y).build().perform();
        	Thread.sleep(5000);
//        	slide from right to left
        	a.dragAndDropBy(e, x-200, y).build().perform();
        	driver.switchTo().defaultContent();
        	Thread.sleep(5000);
        	driver.findElement(By.linkText("Vertical slider")).click();
            driver.switchTo().frame(0);
        	Thread.sleep(5000);

            WebElement e1=driver.findElement(By.xpath("//*[@id='slider-vertical']/child::*[2]"));
            int p=e1.getLocation().getX();
            int q=e1.getLocation().getY();
        	Thread.sleep(5000);
            //slide from top to bottom
        	a.dragAndDropBy(e1,p, q-45).build().perform();
        	Thread.sleep(5000);
        	a.dragAndDropBy(e1,p, q+10).build().perform();
        	Thread.sleep(5000);

        	driver.switchTo().defaultContent();
        	//close site
        	driver.close();


        	
        	

	}

}
