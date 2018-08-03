package Seleniumdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	    driver.get("http://www.gmail.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //get screenshot
    File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File dest=new File("E:\\screenshot.png");
    FileUtils.copyFile(src, dest);
    //close site
    driver.close();
	}

}
