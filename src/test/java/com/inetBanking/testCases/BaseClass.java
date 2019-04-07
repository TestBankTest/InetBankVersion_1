package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
ReadConfig readconfig=new ReadConfig();	
public String baseurl=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();

	
public static WebDriver driver;
public static Logger logger;

@Parameters("browsername")
@BeforeClass
public void setup(String br)
{
	logger=Logger.getLogger("eBanking");
    PropertyConfigurator.configure("log4j.properties");
    
    if(br.equals("Chrome"))
    {
	System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
	driver=new ChromeDriver();
    }
    else if(br.equals("Firefox"))
    {
    System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
    driver=new FirefoxDriver();
    }
    driver.get(baseurl);
}
@AfterClass
public void teardown()
{
	driver.quit();
}

public void captureScreen(WebDriver driver,String tname) throws Exception
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshot/" +tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot has taken");	
}
















}
