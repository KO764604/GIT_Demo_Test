package com.wipro.utilities;

import java.io.FileWriter;

public class TextFileWriter {
	
	public void writetextfile(String status)
	{
		try{    
	           FileWriter fw=new FileWriter("C:\\Users\\mohit\\Downloads\\Komal\\testout.txt");    
	           fw.write(status);    
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	          System.out.println("Success...");    
	     }    
		
		
	}


