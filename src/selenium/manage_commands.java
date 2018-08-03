package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class manage_commands {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	    driver.get("http://newtours.demoaut.com");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //get size
      int w=driver.manage().window().getSize().getWidth();
      int h=driver.manage().window().getSize().getHeight();
      System.out.println(w+""+h);
      //set size
      Dimension d=new Dimension(100,200);//width&height
      driver.manage().window().setSize(d);
      //get position
     int x= driver.manage().window().getPosition().getX();
     int y= driver.manage().window().getPosition().getY();
     System.out.println(x+""+y);
     //set position
     Point p=new Point(100,400);//x&y
     driver.manage().window().setPosition(p);
     Thread.sleep(5000);
     //close site
     driver.close();

	}

}
