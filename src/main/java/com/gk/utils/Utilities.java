package com.gk.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;


public class Utilities{

	private String propertyName = null;
	private Properties props;

	//This is constructor to pass property file name during object creation.

	public Utilities (String propertyName){
	this.propertyName = propertyName;
	}
	
	 
	private void loadProperty() {
	try {
	props = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator+ "src"+ File.separator+ "main"+ File.separator + "resources"+ File.separator + propertyName + ".properties");
	props.load(fis);
	} 
	catch (Exception e){
	e.printStackTrace();
	}
	}

	public HashMap<String, String> getPropertyAsHashMap(){
	loadProperty();
	HashMap<String, String> map = new HashMap<String, String>();

	for (Entry<Object, Object> entry : props.entrySet()){
	map.put((String) entry.getKey(), (String) entry.getValue());
	}
	return map;
	}
	
	
	
}
