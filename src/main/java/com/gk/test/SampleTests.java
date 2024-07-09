package com.gk.test;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gk.pageobject.Login;
import com.gk.pageobject.Products;
import com.gk.utils.*;

public class SampleTests extends BaseSetUp {

	Products p;
	Utilities uz;
	HashMap<String, String> hs;
	
	public Products newLogin(String user, String pass) {

		Login l = new Login(driver);
		l.login(user, pass);
		return new Products(this.driver);
	}
	
	@BeforeMethod
	public void testProperty(){
	uz= new Utilities("config");
	hs = uz.getPropertyAsHashMap();
	}
	
    @AfterMethod
    public void screenShot(ITestResult result)
    {
    	if(ITestResult.FAILURE==result.getStatus()){
    		try{
    				TakesScreenshot screenshot=(TakesScreenshot)driver;
    				File src=screenshot.getScreenshotAs(OutputType.FILE);
    				FileUtils.copyFile(src, new File("Screenshots\\"+result.getName()+".png"));
    			}
    		catch (Exception e){
    			System.out.println("Exception while taking screenshot "+e.getMessage());
    			} 
    		}
    	}
	
  @Test(enabled=true)
  public void addCart() {
	  p = newLogin(hs.get("username"), hs.get("password"));
	  p.addToCart();
      Set<Cookie> cookies = driver.manage().getCookies();
      Assert.assertTrue(cookies.toString().contains("session-username=standard_user"));
  }
  
  @Test(enabled=true)
  public void sort() {
	  p = newLogin(hs.get("username"), hs.get("password"));
	  p.sort();
  }
  
  @Test(enabled=true)
  public void checkTotal() {
	  p = newLogin(hs.get("username"), hs.get("password"));
	  p.addToCart().goToCart().proceedToCheckOut().captureCheckOutDetails().verifyTotal();
  }
  
  @Test(enabled=true)
  public void placeOrder() {
	  p = newLogin(hs.get("username"), hs.get("password"));
	  p.addToCart().goToCart().proceedToCheckOut().captureCheckOutDetails().confirmOrder();
  }
  
  @Test(enabled=true)
  public void backHomeFunc() {
	  p = newLogin(hs.get("username"), hs.get("password"));
	  p.addToCart().goToCart().proceedToCheckOut().captureCheckOutDetails().confirmOrder().backToHome();
  }
}
