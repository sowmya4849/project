package abdulkalam;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class way2sms {

	public static void main(String[] args) throws Exception {
//get data from keyboard
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter mobile no");
		String m=sc.nextLine();
		System.out.println("Enter mobile no criteria as valid or invalid");
		String mc=sc.nextLine();
		System.out.println("Enter password");
		String p=sc.nextLine();
		System.out.println("Enter Password criteria as valid or invalid");
		String pc=sc.nextLine();
		//create results file(.html)
		ExtentReports er=new ExtentReports("way2smsTestresults.html",false);
        ExtentTest et=er.startTest("way2sms login test");
        WebDriver driver=null;
        try {
        	//run browser driver to get browser
        	System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
        	//create object to access that opened driver
        	driver=new ChromeDriver();
        	//launch site
        	driver.get("http://www.way2sms.com/entry.jsp");
        	WebDriverWait wait =new WebDriverWait(driver,100);
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        	driver.manage().window().maximize();
        	//do login
        	driver.findElement(By.name("username")).sendKeys(m);
        	driver.findElement(By.name("password")).sendKeys(p);
        	driver.findElement(By.id("loginBTN")).click();
        	Thread.sleep(5000);
        	//validations
        	if(m.length()==0&&ExpectedConditions.alertIsPresent()!=null) {
        		et.log(LogStatus.PASS, "Test passed for blank mobile number");
        	}
        	else if (m.length()<10&& ExpectedConditions.alertIsPresent()!=null) {
        		et.log(LogStatus.PASS, "Test passed for wrong size of mobile number");
        	}
        	else if (p.length()==0&& ExpectedConditions.alertIsPresent()!=null) {
        		et.log(LogStatus.PASS, "Test passed for blank password");
        	}
        	else if (mc.equalsIgnoreCase("invalid")	&& driver.findElement(By.xpath("//*[contains(text(),'registered yet')]")).isDisplayed()){
        		//	&& driver.findElement(By.xpath(""))){
        		et.log(LogStatus.PASS, "Test passed for invalid mobile number");
        	}
        	else if (mc.equalsIgnoreCase("valid")&&pc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[contains(text(),'Forgot password')]")).isDisplayed()){
        		et.log(LogStatus.PASS, "Test passed for invalid password");
        	}
        	else if (mc.equalsIgnoreCase("valid")&&pc.equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[text(),'Send SMS')]")).isDisplayed()){
        		et.log(LogStatus.PASS, "Test passed for valid data");
        	}
        	else {
        		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        		File dest=new File("ss1.png");
        		FileUtils.copyFile(src, dest);
        		et.log(LogStatus.FAIL,"Test failed" +et.addScreenCapture("ss1.png"));
        	}
        	//close site
        	driver.close();
        	}
	
        catch(Exception e) {
        	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		File dest=new File("ss2.png");
    		FileUtils.copyFile(src, dest);
    		et.log(LogStatus.ERROR,e.getMessage() +et.addScreenCapture("ss2.png"));
    		driver.close();
        }
        //save results
        er.endTest(et);
        er.flush();
	}

}
