package com.gk.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Finalize {
	
	private WebDriver driver;

	public Finalize(WebDriver driver)
	{
		this.driver=driver;
	}

	By subTotal = By.cssSelector("div[data-test='subtotal-label']");
	By tax = By.cssSelector("div[data-test='tax-label']");
	By total = By.cssSelector("div[data-test='total-label']");;
	By finish = By.id("finish");
	By confirmation = By.cssSelector("*[data-test='complete-header']");
	By backHome = By.id("back-to-products");
	
	public Finalize verifyTotal()
	{
		String tot = driver.findElement(total).getText();
		Assert.assertEquals(total, "32.39", "verified total amount");
		return this;
	}
	
	public Finalize confirmOrder()
	{
		driver.findElement(finish).click();
		String c = driver.findElement(confirmation).getText();
		Assert.assertEquals(c, "Thank you for your order!", "confirmation message");
		return this;
	}
	
	public Products backToHome()
	{
		driver.findElement(backHome).click();
		return new Products(driver);
	}
}
