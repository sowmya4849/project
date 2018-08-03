package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Disableelement {
	public  static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//29
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.get("http://www.google.com");
		//disable textbox
		WebElement e =driver.findElement(By.name("q"));
		js.executeScript("arguments[0].setAttribute('disabled',true);", e);
		Thread.sleep(10000);
		js.executeScript("arguments[0].removeAttribute('disabled');", e);

	}

}
