package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Scrolling_semantic {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		//28
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		  JavascriptExecutor js=(JavascriptExecutor) driver;

		driver.get("https://semantic-ui.com/modules/dropdown.html");
	
		//scroll to bottom
				js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
				Thread.sleep(5000);
				//scroll to top
				js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
				Thread.sleep(5000);
				//Scroll to specific element in page
				WebElement e=driver.findElement(By.xpath("//*[text()='Select Country']"));
				js.executeScript("arguments[0].scrollIntoView();",e);
				Thread.sleep(5000);
				
				
	}

}
