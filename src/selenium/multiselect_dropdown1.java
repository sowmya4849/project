package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class multiselect_dropdown1 {

	public static void main(String[] args) throws Exception {
		  System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	      driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          driver.switchTo().frame("iframeResult");
          
          WebElement e=driver.findElement(By.name("cars"));
          Select s=new Select(e);
        List<WebElement>l=  s.getOptions();
        List<WebElement>l1=  s.getAllSelectedOptions();
       /* System.out.println(s.getFirstSelectedOption());
        Thread.sleep(5000);
        for(int i=0;i<l.size();i++) {
        	System.out.println(l.get(i).getText());
        }*/
        for(int i=0;i<l1.size();i++) {
        	System.out.println(l1.get(i).getText());
        }
         Actions a=new Actions(driver);
         a.keyDown(Keys.CONTROL).build().perform();
         a.click(s.getOptions().get(3)).build().perform();
         a.click(s.getOptions().get(0)).build().perform();
         a.keyUp(Keys.CONTROL).build().perform();
         Thread.sleep(5000);
         
        

         s.deselectAll();

         driver.close();

	      
	}

}
