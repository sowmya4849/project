package selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getWIndow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	   	driver.get("http://www.way2sms.com/content/index.html?");
	   	driver.findElement(By.xpath("//*[contains(@src,'android-button')]")).click();
	    ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
	   	driver.switchTo().window(a.get(1));
	   	Thread.sleep(2000);
	   	driver.close();
	   	driver.switchTo().window(a.get(0));
	   	driver.findElement(By.name("username")).sendKeys("9632584725");
	   	Thread.sleep(8000);

driver.close();
	}

}
