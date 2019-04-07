package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.NAME, using="uid")
	@CacheLookup
	WebElement username;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.NAME, using="btnLogin")
	@CacheLookup
	WebElement logintab;
	
	
	public void Setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void Setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void Submit()
	{
		logintab.click();
	}
}
