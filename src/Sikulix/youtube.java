package Sikulix;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class youtube {

	public static void main(String[] args) throws Exception {
		//launch site
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//search for a video(swd)
		driver.findElement(By.name("search_query")).sendKeys("kalam speeches");
		driver.findElement(By.id("search-icon-legacy")).click();
		//click on a link(swd)
		driver.findElement(By.partialLinkText("Apj Abdul Kalam 7 Rules of Success ")).click();
		Thread.sleep(5000);//wait for advertisement to skip
		//video icons automation(sikilix)
		Screen s=new Screen();
		if(s.exists("skipadd1.png")!=null) {
			s.click("skipadd1.png");			
		}
		//move mouse pointer to video body & automate video icons
		Location l=new Location(200, 300);
		s.wheel(l, Button.LEFT,0);
		s.click("pause.png");
		Thread.sleep(5000);
		s.wheel(l, Button.LEFT,0);
		s.click("play.png");
		Thread.sleep(5000);
		s.wheel(l, Button.LEFT,0);
		s.mouseMove("volume.png");
		Thread.sleep(5000);
		Match e=s.find("bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location dl1=new Location(x-20,y);
		s.dragDrop(e,dl1);
		Thread.sleep(5000);
		Location dl2=new Location(x+20,y);
		s.dragDrop(e,dl2);
		Thread.sleep(5000);
		s.wheel(Button.WHEEL_DOWN, 5);
		Thread.sleep(5000);
		s.wheel(Button.WHEEL_UP, 5);

		Thread.sleep(5000);

		//close  site(swd)
		driver.close();
		

		
		
	}

}
