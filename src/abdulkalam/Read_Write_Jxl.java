package abdulkalam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.Number;
public class Read_Write_Jxl {

	public static void main(String[] args) throws Exception {
		//Open Excel file for reading
				File f=new File("label.xls");
				Workbook rwb=Workbook.getWorkbook(f);
				Sheet rsh=rwb.getSheet(0); //0 means sheet1
				int nour=rsh.getRows();
				int nouc=rsh.getColumns();
				//Open same excel file for writing
				WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
				WritableSheet wsh=wwb.getSheet(0); //0 means sheet1
				//Take current date & time as results col heading
				Date d=new Date();
				SimpleDateFormat df=new SimpleDateFormat(
						                      "dd-MM-yy-hh-mm-ss");
				Label l=new Label(nouc,0,df.format(d));
				wsh.addCell(l);
				//Data driven
				//0th row(first row) have names of columns
				for(int i=1;i<nour;i++)
				{
					String uid=rsh.getCell(0,i).getContents();
					String uc=rsh.getCell(1,i).getContents();
					String pwd=rsh.getCell(2,i).getContents();
					String pc=rsh.getCell(3,i).getContents();
					//Launch site                 
					System.setProperty("webdriver.chrome.driver",
									 "E:\\mindq\\chromedriver.exe");
					WebDriver driver=new ChromeDriver();
					driver.get(
						"http://site21.way2sms.com/content/index.html");
					driver.manage().window().maximize();
					Thread.sleep(5000);
					//Do login
					driver.findElement(By.name("username"))
					                           .sendKeys(uid);
					driver.findElement(By.name("password"))
					                            .sendKeys(pwd);
					driver.findElement(By.id("loginBTN")).click();
					Thread.sleep(5000);
					//Validations
					try
					{
						if(uid.length()==0 && 
						  ExpectedConditions.alertIsPresent()!=null)
						{
							
							Label r=new Label(nouc,i,"Test passed for blank mobile number");
							wsh.addCell(r);
						 }
						 else if(uid.length()<10 && 
						   ExpectedConditions.alertIsPresent()!=null)
						 {
							Label r=new Label(nouc,i,"Test passed for wrong size of mobile number");
							wsh.addCell(r);
						 }
						 else if(pwd.length()==0 && 
						   ExpectedConditions.alertIsPresent()!=null)
						 {
							 Label r=new Label(nouc,i,"Test passed for blank password");
							 wsh.addCell(r);
						 }
						 else if(uc.equalsIgnoreCase("invalid") &&
							driver.findElement(By.xpath(
							"//*[contains(text(),'registered yet')]"))
							.isDisplayed())
						 {
							 Label r=new Label(nouc,i,"Test passed for invalid mobile number");
							 wsh.addCell(r);
						 }
						 else if(uc.equalsIgnoreCase("valid") && 
								pc.equalsIgnoreCase("invalid")
								&& driver.findElement(By.xpath(
								"//*[contains(text(),'Forgot Password')]"))
								.isDisplayed())
						 {
							 Label r=new Label(nouc,i,"Test passed for invalid password");
								wsh.addCell(r);
						}
						else if(uc.equalsIgnoreCase("valid") && 
								pc.equalsIgnoreCase("valid") &&
								driver.findElement(By.xpath(
								"//*[text()='Send SMS']")).isDisplayed())
						{
							Label r=new Label(nouc,i,"Test passed for valid data");
							wsh.addCell(r);
						}
						else
						{
							File src=((TakesScreenshot)driver).getScreenshotAs(
				                    						  OutputType.FILE);
							File dest=new File("ss.png");
							FileUtils.copyFile(src,dest);
							Label r=new Label(nouc,i,"Test failed, so see ss.png");
							wsh.addCell(r);
						}
					}
					catch(Exception ex)
					{
						Label r=new Label(nouc,i,"Exception was raised");
						wsh.addCell(r);
					}
					//Close site
					driver.close();
				}
				//Save and close excel
				wwb.write(); //save
				wwb.close();
				rwb.close();
	}

}
