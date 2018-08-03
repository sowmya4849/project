package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigate {

	public static void main(String[] args) throws Exception {
		  System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	      driver.get("http://newtours.demoaut.com");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://www.google.co.in");
		Thread.sleep(5000);
		driver.navigate().back();//tours page
		Thread.sleep(5000);
		driver.navigate().forward();// google page
		Thread.sleep(5000);
		driver.navigate().refresh();//google page
		Thread.sleep(5000);
		driver.close();
	}

}
