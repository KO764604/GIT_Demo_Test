package com.wipro.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_Cofig_Data {
	

	
	public String readconfigfile(String key)
	{
	 String value = null;
	File file = new File("C:\\Users\\mohit\\eclipse-workspace\\QET_CoE_SeleniumL2\\src\\resources\\config\\config.properties");
	  
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop = new Properties();
	
	
	//load properties file
	try {
		prop.load(fileInput);
		 value = prop.getProperty(key);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return value;

}
}
