package com.wipro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import com.wipro.utilities.ReadExcelFile;
import com.wipro.utilities.Read_Cofig_Data;
import com.wipro.utilities.Takes_screenshot;
import com.wipro.utilities.TextFileWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	public Read_Cofig_Data rd = new Read_Cofig_Data();
	public TextFileWriter tw= new TextFileWriter();
	public Takes_screenshot ts= new Takes_screenshot();
	public String imageOutputPath = "C:\\Users\\mohit\\eclipse-workspace\\QET_CoE_SeleniumL2\\src\\Screenshots\\test";
	public ReadExcelFile re= new ReadExcelFile();

	
	@BeforeTest
	
	public void envSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized using chromeoptions");
		  driver = new ChromeDriver(chromeOptions);
		System.out.println(rd.readconfigfile("url"));
		driver.get(rd.readconfigfile("url"));
	}

}
