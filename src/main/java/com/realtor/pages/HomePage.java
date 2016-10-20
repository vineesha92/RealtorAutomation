package com.realtor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage 
{    
	//TODO - If I18N requirement is there for the app, element locator should be moved to external files like properties or XML
	
	private String searchButton="//div[@class='home-search-wrapper']//button";
	
	// Method to launch the URL of the application
	public void urlLaunch(String url){
		try {
			openBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.get(url);
	}	
	
	//Search functionality using Keyboard Enter Key
    public void searchEnter(String searchKey) {
    	
		WebElement searchField = driver.findElement(By.id(("searchBox")));
		searchField.clear();
		searchField.sendKeys(searchKey);
		
		driver.findElement(By.xpath(searchButton)).sendKeys(Keys.ENTER);
		
		System.out.println("Search Button Clicked");
    }
	
}
