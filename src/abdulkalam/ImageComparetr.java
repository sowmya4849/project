package abdulkalam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparetr {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
    	driver.get("http://www.spicejet.com");
    	driver.manage().window().maximize();
    //	String str=driver.getPageSource();
    //	System.out.println(str);
    	WebElement ele=driver.findElement(By.name("ctl00$mainContent$btn_FindFlights"));
    	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		// Get the location of element on the page
		org.openqa.selenium.Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		File screenshotLocation = new File("C:\\images\\screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
    	
    	BufferedImage actualimage = ImageIO.read(new File("C:\\images\\screenshot.png")); 
        BufferedImage expectedimage = ImageIO.read(new File("E:\\sikuliImages.sikuli\\1525411035567.png"));   
    
        //   Screenshot logo=new AShot().takeScreenshot(driver,ele);
     //   BufferedImage actualimage=logo.getImage();
        ImageDiffer  imgdiff=new ImageDiffer();
        
        ImageDiff diff=imgdiff.makeDiff(expectedimage, actualimage);
        Assert.assertTrue("Images are   same",diff.hasDiff());
   //     Assert.assertEquals(expectedimage, actualimage);
        
        driver.close();
      /*  List<WebElement> images = driver.findElements(By.name("ctl00$mainContent$btn_FindFlights"));
        List<String> errors = new LinkedList<>();
        int imgWidth, imgHeight, elWidth, elHeight;
        int imgNum = 0;

		imgWidth = images.get(0).getSize().getWidth();
        imgHeight = images.get(0).getSize().getHeight();


        for (WebElement el : images) {
            imgNum++;

            elWidth = el.getSize().getWidth();
            elHeight = el.getSize().getHeight();

            if (imgWidth != elWidth || imgHeight != elHeight) {
                errors.add(String.format("Picture # %d has incorrect size (%d : %d) px"
                        , imgNum, elWidth, elHeight));
            }
        }

        for (String str : errors)
            System.out.println(str);

        if (errors.size() == 0)
            System.out.println("All images have the same size");*/
  /*       boolean bufferedImagesEqual(BufferedImage imgA1 ,BufferedImage imgB1) {
        	 if (imgA1.getWidth() == imgB1.getWidth() && imgA1.getHeight() == imgB1.getHeight()) {
                 for (int x = 0; x < imgA1.getWidth(); x++) {
                	 for (int y = 0; y < imgB1.getHeight(); y++) {
                    	 if (imgA1.getRGB(x, y) != imgB1.getRGB(x, y))
                        return false;
                        }
                      }
        	 } else {
                 return false;
              }
              return true;
             }*/
	}

}
