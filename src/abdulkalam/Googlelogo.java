package abdulkalam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlelogo {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		String s = driver.findElement(By.id("hplogo")).getAttribute("src");
		URL url = new URL(s);
		System.out.println(url);
		BufferedImage bufImgOne = ImageIO.read(url);
		ImageIO.write(bufImgOne, "png", new File("test.png"));
	}

}
