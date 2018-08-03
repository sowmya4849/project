package Sikulix;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class millionclouds {

	public static void main(String[] args) throws Exception {
		//launch site
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.millionclouds.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Automate nonhtml elements(sikulix)
		Screen s=new Screen();
		s.click("fp.png");
		Thread.sleep(5000);
		s.click("allow.png");
		Thread.sleep(5000);
		s.click("run.png");
		while(2>1) {//infinite loop
			if(s.exists("login.png")!=null) {
				s.click("login.png");
				break;//terminate from loop
			}
		}
		Thread.sleep(5000);
		s.type("uid.png","mindq");
		s.type("pwd.png","sachin");
		s.click("signin.png");
		Thread.sleep(5000);
		Settings.OcrTextSearch=true;
		Settings.OcrTextRead=true;
	/*	int x=s.getX();
		int y=s.getY();
		int w=s.getW();
		int h=s.getH();
		System.out.println(x);
		System.out.println(y);
		System.out.println(w);
		System.out.println(h);*/
		s.click("ok.png");
		Region r=new Region(268,350,256,40);
	//	Region r=new Region(x,y,w,h);
		String x1=r.text();
		System.out.println(x1);
		//close site(sikulix)
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);

	}

}
