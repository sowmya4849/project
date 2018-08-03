package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogoChecking {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	WebElement x=	driver.findElement(By.xpath("(//*[@href='/images/branding/product/ico/googleg_lodp.ico'])[1]"));
	System.out.println(x);
	String y=driver.getTitle();
	System.out.println(y);
	Boolean logo=	driver.findElement(By.xpath("(//img)[1]")).isDisplayed();
	Assert.assertTrue(true);
	driver.close();
	/*	List<WebElement> allImages = driver.findElements(By.tagName("img"));
		System.out.println(allImages);
		for(WebElement imageFromList:allImages){
		     String ImageUrl=imageFromList.getAttribute("src");
		     System.out.println(ImageUrl); //will get you all the image urls on the page
		}*/
	}

}
