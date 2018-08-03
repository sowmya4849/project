package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Scrolling {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
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
		  Thread.sleep(5000);
		  WebElement e1=driver.findElement(By.linkText("Registration"));
		  js.executeScript("arguments[0].click();", e1);
		  Thread.sleep(2000);
		  WebElement reg=driver.findElement(By.linkText("Perminent Registration"));
		  js.executeScript("arguments[0].click();", reg);
		  Thread.sleep(5000);
		  //scroll to bottom
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		  Thread.sleep(5000);
		  //scroll to top
		  js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		 Thread.sleep(5000);
		 WebElement country=driver.findElement(By.name("COUNTRY_CODE"));
		 js.executeScript("arguments[0].scrollIntoView();", country);
		//  js.executeScript("document.getElementByName('submit').click();");
		  //driver.findElement(By.name("submit")).click();

	}

}
