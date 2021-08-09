package com.wipro.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeOptions {
	
	
	public static void main(String args[])
	{
	
		 WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			//chromeOptions.addArguments("incognito");
			chromeOptions.addArguments("disable-extensions:");
			//chromeOptions.addArguments("disable-popup-blocking");
			//chromeOptions.addArguments("make-default-browser");
			chromeOptions.addArguments("disable-infobars");
			
		 WebDriver driver = new ChromeDriver(chromeOptions);
		
		 driver.get("https://www.toolsqa.com/selenium-webdriver/webdrivermanager/");
	
	

}
}
