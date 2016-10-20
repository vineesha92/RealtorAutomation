package com.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class viewDetailsPage  extends WebPage  {
	
	private String addressOfProperty= "//span[@itemprop='price']";
	
	// Method to get value of the home in view details page 
	public String getPropertyValue(){
		return (driver .findElement(By.xpath(addressOfProperty)).getText());
	}

}
