package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC01 extends BaseClass {
	@Test
	public void loginTest() throws Exception
	{
	 logger.info("URL is opened");
	 
	 LoginPage login=new LoginPage(driver);
	 login.Setusername(username);
	 logger.info("Username is entered");
	 login.Setpassword(password);
	 logger.info("Password is entered");
	 login.Submit();
	 logger.info("Click on log in Tab");
	 
	 if(driver.getTitle().equals("Guru99 Bank Manager HomePage12345"))
	 {
		 Assert.assertTrue(true);
		 logger.info("Login test case is Passed");
	 }
	 else
	 {
		 captureScreen(driver, "loginTest");
		 Assert.assertTrue(false);
		 logger.info("Login test case failed");
	 }
}
}
