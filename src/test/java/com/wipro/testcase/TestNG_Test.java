package com.wipro.testcase;

import org.testng.annotations.Test;

public class TestNG_Test {

	@Test(priority =5)
	
	public void m1()
	{
		System.out.println("m1 methode");
		
	}
	
	
@Test()
	
	public void m2()
	{
	System.out.println("m2 methode");
		
	}

@Test(priority=5)

public void m3()
{
	System.out.println("m3 methode");
	
}
}
