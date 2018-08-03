package abdulkalam;

import java.io.File;
import java.io.IOException;
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

public class Gmail_Deletemails_validate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//get data from keyboard
				Scanner sc =new Scanner(System.in);
				System.out.println("Enter valid userid");
				String u=sc.nextLine();
				System.out.println("Enter  valid password");
				String p=sc.nextLine();
				//create results file(.html)
				ExtentReports er=new ExtentReports("Gmail test results.html",false);
		        ExtentTest et=er.startTest("Gmail mail count deletion test");
		        WebDriver driver=null;
		        try {
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
		        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		        	//Enter userid and password to login
		        	driver.findElement(By.name("identifier")).sendKeys(u);
		        	driver.findElement(By.xpath("//*[text()='Next']")).click();
		        	//to give time to browser to activate password
		        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));      		
		        	driver.findElement(By.name("password")).sendKeys(p);
		        	//to give time to browser to activate next button
		        	w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		        	driver.findElement(By.xpath("//*[text()='Next']")).click();
		        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='COMPOSE']")));
		        	//get all mails count before deletion
		        	String x=driver.findElement(By.xpath("(//*[@class='ts'])[3]")).getText();
		        	x=x.replace(",","");
		        		int amcbd=Integer.parseInt(x);
 		        	//pagination to delete mails
		        	int dmc=0;
		        	while(2>1)
		        	{
		        		int mc=driver.findElements(By.xpath("(//*[@role='tabpanel'])[1]/descendant::tbody/tr")).size();
		        		for(int i=1;i<mc;i++) {
		        			//every row 8 th column span tag was taken
		        			String t=driver.findElement(By.xpath("(//*[@role='tabpanel'])[1]/descendant::tbody/tr["+i+"]/td[8]/span")).getAttribute("title");
		        			if(t.contains("May 15")&&t.contains("2018"))
		        			{
		        				//go to same row second column
		        				driver.findElement(By.xpath("(//*[@role='tabpanel'])[1]/descendant::tbody/tr["+i+"]/td[2]/div")).click();
		        				Thread.sleep(1000);
		        				dmc=dmc+1;

		        				driver.findElement(By.xpath("(//*[@class='G-Ni J-J5-Ji'])[2]/div[3]")).click();
		        				Thread.sleep(1000);
		        				dmc=dmc+1;
		        				i=i-1;//to check next mail which is in deleted mail place
		        			}
		        			//get count because sometimes after deletion count decreasing
		        			mc=driver.findElements(By.xpath("(//*[@role='tabpanel'])[1]/descendant::tbody/tr")).size();
		        		}
		        			//go to next page
		        			try {
		            			if(driver.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"))
		            			{
		            				break;//to terminate from loop
		            			}
		        			}
		            		catch(Exception ex) {
		            			driver.findElement(By.xpath("//*[@data-tooltip='Older']")).click();
		            			Thread.sleep(2000);
		            		}
		            }//while loop closing
		        	
		        		//get all mails count after deletion
		        		String temp=driver.findElement(By.xpath("(//*[@class='ts'])[3]")).getText();
		            	int amcad=Integer.parseInt(temp);
		            	System.out.println("Actual mail count"+amcad);

		            	//validation
		            	if(amcbd==amcad+dmc) {
		            		et.log(LogStatus.PASS, "mails count test passed");
		            	}
		            	else {
		            		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		            		File dest=new File("ss1.png");
		            		FileUtils.copyFile(src, dest);
		            		et.log(LogStatus.FAIL,"mail count test failed" +et.addScreenCapture("ss1.png"));
		            	}
		            	//do logout
		            	driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
		            	Thread.sleep(2000);
		            	driver.findElement(By.xpath("//*[@id='gb_71']")).click();
		            	//driver.findElement(By.linkText("Sign out")).click();
		            	//close site
		            	driver.close();
		            }
		            catch(Exception e) {
		            	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        		File dest=new File("ss2.png");
		        		FileUtils.copyFile(src, dest);
		        		et.log(LogStatus.ERROR,e.getMessage() +et.addScreenCapture("ss2.png"));
		        	}
		            //save results
		            er.endTest(et);
		            er.flush();
		        	
	}

}
