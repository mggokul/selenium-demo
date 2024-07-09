package com.gk.pageobject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {

	private WebDriver driver;
	
	By loginName = By.id("user-name");
	By password = By.id("password");
	By login = By.id("login-button");
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Products login(String user, String pass)
	{
		driver.findElement(loginName).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
		return new Products(driver);
	}
}
