package Seleniumdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tooltips {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		//get tooltip via title attribute
		WebElement e1=driver.findElement(By.linkText("JAVASCRIPT"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		//scroll page to specific element
		JavascriptExecutor js=driver;
		WebElement e2=driver.findElement(By.xpath("//*[text()='Demo: Tooltip Examples']"));
		js.executeScript("arguments[0].scrollIntoView();", e2);
		//move mouse pointer to element for tooltip visibility
		WebElement e3=driver.findElement(By.xpath("(//*[@class='tooltip'])[1]"));
	    Actions a=new Actions(driver);
	    a.moveToElement(e3).clickAndHold().build().perform();
		WebElement e4=driver.findElement(By.xpath("(//*[@class='tooltip'])[1]/span"));
		String y=e4.getText();
		System.out.println(y);
		a.release().build().perform();
		//close site
		driver.close();

		
	}

}
