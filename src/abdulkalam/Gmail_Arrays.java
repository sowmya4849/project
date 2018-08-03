package abdulkalam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

public class Gmail_Arrays {

	public static void main(String[] args) throws Exception {
      //get data from keyboard
		Scanner sc=new Scanner(System.in);
		//create dynamic arrays
		ArrayList<String>uids=new ArrayList<String>();
		ArrayList<String>uidcs=new ArrayList<String>();
		ArrayList<String>pwds=new ArrayList<String>();
		ArrayList<String>pwdcs=new ArrayList<String>();
        //get no of iteations in testing
		System.out.println("Enter no of itertions");
		//converting string to int
		int n=Integer.parseInt(sc.nextLine());
		//get data into arrays
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter userid");
			uids.add(sc.nextLine());
			System.out.println("Enter userid criteria as valid or invalid");
			uidcs.add(sc.nextLine());
			if(uidcs.get(i).equalsIgnoreCase("valid")) {
				System.out.println("Enter password");
				pwds.add(sc.nextLine());
				System.out.println("Enter password criteria as valid or invalid");
				pwdcs.add(sc.nextLine());
			}
			else
			{
				pwds.add("N/A");
				pwdcs.add("N/A");
			}
			}
			//create results file(.html)
			ExtentReports er=new ExtentReports("Gmail test results.html",false);
	        ExtentTest et=er.startTest("Gmail login test");
	        WebDriver driver=null;
	        //data driven test
	        for(int i=0;i<n;i++) 
	        {
	        	try 
	        	{
	        		//launch site
	        		System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
		        	//create object to access that opened driver
		        	 driver=new ChromeDriver();
		        	//launch site
		        	driver.get("http://www.gmail.com");
		        	//to give time to  browser to show page
		        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		        	WebDriverWait w=new WebDriverWait(driver, 100);
		        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		        	driver.manage().window().maximize();
		        	//Enter userid and perform validations
		        	driver.findElement(By.name("identifier")).sendKeys(uids.get(i));
		        	driver.findElement(By.xpath("//*[text()='Next']")).click();
		        	//to give time to browser to activate password
		        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		        	if(uidcs.get(i).equalsIgnoreCase("valid")&&driver.findElement(By.name("password")).isDisplayed()){

		        		et.log(LogStatus.PASS, "valid userid test passed");
		        		//enter password to perform validations
		        		driver.findElement(By.name("password")).sendKeys(pwds.get(i));
		        		//to give time to browser to activate next button
		        		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		        		driver.findElement(By.xpath("//*[text()='Next']")).click();
		        		if(pwdcs.get(i).equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[text()='COMPOSE']")).isDisplayed()){
		        			et.log(LogStatus.PASS, "valid password test passed");
		        		}
		        		//else if(pwdcs.get(i).equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password']!![contains(text(),'Wrong password')]")).isDisplayed()){
			        	//	else if(pc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password'or contains(text(),'Wrong password')]")).isDisplayed()){
			        		else if(pwdcs.get(i).equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password'or contains(text(),'Wrong password')]")).isDisplayed()){

		        			et.log(LogStatus.PASS, "invalid password test passed");
		        		}
		        		else {
		        			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		            		File dest=new File("ss1.png");
		            		FileUtils.copyFile(src, dest);
		            		et.log(LogStatus.FAIL,"Password test failed" +et.addScreenCapture("ss1.png"));
		        		}
		        	}
		        	else if(uidcs.get(i).equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("(//*[contains(text(),'find your Google ')or contains(text(),'Enter an email ')])[2]")).isDisplayed()){

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
		        //save results
		        er.endTest(et);
		        er.flush();
	        	}
	        	
	        }
		

	}


