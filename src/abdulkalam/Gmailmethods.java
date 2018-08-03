package abdulkalam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Gmailmethods {
	public WebDriver driver=null;
	public String launch(String l, String d,String c) throws Exception {
		 if(l.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
			 driver=new ChromeDriver();
		 }
		 else if(l.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", "E:\\mindq\\geckodriver.exe");
		   	 driver=new FirefoxDriver();	   	 
	     }
		 else if(l.equalsIgnoreCase("opera")) {
			 OperaOptions o=new OperaOptions();
			 o.setBinary("C:\\Program Files (x86)\\Opera\\53.0.2907.68\\opera.exe");
			 System.setProperty("webdriver.opera.driver", "E:\\mindq\\operadriver_win64\\operadriver.exe");
		   	 driver=new OperaDriver(o);	   	 
	     }
		 else {
			 System.setProperty("webdriver.ie.driver", "E:\\mindq\\iedriverserver.exe");
		   	 driver=new InternetExplorerDriver();	   	 
		 }
		 driver.get(d);
		 Thread.sleep(5000);
	     return "Done";
	}
	public String fill(String l, String d,String c) throws Exception {
		driver.findElement(By.xpath(l)).sendKeys(d);
		Thread.sleep(5000);
	     return "Done";
	}
	public String validateuserid(String l, String d,String c) throws Exception {
		try
		{	
			if(c.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
			{
				return ("Blank userid test passed");
			}
			else if(c.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("(//*[contains(text(),'find your Google')])[2]")).isDisplayed())
			{
				return ("invalid userid test passed");
			}
			else if(c.equalsIgnoreCase("valid")&&driver.findElement(By.name("password")).isDisplayed()) {
				return ("valid userid test passed");
			}
			else {
				String x=this.screenshot();
				return("userid test failed and screenshot is"+x);
			}
		}
		catch(Exception e)
		{
			String x=this.screenshot();
			return("userid test was interrupted and screenshot is"+x);
		}
	}
	public String close(String l, String d,String c) throws Exception {
		driver.close();
		Thread.sleep(5000);
	    return "Done";
	}
	public String validatepwd(String l, String d,String c) throws Exception {
		try
		{	
			if(c.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("(//*[contains(text(),'Enter a password')])[2]")).isDisplayed())
			{
				return ("Blank password test passed");
			}
			else if(c.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
			{
				return ("invalid password test passed");
			}
			else if(c.equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[text()='COMPOSE']")).isDisplayed()) {
				return ("valid password test passed");
			}
			else {
				String x=this.screenshot();
				return("pwd test failed and screenshot is"+x);
			}
		}
		catch(Exception e)
		{
			String x=this.screenshot();
			return("pwd test was interrupted and screenshot is"+x);
		}
	}
	public String click(String l, String d,String c)throws Exception{

		driver.findElement(By.xpath(l)).click();
		Thread.sleep(5000);
		return("Done");
	}
	public String screenshot()throws Exception {
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String fname=df.format(d);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(fname+".png");
        FileUtils.copyFile(src, dest);
        return (fname);
  }
}
