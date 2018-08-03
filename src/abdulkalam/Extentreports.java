package abdulkalam;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreports {

	public static void main(String[] args) {
		ExtentReports er=new ExtentReports("Testresults.html",false);
        ExtentTest et=er.startTest("title test");
        try {
        	System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
        	WebDriver driver=new ChromeDriver();
        	driver.get("http://www.google.com");
        	WebDriverWait wait=new WebDriverWait (driver,100);
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        	driver.manage().window().maximize();
        	//get title
        	String title=driver.getTitle();
        	//boolean logo=driver.findElement(By.xpath("  ")).isDisplayed();
        	//Assert.assertTrue(logo);
        	//System.out.println(logo);
        	Screen s =new Screen();
        	s.click("E:\\sikuliImages\\googleimage.sikuli\\1525186271144.png");
        	//sql zoo.net
        //	if((title.equals("google"))||(logo("logo")))
        	if(title.equals("google"))
        	{
        		et.log(LogStatus.PASS, "title test passed");
        	}
        	else 
        	{
        		et.log(LogStatus.FAIL, "title test failed");
        		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        		File dest=new File("ss.png");
        		FileUtils.copyFile(src, dest);
        		et.log(LogStatus.FAIL, et.addScreenCapture("ss.png"));
        	}
        	 driver.close();       	
        }
       
        catch(Exception e) {
        	et.log(LogStatus.ERROR, e.getMessage());
        }
        //save results
        er.endTest(et);
        er.flush();
	}


}
