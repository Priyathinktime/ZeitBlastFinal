package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class DripAutomationsPage {

	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void verifytitle() {
		
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.DRIP_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(),FrameworkConstants.DRIP_PAGE_TITLE);
	}

	
	public void clickdripautomation() {
		WebUI.mouseHover(By.xpath(FrameworkConstants.DRIP_AUTOMATION_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.DRIP_AUTOMATION_BUTTON));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
	}
	
	public void notexistdripautomation() {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
	
		 boolean isSettingsVisible = isElementPresent(By.xpath(FrameworkConstants.DRIP_AUTOMATION_BUTTON));
	        Assert.assertFalse(isSettingsVisible, "Drip Automation page should not be visible for agent.");
	}
	private boolean isElementPresent(By locator) {
		 try {  
			 return  WebUI.getWebElement(locator).isDisplayed();       
	        } catch (NoSuchElementException e) {
	            return false;
	        }
		 }
	public void createnewdrip() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_NEW_DRIP_BUTTON));
	}
	
	public void enterdripname(String name) {
		WebUI.setText(By.xpath(FrameworkConstants.INPUT_DRIP_AUTOMATION_NAME), name);
	}
	
	public void addbutton() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ADD_DRIP_BUTTON));
		
	}
	
	public void savedrip() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SAVE_DRIP_BUTTON));
		
	}
	
	
	public void successmsg() {
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.DRIP_CREATED_SUCESS_MESSAGE_PATH)),FrameworkConstants.DRIP_CREATED_SUCCESS_MESSAGE);
		
	}
	
	public void addmessage() {
		for(int i=1; i<=4;i++) {
			String message =FrameworkConstants.MESSAGE_TEMPLATE+ i;
//			WebUI.clickElementWithJs(By.xpath("(//input)[2]"));
			WebUI.setText(By.xpath(FrameworkConstants.TEXTAREA), message);
			while(i<=3) {
				WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ADD_DRIP_BUTTON));
				break;
			}
		
	}
	
	}
	
	}

