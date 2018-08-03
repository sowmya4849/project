package Seleniumdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JqueryDroppable {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
	    Thread.sleep(5000);
		driver.switchTo().frame(0);
				WebElement e1=driver.findElement(By.id("draggable"));
				WebElement e2=driver.findElement(By.id("droppable"));
				Actions a=new Actions(driver);
				a.dragAndDrop(e1,e2).build().perform();
				driver.switchTo().defaultContent();
				
		
	}

}
