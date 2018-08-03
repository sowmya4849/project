package Java_Robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class way2sms {

	public static void main(String[] args) throws Exception {
		
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://way2sms.com/content/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//do login
		driver.findElement(By.name("username")).sendKeys("9632924849");
		driver.findElement(By.name("password")).sendKeys("rishit");
		driver.findElement(By.id("loginBTN")).click();
		driver.findElement(By.xpath("//*[text()='Send SMS']")).click();
		//fill fields and click send button
		//switch to frame
		driver.switchTo().frame("frame");
		driver.findElement(By.name("mobile")).sendKeys("9632924849");
		driver.findElement(By.name("message")).sendKeys("hi \n how r u");
		driver.findElement(By.name("Send")).click();
		driver.switchTo().defaultContent();//back to page
		try {
		if(driver.findElement(By.xpath("(//*[text()='Install Chrome Plugin'])")).isDisplayed())
		{
			driver.findElement(By.xpath("(//*[text()='Install Chrome Plugin'])")).click();
		
		Thread.sleep(5000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		}
		}catch(Exception e) {
		   System.out.println(e.getMessage());
	    }
		driver.switchTo().frame("frame");
		String x=driver.findElement(By.xpath("(//*[contains(@class,'ssms')])[6]/following-sibling::*")).getText();
		System.out.println(x);
		driver.switchTo().defaultContent();//back to page
		driver.findElement(By.xpath("//*[@class='out louti']")).click();
		Thread.sleep(5000);
		driver.close();


	}

}
