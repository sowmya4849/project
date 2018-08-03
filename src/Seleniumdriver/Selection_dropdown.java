package Seleniumdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selection_dropdown {

	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://semantic-ui.com/modules/dropdown.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //Automate multi-select drop-down
	  		WebElement e=driver.findElement(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]"));
            e.click();
           List<WebElement> skill=e.findElements(By.xpath("//*[@class='menu transition visible']/div"));
            
         //   Select s=new Select(e);
            Actions a=new Actions(driver);
            //select items
            for(int i=0;i<skill.size();i++) {
          System.out.println(skill.get(i).getText());
          skill.get(3).click();
          skill.get(5).click();
          break;


            }
            //deselect icon 1st selcted icon
            driver.findElement(By.xpath("(//*[@class='delete icon'])[1]")).click();
            //close site
            driver.close();
	}

}
