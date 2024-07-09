package com.gk.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {

	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		this.driver = driver;
	}
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By zipCode = By.id("postal-code");
	By continueBtn = By.id("continue");
	
	public Finalize captureCheckOutDetails() {
		driver.findElement(firstName).sendKeys("test");
		driver.findElement(lastName).sendKeys("sample");
		driver.findElement(zipCode).sendKeys("1234");
		driver.findElement(continueBtn).click();
		return new Finalize(driver);
	}
}
