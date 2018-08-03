package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Alert {
	public  static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;

		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//get invisible items from <div>based dropdown
		List<WebElement>l=driver.findElements(By.xpath("(//*[contains(@class,'dropdown selection multiple')])[1]/div[2]/div"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++) {
			//for each element get text in to a variable & create / send to alert
			js.executeScript("var x=arguments[0].textContent; alert(x);",l.get(i));		
			String y=driver.switchTo().alert().getText();
			System.out.println(y);
			Thread.sleep(5000);
			driver.switchTo().alert().dismiss();	
		}
	 driver.close();
	}

}
