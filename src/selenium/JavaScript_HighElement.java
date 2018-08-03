package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_HighElement {
	public  static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		  JavascriptExecutor js=(JavascriptExecutor) driver;

		driver.get("http://www.google.com");
		//WebElement e=driver.findElement(By.name("q"));
		//js.executeScript("arguments[0].style.border='2px double red';", e);
		//or
		js.executeScript("document.getElementById('lst-ib').style.border='2px dotted blue';");
	}

}
