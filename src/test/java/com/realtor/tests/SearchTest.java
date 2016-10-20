package com.realtor.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SearchTest extends BaseTest {
	
	@Test
	 public void testPropertyValueOnSearchResultsAndPropertyDetailsPage() throws Exception{
		homepage.searchEnter("Morgantown, WV");
		System.out.println("after testSearchKeyEnter method");
				
		int number = searchresultspage.getNumberOfAvailableHomesInSearchResultsPage();
		System.out.println("after text on search results");
		
		assertTrue(number>0);
		
		System.out.println("The value of [N] is : "+ number +" which is greater than 0");
		String propValueInResultsPage=searchresultspage.getValueOfSecondResult();
		System.out.println("The value of the home in search results is : "+propValueInResultsPage );

		searchresultspage.clickSecondResultAddress();
		String propertyValueInDetailsPage = propertydetailspage.getPropertyValue();
		System.out.println("The value of the home in property details details page is : "+propertyValueInDetailsPage);
		
		assertEquals(propValueInResultsPage, propertyValueInDetailsPage);
		System.out.println("The property value on both pages is equal");
		
	 }
	
}
