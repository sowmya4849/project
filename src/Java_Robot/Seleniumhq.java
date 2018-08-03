package Java_Robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Seleniumhq {
	
	public static void main(String[] args) throws Exception {
		//launch site
				System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://www.seleniumhq.org");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement link=driver.findElement(By.linkText("Download"));
				Actions a =new Actions(driver);
				a.contextClick(link).build().perform();
				Robot r =new Robot();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(5000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				driver.close();

				
	}
}
