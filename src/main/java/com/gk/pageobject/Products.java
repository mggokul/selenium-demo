package com.gk.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.Assert.*;

public class Products {

	private WebDriver driver;

	public Products(WebDriver driver)
	{
		this.driver=driver;
	}

	By cart = By.xpath("//*[@data-test='shopping-cart-link']");
	By cartBackPack = By.id("add-to-cart-sauce-labs-backpack");
	By removeBackPack = By.id("remove-sauce-labs-backpack");
	By carOnesie = By.id("add-to-cart-sauce-labs-onesie");
	By firstItemPrice = By.xpath("(//*[@data-test='inventory-item-price'])[1]");
	By filterDrop = By.xpath("//*[@data-test='product-sort-container']");
	By cartItemCount = By.xpath("//*[@data-test='shopping-cart-link']//span");


	public Products addToCart()
	{
		driver.findElement(cartBackPack).click();
		Assert.assertTrue(driver.findElement(removeBackPack).isDisplayed(),"add to cart button turned to remove");
		String count = driver.findElement(cartItemCount).getText();
		Assert.assertEquals(count,"1","count updated after performing add to cart");

		return this;
	}

	public Products sort()
	{
		Select s = new Select(driver.findElement(filterDrop));
		s.selectByValue("lohi");
		String price = driver.findElement(firstItemPrice).getText();
		Assert.assertEquals(price, "$7.99", "first Item price is the lowest price");

		return this;
	}

	public Cart goToCart() 
	{
		driver.findElement(cart).click();		

		return new Cart(driver);
	}
}
