package selenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class HtmlDragandDrop {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
	    Thread.sleep(5000);
	    Screen s=new Screen();
	    Match e1=s.find("C:\\Users\\DELL\\Documents\\JavaEclipse\\MindQ\\drag.png");
	    Match e2=s.find("C:\\Users\\DELL\\Documents\\JavaEclipse\\MindQ\\drop.png");
	    s.dragDrop(e1,e2);
	    //s.dragDrop("drag.png","drop.png");
	    Thread.sleep(5000);
		driver.close();	 	    
	}

}
