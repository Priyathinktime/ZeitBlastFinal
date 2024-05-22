package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class CampaignsPage {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void verifytitle() {
		
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.CAMPAIGNS_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(), FrameworkConstants.CAMPAIGNS_PAGE_TITLE);
	}
	
	public void clickCampaigns() throws InterruptedException {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CAMAPIGN_BUTTON));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
		
	}
	
	public void createcampaign()  {
//		Thread.sleep(2000);
//		WebUI.clickElementWithJs(By.xpath("(//span[@class='icon'])[6]"));
		try {
			WebUI.clickElement(By.xpath(FrameworkConstants.CREATE_NEW_CAMPAIGN_BUTTON));

		} catch (ElementClickInterceptedException e) {
			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_NEW_CAMPAIGN_BUTTON));
		}

		WebUI.setText(By.xpath(FrameworkConstants.INPUT_CAMAPIGN_NAME), FrameworkConstants.CAMPAIGN_NAME);
		WebUI.selectOptionByText(By.xpath(FrameworkConstants.SELECT_MARKET_NAME), FrameworkConstants.AREA_CODE);
		WebUI.sendKeys(By.xpath(FrameworkConstants.SELECT_MARKET_NAME), Keys.ENTER);
		WebUI.clickElement(By.xpath(FrameworkConstants.MARKET_SUBMIT_BUTTON));



	}
	public void createfollowupcampaign() {
		try {
			WebUI.clickElement(By.xpath(FrameworkConstants.CREATE_NEW_FOLLOWUP_CAMPAIGN_BUTTON));

		} catch (ElementClickInterceptedException e) {
			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_NEW_FOLLOWUP_CAMPAIGN_BUTTON));
		}
		WebUI.clickElement(By.xpath(FrameworkConstants.SELECT_CAMAPIGN_BUTTON));
		WebUI.clickElement(By.xpath(FrameworkConstants.BUTTON_CONTAINS_SELECT_));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SELECT_FOLLOWUP_CAMPAIGN));
		WebUI.clickElement(By.xpath(FrameworkConstants.SUBMIT_BUTTON));
		
		
	}
	public void createfollowupcampaignvalidation()throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.FOLLOWUP_CREATED_SUCCESSFULLY_SUCESS_MESSAGE), FrameworkConstants.FOLLOWUP_CAMPAIGN_CREATED_SUCCESS_MESSAGE));
		
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.FOLLOWUP_CREATED_SUCCESSFULLY_SUCESS_MESSAGE)), FrameworkConstants.FOLLOWUP_CAMPAIGN_CREATED_SUCCESS_MESSAGE);

	}

	public void createcampaignvalidation() throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.CREATED_SUCCESSFULLY_SUCESS_MESSAGE), FrameworkConstants.CAMPAIGN_CREATED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.CREATED_SUCCESSFULLY_SUCESS_MESSAGE)),FrameworkConstants.CAMPAIGN_CREATED_SUCCESS_MESSAGE);

	}
	
	public void Campaigndetails() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CAMPAIGN_DETAILS));
//		 (//div[contains(@class,'col data')])[1]
		WebUI.getJsExecutor().executeScript("arguments[0].scrollIntoView(true);", WebUI.getWebElement(By.xpath(FrameworkConstants.CAMPAIGN_DETAIL_DASHBOARD)));
		
	}
	
	public String Campaigndeliverabilitypercentage() {
//		String Campaigndeliverability = WebUI.getTextElement(By.xpath("(//td)[13]")).replaceAll("[^\\d.]", "").replaceAll("\\.0*$", "");
//		+ "%";
		String Campaigndeliverability = WebUI.getTextElement(By.xpath("(//td)[13]")).replaceAll("[^\\d.]", "").split("\\.")[0];
		System.out.println(Campaigndeliverability);
		return Campaigndeliverability;
		
	}
	public String CampaignResponsepercentage() {
//		String CampaignResponse = WebUI.getTextElement(By.xpath("(//td)[14]")).replaceAll("[^\\d.]", "").replaceAll("\\.0*$", "");
		String CampaignResponse = WebUI.getTextElement(By.xpath("(//td)[14]")).replaceAll("[^\\d.]", "").split("\\.")[0];
		System.out.println(CampaignResponse);
		return CampaignResponse;
	}
	
}
