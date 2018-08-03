package abdulkalam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TextFile_Gmail {

	public static void main(String[] args) throws Exception {
		File f=new File("gmailtestdata.txt");
		FileReader fr=new FileReader(f);
		BufferedReader  br=new BufferedReader(fr);
		//create results file(.html)
		ExtentReports er=new ExtentReports("Gmail with notepad.html",false);
        ExtentTest et=er.startTest("Gmail with notepad test");
        //data driven test
        WebDriver driver=null;
        String l="";
        while((l=br.readLine())!=null)//reading line by line
        {
        try {
        	//split line in to pieces
        	String p[]=l.split(",");
        
        	//run browser driver to get browser
        	System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
        	//create object to access that opened driver
        	 driver=new ChromeDriver();
        	//launch site
        	driver.get("http://www.gmail.com");
        	//to give time to  browser to show page
        	WebDriverWait w=new WebDriverWait(driver, 10);
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
        	driver.manage().window().maximize();
        	//Enter userid and perform validations
        	driver.findElement(By.name("identifier")).sendKeys(p[0]);
        	driver.findElement(By.xpath("//*[text()='Next']")).click();
        	//to give time to browser to activate password
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        	if(p[1].equalsIgnoreCase("valid")&&driver.findElement(By.name("password")).isDisplayed()){
        		et.log(LogStatus.PASS, "valid userid test passed");
        		//enter password to perform validations
        		driver.findElement(By.name("password")).sendKeys(p[2]);
        		//to give time to browser to activate next button
        		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
        		driver.findElement(By.xpath("//*[text()='Next']")).click();
        		if(p[3].equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[text()='COMPOSE']")).isDisplayed()){
        			et.log(LogStatus.PASS, "valid password test passed");
        		}
        		else if(p[3].equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password'or contains(text(),'Wrong password')]")).isDisplayed()){

        	//	else if(p[3].equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password']![contains(text(),'Wrong password')]")).isDisplayed()){
	        	//	else if(pc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password'or contains(text(),'Wrong password')]")).isDisplayed()){
        			et.log(LogStatus.PASS, "invalid password test passed");
        		}
        		else {
        			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            		File dest=new File("ss1.png");
            		FileUtils.copyFile(src, dest);
            		et.log(LogStatus.FAIL,"Password test failed" +et.addScreenCapture("ss1.png"));
        		}
        	}
        	else if(p[1].equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("(//*[contains(text(),'find your Google ')or contains(text(),'Enter an email ')])[2]")).isDisplayed()){
        		et.log(LogStatus.PASS, "invalid userid test passed");
        	}
        	else {
        		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        		File dest=new File("ss2.png");
        		FileUtils.copyFile(src, dest);
        		et.log(LogStatus.FAIL,"userid test failed" +et.addScreenCapture("ss2.png"));
        	}
        	//close site
        	driver.close();
        }
        	catch(Exception e) {
        		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        		File dest=new File("ss3.png");
        		FileUtils.copyFile(src, dest);
        		et.log(LogStatus.ERROR,e.getMessage()+et.addScreenCapture("ss3.png"));
        		driver.close();
        	}
        }//close while loop
        fr.close();
        br.close();
        //save results
        er.endTest(et);
        er.flush();
		
	}

}
