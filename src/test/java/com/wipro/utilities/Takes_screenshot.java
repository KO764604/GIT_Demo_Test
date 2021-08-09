package com.wipro.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Takes_screenshot {
	
	
	public void takeSnapShot(WebDriver driver ,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
	
	
	
	
	
		public  String getDateTimeStamp()
		{
		    // creates a date time stamp that is Windows OS filename compatible
			
		    return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
		    
		}
	

}
