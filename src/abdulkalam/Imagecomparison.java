package abdulkalam;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Imagecomparison {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
    	driver.get("http://www.spicejet.com");
    	driver.manage().window().maximize();
    	WebElement ele=driver.findElement(By.name("ctl00$mainContent$btn_FindFlights"));
    	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		// Get the location of element on the page
	      Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		File screenshotLocation = new File("C:\\images\\screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
    	
		 File fileOutPut  = new File("C:\\images\\screenshot.png"); 
		 File fileInput = new File("E:\\sikuliImages.sikuli\\1525411035567.png");   
        
       try { 
        BufferedImage bufferfileInput = ImageIO.read(fileInput);
        DataBuffer dataInput1 = bufferfileInput.getData().getDataBuffer();
        int sizefileInput = dataInput1.getSize();     
        BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
        DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
        int sizefileOutPut = datafileOutPut.getSize();
        
        Boolean matchFlag = true;
        if(sizefileInput == sizefileOutPut) {                         
           for(int i=0; i<sizefileInput; i++) {
                 if(dataInput1.getElem(i) != datafileOutPut.getElem(i)) {
                       matchFlag = false;
                       break;
                 }
          	   driver.close();

            }
        }
        else {                           
           matchFlag = false;
           Assert.assertTrue(matchFlag, "Images are not same");    
	    }
     }
       catch (Exception e) {
    	   e.getMessage();
    	   driver.close();
       }
	}
}
