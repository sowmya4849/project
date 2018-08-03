package selenium;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Selenium_Fluentwait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		//fill textbox
		FluentWait w=new FluentWait(driver).withTimeout(10,TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("kalam");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.close();

	}

}
