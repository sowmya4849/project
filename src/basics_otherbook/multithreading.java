package basics_otherbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multithreading extends Thread{
	public void run()
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		driver.close();
	}
	public static void main(String[] args) throws Throwable   
	{
		multithreading obj=new multithreading();
		obj.start();
		//Open browser
		System.setProperty("webdriver.chrome.driver",
				     "E:\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(2000);
		driver.findElement(By.name("q"))
						.sendKeys("kalam",Keys.ENTER);
		Thread.sleep(2000);
		driver.close();
	}
}
