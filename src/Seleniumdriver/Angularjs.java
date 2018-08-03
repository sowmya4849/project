package Seleniumdriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Angularjs {

	public static void main(String[] args) {
		//get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "E://mindq//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://angularjs.org");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@href='https://angular.io'])[1]")));
	    driver.manage().window().maximize();
	    //fill angular js
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@ng-model='yourName']")).sendKeys(x);
	    String y=driver.findElement(By.xpath("//*[@ng-model='yourName']/following-sibling::h1")).getText();
	    if(y.contains(x)) {
	    	System.out.println("Test passed");
	    }else {
	    	System.out.println("Test failed");

	    }
	    //close site
	    driver.close();
	    
	}

}
