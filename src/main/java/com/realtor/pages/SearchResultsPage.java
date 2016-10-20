package com.realtor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends WebPage  {

	private String addressOfSecondProperty= "//div[@id='srp-list']//div[@data-page='SRPLIST'][2]//a";
	private String valueOfSecondProperty= "//div[@id='srp-list']//div[@data-page='SRPLIST'][2]//li[@data-label='property-price']";
			
	// Method to get the number of property available in the search results
    public int getNumberOfAvailableHomesInSearchResultsPage(){    	
    	
    	System.out.println("Count message "+driver.findElement(By.id("search-result-count")).getText());
    	String[] numerstring = driver.findElement(By.id("search-result-count")).getText().split(" ");
    	System.out.println("value of s is :"+numerstring[0]);
    	int number = Integer.parseInt(numerstring[0]);
    	return number;   	
    }  
    
    // Method to click on the address of the second search result 
    public void clickSecondResultAddress(){
    	
    	driver.findElement(By.xpath(addressOfSecondProperty)).click();
    }
    
    // Method to get the value of the second property in search results page
    public String getValueOfSecondResult(){
    	
    	return (driver.findElement(By.xpath(valueOfSecondProperty)).getText());    	
    }
    
}
