package com.wipro.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wipro.base.TestBase;



public class TC01_Registration extends TestBase{
	
	
String xlFilePath = "C:\\Users\\mohit\\Downloads\\Komal\\Test_Data.xlsx";
String sheetName = "Sheet1";


@DataProvider(name ="excel-data")
public Object[][] excelDP() throws IOException{
	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
	Object[][] arrObj = re.getExcelData(xlFilePath,"Sheet2");
	return arrObj;
}



	@Test(dataProvider ="excel-data")
	public void Registration(String firstname ,String lastname,String email,String telephone,String password,String confirmpassword) throws Exception
	{
	 
		driver.findElement(By.xpath(rd.readconfigfile("myaccount"))).click();
		System.out.println("clicked on MyAccount");
		driver.findElement(By.xpath(rd.readconfigfile("register"))).click();
		System.out.println("clicked on Register");
		
		driver.findElement(By.xpath(rd.readconfigfile("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(rd.readconfigfile("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(rd.readconfigfile("email"))).sendKeys(email);
		driver.findElement(By.xpath(rd.readconfigfile("telephone"))).sendKeys(telephone);
		driver.findElement(By.xpath(rd.readconfigfile("password"))).sendKeys(password);
		driver.findElement(By.xpath(rd.readconfigfile("confirmpassword"))).sendKeys(confirmpassword);
		WebElement checkbox = driver.findElement(By.xpath(rd.readconfigfile("checkbox")));
		checkbox.click();
		Boolean status=checkbox.isSelected();
		if(status = true)
		{
			String statusmessage = "checkbox is selected";
			tw.writetextfile(statusmessage);
			
		}
		else
		{
			String statusmessage = "checkbox is not selected";
			tw.writetextfile(statusmessage);	
			
		}
			
		 driver.findElement(By.xpath(rd.readconfigfile("continue"))).click();
		String actualregistrationtext = driver.findElement(By.xpath(rd.readconfigfile("registrationmessage"))).getText();
		System.out.println(actualregistrationtext);
		String expectedregistrationtext = "Your Account Has Been Created!";
	
			
		
		if(actualregistrationtext.equals(expectedregistrationtext))
		{
			
	   //sc.assertEquals("Your Account Has Been Created!", actualregistrationtext, expectedregistrationtext);
		//sc.assertAll();
			System.out.println("Your Account Has Been Created!" +expectedregistrationtext);
			String registrationsuccessmsg =driver.findElement(By.xpath(rd.readconfigfile("registrationsuccessmsg"))).getText();
			tw.writetextfile(registrationsuccessmsg);
			ts.takeSnapShot(driver, imageOutputPath + "404 error " + ts.getDateTimeStamp() + ".png");
		}
		else
			
		
		{   String registererror= driver.findElement(By.xpath(rd.readconfigfile("alreadyregistered"))).getText();
		System.out.println(registererror);	
		tw.writetextfile(registererror);
			System.out.println("Account is already Existing");	
			ts.takeSnapShot(driver, imageOutputPath + "_" + ts.getDateTimeStamp() + ".png");
		}
			
			
		
		
		
		
	}
	
	

	     
	
}	


