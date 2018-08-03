package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_click {
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumbymahesh.com/HMS");
		driver.findElement(By.name("username")).sendKeys("admin");
		  driver.findElement(By.name("password")).sendKeys("admin");
		  //WebElement e=driver.findElement(By.name("submit"));
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		//  js.executeScript("arguments[0].click();",e);
		 js.executeScript("document.getElementsByName('submit')[0].click();");
		  //driver.findElement(By.name("submit")).click();

	}

}
