package Sikulix;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class capture_youtube {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Run browser driver to get browser(Java)                    
				System.setProperty("webdriver.chrome.driver",
						  "E:\\mindq\\chromedriver.exe");
				//Create object to access that opened browser(SWD)
				WebDriver driver=new ChromeDriver();
				//Launch site(SWD)
				driver.get("http://www.youtube.com");
				driver.manage().window().maximize();
				Thread.sleep(10000);
				//Capture screenshsot
				Screen s=new Screen();
				ScreenImage si=s.capture();
				BufferedImage bi=si.getImage();
				File f1=new File("E:\\fullscreen.png");
				ImageIO.write(bi,"png",f1);
				//Capture region of screen(Sikuli)
				Region r=new Region(200,300,200,100); //x,y,width,height
				ScreenImage sr=s.capture(r);
				BufferedImage br=sr.getImage();
				File f2=new File("E:\\region.png");
				ImageIO.write(br,"png",f2);
				//Close site(SWD)
				driver.close();
	}

}
