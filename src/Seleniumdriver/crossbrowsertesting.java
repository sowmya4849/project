package Seleniumdriver;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class crossbrowsertesting {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String x=sc.nextLine();
		WebDriver driver=null;
		if(x.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\mindq\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		else if(x.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\mindq\\geckodriver.exe");
		    driver=new FirefoxDriver();
		}
		else if(x.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "E:\\mindq\\IEDriverServer.exe");
		    driver=new InternetExplorerDriver();
		    
		}else if(x.equals("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files (x86)\\Opera\\53.0.2907.68\\opera.exe");
			System.setProperty("webdriver.opera.driver", "‪E:\\mindq\\operadriver_win64\\operadriver.exe");
		    driver=new OperaDriver();
		}
		else {
			System.out.println("wrong browser");
			System.exit(0);//stop execution forcibly
		}
		driver.get("http://www.google.com");
		
	}

}
