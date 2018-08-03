package Java_Robot;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSite {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//do login with valid data
		driver.findElement(By.name("identifier")).sendKeys("chsowmya59");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("chinni26@teju");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//click compose
		driver.findElement(By.xpath("//*[text()='COMPOSE']")).click();
		//fill fields
		driver.findElement(By.name("to")).sendKeys("chsowmya62@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("general mail");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("hi\n how r u\n this is about selenium");
		driver.findElement(By.xpath("//*[@aria-label='Attach files']/descendant::*[3]")).click();
		//attach files(java robot)
		String f="C:\\Users\\DELL\\Desktop\\img1.jpg";
		StringSelection y=new StringSelection(f);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
		Robot r=new Robot();
		if(System.getProperty("os.name").contains("Windows"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_META);
			Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
		}
		else
		{
			System.exit(0);
		}
		/*//copy to popupwindow 
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);*/
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebDriverWait w=new WebDriverWait(driver, 100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Attachment:')]/a/div[1]")));
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='dQ']")));
		driver.findElement(By.xpath("//*[contains(@aria-label,'Send')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-live='assertive'])[3]/descendant::*[3]")));
		String z=driver.findElement(By.xpath("(//*[@aria-live='assertive'])[3]/descendant::*[3]")).getText();
		System.out.println(z);
		//do logout
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
    	driver.findElement(By.linkText("Sign out")).click();
    	//close site
    	driver.close();
    	
	}
/**
 * diff in sourcecode for loading of status bar
 * <div id=":se" role="progressbar" aria-label="Uploading selenium-java-2.53.0.zip ..." aria-valuemin="0" aria-valuemax="100" aria-valuenow="63" class="dR" style="width: 63%;"></div>

<div id=":se" class="dQ"><div id=":sd" role="progressbar" aria-label="Uploading selenium-java-2.53.0.zip ..." aria-valuemin="0" aria-valuemax="100" aria-valuenow="55" class="dR" style="width: 55%;"></div></div>
 */
}
