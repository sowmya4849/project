package Sikulix;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Capture_google {

	public static void main(String[] args) throws Exception {
		//launch site
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gogle.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//capture full screen's image screenshot(sikilix)
		File f1=new File("E://fullscreen.png");
		Screen s=new Screen();
		ScreenImage si1=s.capture();
		BufferedImage bi1=si1.getImage();
		ImageIO.write(bi1, "png", f1);
		//capture part of the screen as screenshot
		File f2=new File("E://partofscreen.png");
		Region r=new Region(100,100,700,400);//x,y.width&height coordinates 
		ScreenImage si2=s.capture(r);
		BufferedImage bi2=si2.getImage();
		ImageIO.write(bi2, "png", f2);
		//close site
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);
		
	}

}
