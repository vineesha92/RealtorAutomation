package com.realtor.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebPage {
	
	protected static WebDriver driver;
	public Logger logger =  Logger.getLogger(WebPage.class);
	String projectRootDir=System.getProperty("user.dir");
	
	// Method to open desired browser according to value returned in getBrowser() method.
	protected void openBrowser() throws Exception
	{
		switch (getBrowser().toLowerCase()) {
		case "firefox": 
			System.setProperty("webdriver.gecko.driver",projectRootDir+"\\src\\test\\resources\\geckodriver.exe");
			logger.info("Opening Firefox Browser");
			driver = new FirefoxDriver();
			break;
		
		case "chrome": 
			System.setProperty("webdriver.chrome.driver",projectRootDir+"\\src\\test\\resources\\chromedriver.exe");
			logger.info("Opening Chrome Browser");

			driver = new ChromeDriver();
			break;
			
		case "ie": 
			System.setProperty("webdriver.ie.driver",projectRootDir+"\\src\\test\\resources\\IEDriverServer.exe");
			logger.info("Opening IE Browser");
			driver = new InternetExplorerDriver();
			break;
			
		default:
			throw new Exception("Un-supported browser");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	// Method to get the desired browser chose in environments.properties file
	public String getBrowser()
	{		
		String browser="";
		try {	
			Properties props= new Properties();
			System.out.println("Root Dir "+projectRootDir);
			FileInputStream fis= new FileInputStream(projectRootDir+"//src//main//resources//environment.properties");
			props.load(fis);
			browser=props.getProperty("browser");
		}		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 		
		catch (IOException e) {
			e.printStackTrace();
		}
		return browser;
	}
	
	// Method to close the browser
    public void browserClose(){
    	driver.quit();
    }

}
