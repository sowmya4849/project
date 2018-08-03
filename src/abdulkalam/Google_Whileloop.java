package abdulkalam;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Google_Whileloop {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//launch site
		System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.get("http://www.google.com");
    	//create results file(.html)
		ExtentReports er=new ExtentReports("Google test results.html",false);
        ExtentTest et=er.startTest("Google  test");
    	WebDriverWait wait=new WebDriverWait (driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
 //  	Thread.sleep(5000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Images")));
    	//results pages are ready to navigate (pagination)
    	//moving one page to another page till last page
    	int flag=0;
    	while(2>1)//infinite loop
    	{
    		String t=driver.getTitle();
    		if(!t.contains(x)) {
    			flag=1;
    			break;//terminate from infinite loop
    		}
    		//go to next page of results
    		try {
    			if(driver.findElement(By.xpath("//*[text()='Next']")).isDisplayed()){
    				driver.findElement(By.xpath("//*[text()='Next']")).click();
    				//Thread.sleep(5000);
    			}
    		}
    		catch(Exception e) {
    			break;//terminate from infinite loop
    		}
    	}
    //validation
    	if(flag==0) {
    		et.log(LogStatus.PASS, "Test passed");
    	}
    	else {
    		et.log(LogStatus.FAIL, "Test failed");
    	}
    	//close site
    	driver.close();
    	//save results
    	er.endTest(et);
    	er.flush();
	}

}
