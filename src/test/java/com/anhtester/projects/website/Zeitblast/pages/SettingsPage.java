package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class SettingsPage {

	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void verifytitle() {
//		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.MARKET_PAGE_TITLE));
//		Settings | Zeit Blast
		Assert.assertEquals(WebUI.getPageTitle(), FrameworkConstants.MARKET_PAGE_TITLE);
	}
	public void clickSettings()  {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SETTING_PAGE));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
		
		
	}
	public void notexistsettings() {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
	
		 boolean isSettingsVisible = isElementPresent(By.xpath(FrameworkConstants.SETTING_PAGE));
	        Assert.assertFalse(isSettingsVisible, "Settings page should not be visible for agent.");
	}
	private boolean isElementPresent(By locator) {
		 try {  
			 return  WebUI.getWebElement(locator).isDisplayed();       
	        } catch (NoSuchElementException e) {
	            return false;
	        }
		 }
	public void Verifymessagecounttoday() {
		String total=WebUI.getTextElement(By.xpath(FrameworkConstants.TODAY_MESSAGE_COUNT));
		System.out.println(total);
		String total1=WebUI.getTextElement(By.xpath(FrameworkConstants.TODAY_MESSAGE_COUNT1));
		System.out.println(total1);
		Assert.assertEquals(total, total1);
	}
	
	
	public void createmarket(String name, String code, String no) throws InterruptedException {

	
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_NEW_MARKET_BUTTON));

		WebUI.setText(By.xpath(FrameworkConstants.INPUT_MARKET_NAME), name);	
		int attempts = 0;
		while (attempts < 3) {
		    wait.until(ExpectedConditions.elementToBeClickable(WebUI.getWebElement(By.xpath(FrameworkConstants.ENTER_AREACODE_BOX))));
		    WebUI.getWebElement(By.xpath(FrameworkConstants.ENTER_AREACODE_BOX)).clear();
		  try {
		    WebUI.clickElement(By.xpath(FrameworkConstants.ENTER_AREACODE_BOX));
		  }
		  catch(ElementClickInterceptedException e) {
			  WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ENTER_AREACODE_BOX));  
		  }
		  for(int i=0;i<code.length();i++) {
		  String myString = String.valueOf(code.charAt(i));
//		  WebUI.setText(By.xpath("(//input)[3]"), code, Keys.DOWN);
	    WebUI.setText(By.xpath(FrameworkConstants.ENTER_AREACODE_BOX), myString);
		  }
//		    WebUI.sendKeys(By.xpath("(//input)[3]"), Keys.DOWN);
		    WebUI.sendKeys(By.xpath(FrameworkConstants.ENTER_AREACODE_BOX), Keys.ENTER);
		    Thread.sleep(1500);
		  
		   
		    if (WebUI.getTextElement(By.xpath(FrameworkConstants.ENTER_AREACODE)).equals(code)) {
		       
		        break;
		    }
		    attempts++;
		}
		
		System.out.println(WebUI.getTextElement(By.xpath(FrameworkConstants.ENTER_AREACODE)));
//		WebUI.setText(By.xpath("(//input[@type='text'])[4]"), FrameworkConstants.FORWARDDING_NUMBER);
		WebUI.setText(By.xpath(FrameworkConstants.INPUT_OUTBOUND_NUMBER), no);
try {
		wait.until(ExpectedConditions.elementToBeClickable(WebUI.getWebElement(By.xpath(FrameworkConstants.SUBMIT_BUTTON))))
				.click();
}
catch (TimeoutException e) {
   
    System.out.println("Element is not clickable without the Forwording number.");
}
catch (ElementClickInterceptedException e) {
	   
    System.out.println("Element is not clickable without the Forwording number.");
}

	}
	public void createMarketValidation() throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.MARKET_CREATED_SUCCESS_MESSAGE), "New market have been created successfully!"));
		
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.MARKET_CREATED_SUCCESS_MESSAGE)), "New market have been created successfully!");
//		Thread.sleep(2000);
	}

	public void addtomarket() {
		 try {
			    WebUI.clickElement(By.xpath(FrameworkConstants.ADD_OUTBOUND_NUMBER_BUTTON));
			  }
			  catch(ElementClickInterceptedException e) {
				  WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ADD_OUTBOUND_NUMBER_BUTTON));  
			  }
	
		WebUI.getWebElement(By.xpath(FrameworkConstants.INPUT_OUTBOUND_NUMBER)).sendKeys(FrameworkConstants.OUTBOUND_NUMBER);
		WebUI.clickElement(By.xpath(FrameworkConstants.ADD_NUMBER_TO_MARKET_BUTTON));

	}
	public void AddMarketvalidation() throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.NUMBER_ADDED_SUCCESS_MESSAGE), FrameworkConstants.OUTBOUND_NUMBER_ADDED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.NUMBER_ADDED_SUCCESS_MESSAGE)),FrameworkConstants.OUTBOUND_NUMBER_ADDED_SUCCESS_MESSAGE);
//		Thread.sleep(2000);
		
	}
}
