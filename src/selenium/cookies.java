package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cookies {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();    
     //delete all cookies
     driver.manage().deleteAllCookies();
     driver.get("http://newtours.demoaut.com");
     driver.manage().window().maximize();
     //check cookies were loaded for site
     if(driver.manage().getCookies().size()!=0) {
    	 System.out.println("cookies were loaded");
     }
     else {
    	 System.out.println("cookies were not loaded");

     }
     
	}
}
