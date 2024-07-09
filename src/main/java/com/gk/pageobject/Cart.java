package com.gk.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

	WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
	}

	By checkout = By.id("checkout");
	By remove = By.id("remove-sauce-labs-backpack");
	
	public CheckOut proceedToCheckOut()
	{
		driver.findElement(checkout).click();
		return new CheckOut(driver);
	}
	
	public CheckOut remove()
	{
		driver.findElement(remove).click();
		return new CheckOut(driver);
	}
	
}
