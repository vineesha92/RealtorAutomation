package com.realtor.tests;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.realtor.pages.HomePage;
import com.realtor.pages.viewDetailsPage;
import com.realtor.pages.SearchResultsPage;
import com.realtor.pages.WebPage;

public class BaseTest {
	
	public static WebPage webpage = new WebPage();
	public static HomePage homepage = new HomePage();
	public static SearchResultsPage searchresultspage = new SearchResultsPage();
	public static viewDetailsPage propertydetailspage = new viewDetailsPage();

	protected Logger logger =  homepage.logger;	

	@BeforeTest
	public void urlLaunch() throws Exception{	
		logger.info("*************** Begining of Test case *************** \n");
		homepage.urlLaunch("https://www.realtor.com");		
	}		
	
	@AfterTest
	public void closeBrowser(){
		webpage.browserClose();
		logger.info("*************** End of Test case \n");
	}
}