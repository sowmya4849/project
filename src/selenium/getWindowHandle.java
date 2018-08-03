package selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
      driver.get("http://www.naukri.com");
      String str=driver.getWindowHandle();
      System.out.println(str);    
      driver.findElement(By.xpath("(//*[contains(text(),'naukri.com')])[6]/following ::img[1]")).click();
      ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
   //   System.out.println(a);
      //switch to 1st browser window
      driver.switchTo().window(a.get(1));
      if(driver.findElement(By.xpath("//*[text()='Home']")).isDisplayed()) {
    	  System.out.println("test passed");
      }
	  driver.close();
	  System.out.println("2nd window");
driver.switchTo().window(str);
    //  driver.switchTo().window(a.get(0));
	  System.out.println("1st window");
	  Thread.sleep(8000);

	  //driver.findElement(By.xpath("//*[text()='Jobs']" )).click();
			  driver.findElement(By.xpath("//*[@class='searchJob']")).sendKeys("selenium");
System.out.println("sendkeys");

Thread.sleep(5000);
driver.close();
	}

}
