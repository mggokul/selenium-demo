package com.gk.test;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;
import com.gk.utils.*;

public class BaseSetUp implements ITestListener{

	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");

		this.driver = new ChromeDriver();

	}
	
    @BeforeMethod
    @Parameters ({"url"})
    public void readUrl(String newUrl) {
    	if (this.driver == null) {
	        this.driver =  new ChromeDriver();
	    }
    	driver.manage().window().maximize();
    	driver.navigate().to(newUrl);
    }
    

	 
    @AfterMethod
    public  void closeSession(){
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
    
    

    
    
}
