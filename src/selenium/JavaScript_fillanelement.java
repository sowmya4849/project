package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_fillanelement {
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		  JavascriptExecutor js=(JavascriptExecutor) driver;

		driver.get("http://www.seleniumbymahesh.com/HMS");
	
		WebElement ele=driver.findElement(By.name("username"));
		js.executeScript("arguments[0].value='admin';", ele);
		//driver.findElement(By.name("username")).sendKeys("admin");
		
		driver.findElement(By.name("password")).sendKeys("admin");
		 
		WebElement e=driver.findElement(By.name("submit"));
		  js.executeScript("arguments[0].click();",e);
		//  js.executeScript("document.getElementByName('submit').click();");
		  //driver.findElement(By.name("submit")).click();

	}

}
