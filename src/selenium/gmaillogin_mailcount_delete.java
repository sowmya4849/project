package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmaillogin_mailcount_delete {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	    driver.get("http://www.gmail.com");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     //do login
     driver.findElement(By.name("identifier")).sendKeys("abcmtestemail@gmail.com");
     driver.findElement(By.xpath("//*[text()='Next']")).click();
     Thread.sleep(5000);
     driver.findElement(By.name("password")).sendKeys("testadmin");
     driver.findElement(By.xpath("//*[text()='Next']")).click();
     Thread.sleep(5000);
     //get count of mails in mailbox table
     int c=driver.findElements(By.xpath("//*[@role='tabpanel']/descendant::table/tbody/tr")).size();
     System.out.println(c);
     //select 6th mail
     driver.findElement(By.xpath("//*[@role='tabpanel']/descendant::table/tbody/tr[6]/td[2]")).click();
     Thread.sleep(5000);
     //delete mail
     driver.findElement(By.xpath("//*[contains(@style,'margin-right')]/descendant::div[11]/div[3]")).click();
     Thread.sleep(5000);
     //do logout
     driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
     Thread.sleep(2000);
     driver.findElement(By.linkText("Sign out")).click();
     //close site
     driver.close();
     
	}

}
