package abdulkalam;
	
		import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
		import com.relevantcodes.extentreports.ExtentTest;
		import com.relevantcodes.extentreports.LogStatus;
		
		public class trondelete {
		
			public static void main(String[] args) throws Exception
			{
				//create results file(.html)
				ExtentReports er=new ExtentReports("Gmail tr results.html",false);
		        ExtentTest et=er.startTest("Gmail mail  deletion test");
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
		        	driver.findElement(By.name("identifier")).sendKeys("chsowmya62");
		        	driver.findElement(By.xpath("//*[text()='Next']")).click();
		        	//to give time to browser to activate password
		        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));      		
		        	driver.findElement(By.name("password")).sendKeys("rishitsai");
		        	//to give time to browser to activate next button
		        	w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		        	driver.findElement(By.xpath("//*[text()='Next']")).click();
		        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='COMPOSE']")));
		        	//get all mails count before deletion
		        	String x=driver.findElement(By.xpath("(//*[@class='ts'])[3]")).getText();
		        	x=x.replace(",","");
		        		int amcbd=Integer.parseInt(x);
				//Go to first page of mailbox by clicking inbox link
				driver.findElement(By.xpath(
					"(//*[contains(text(),'Inbox (')])[2]")).click();
				//Thread.sleep(10000);
				//Get actual count of total mails before delete
				String actualbd=driver.findElement(By.xpath(
					 "//*[@aria-label='Newer']/preceding::span[1]"))
					 .getText();
				actualbd=actualbd.replace(",","");
				int atcbd=Integer.parseInt(actualbd);
				System.out.println(atcbd);
				//Goto mails for deletion via pagination
				int dmc=0;
				while(2>1)  //infinite loop
				{
					WebElement mailbox=driver.findElement(By.xpath(
				 "(//*[@role='tabpanel'])[1]/descendant::table/tbody"));
					List<WebElement> rows=mailbox.findElements(
							                          By.tagName("tr"));
					for(int i=0;i<rows.size();i++)
					{
						driver.navigate().refresh();
						mailbox=driver.findElement(By.xpath(
						"(//*[@role='tabpanel'])[1]/descendant::table/tbody"));
						Thread.sleep(10000);
						rows=mailbox.findElements(By.tagName("tr"));
						Thread.sleep(10000);
						List<WebElement> cols=rows.get(i).findElements(
								                             By.tagName("td"));
						String tt=cols.get(7).findElement(By.tagName("span"))
								                       .getAttribute("title");
						if(tt.contains("Jan") && tt.contains("2018"))
						{
							cols.get(1).findElement(By.className("T-Jo-auh"))
							                                          .click();
							Thread.sleep(10000);
							driver.findElement(By.xpath(
						  "(//*[@class='G-Ni J-J5-Ji'])[2]/child::div[3]"))
							  .click();
							Thread.sleep(1000);
							i=i-1; //to check next when it came to current pos
							dmc=dmc+1;
						}
					}
					//Go to next page
					try
					{
						String y=driver.findElement(By.xpath(
							     "//*[@aria-label='Older']"))
							     .getAttribute("aria-disabled");
						if(y.equals("true"))
						{
							break;  //to terminate from infinite loop
						}
					}
					catch(Exception ex)
					{
						driver.findElement(By.xpath(
								"//*[@aria-label='Older']")).click();
						Thread.sleep(10000);
					}
				}
				//Get actual count of total mails after delete
				String actualad=driver.findElement(By.xpath(
						 "//*[@aria-label='Newer']/preceding::span[1]"))
						 .getText();
				actualad=actualad.replace(",","");
				int atcad=Integer.parseInt(actualad);
				System.out.println(atcad);
				//validation
				if(atcbd==atcad+dmc)
				{
					et.log(LogStatus.PASS,"Mails deletion Test passed");
				}
				else
				{
					et.log(LogStatus.FAIL,
							"Mails deletion test failed");
					et.log(LogStatus.FAIL,atcbd+" "+atcad+" "+dmc);
				}
				//Do logout and close site
				driver.findElement(By.xpath(
				 "//*[contains(@title,'Google Account')]/child::span"))
				 .click();
				Thread.sleep(5000);
				driver.findElement(By.linkText("Sign out")).click();
				Thread.sleep(5000);
				driver.close();
		        }
				catch(Exception e) {
	            	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        		File dest=new File("ss2.png");
	        		FileUtils.copyFile(src, dest);
	        		et.log(LogStatus.ERROR,e.getMessage() +et.addScreenCapture("ss2.png"));
	        	}
				//Save results
				er.endTest(et);
				er.flush();
			}
		}


	