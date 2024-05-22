package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class BatchesPage {

	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void verifytitle() {
		
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.BATCHES_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(), FrameworkConstants.BATCHES_PAGE_TITLE);
	}
	public void clickbatch() throws InterruptedException {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.BATCHES_BUTTON));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
		
	}
	public void Selectcamaign() throws InterruptedException {


		try {
			WebUI.clickElement(By.xpath(FrameworkConstants.CREATE_NEW_BATCH_BUTTON));

		} catch (ElementClickInterceptedException e) {
			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_NEW_BATCH_BUTTON));

		}

		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SELECT_CAMAPIGN_BUTTON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SELECT_BATCH_BUTTON));
	
	}
		public void createbatch(String template) throws InterruptedException {

			WebUI.selectOptionByText(By.xpath(FrameworkConstants.SELECT2_BUTTON), template);

		WebUI.clickElement(By.xpath(FrameworkConstants.SELECT_BATCH_SIZE_BUTTON));

//		WebUI.clickElement(By.xpath(("//button[contains(.,'"+FrameworkConstants.Batches+"')])[1]")));
		WebUI.clickElement(By.xpath(("//button[.='"+FrameworkConstants.BATCH_SIZE+"']")));
		
		//button[.='"+FrameworkConstants.Batches+"']    "+FrameworkConstants.Batches+"
		WebUI.clickElement(By.xpath(FrameworkConstants.CREATE_BATCH_BUTTON));

	}	
	public void sendmsg() throws InterruptedException {

		try {
		    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.BOTTOM_BUTTON)));
		    button.click();
		} catch (StaleElementReferenceException e) {
		    Thread.sleep(3000);
		    WebElement  button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.BOTTOM_BUTTON)));
		    button.click();
		}

catch (TimeoutException e) {
	WebUI.waitForElementClickable(By.xpath(FrameworkConstants.BOTTOM_BUTTON));
}
		
		boolean yes = true;

		try {
			while (yes) {
				WebElement element = WebUI.getWebElement(By.xpath(FrameworkConstants.BOTTOM_BUTTON));
				if (element.isDisplayed()) {
					WebUI.clickElementWithJs(By.xpath(FrameworkConstants.BOTTOM_BUTTON));

				} else {
					yes = false;
		
				}
			}
		} catch (NoSuchElementException e) {

			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.GO_TO_INBOX_BUTTON));
		}

	}
	
	public void timeoutmessage() throws InterruptedException {
	
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.OFFICE_TIMEOUT_MESSAGE), FrameworkConstants.OFFICE_TIMEOUT_SUCCESS_MESSAGE));
		
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.OFFICE_TIMEOUT_MESSAGE)), FrameworkConstants.OFFICE_TIMEOUT_SUCCESS_MESSAGE);
		System.out.println(FrameworkConstants.OFFICE_TIMEOUT_MESSAGE);
	}

	
	public String batchesdeliverabilitypercentage() {
//		String  batchesdeliverability = WebUI.getTextElement(By.xpath("(//div[@class='col data'])[5]")).replaceAll("[^\\d.]", "").replaceAll("\\.0*$", "") + "%";
//		String batchesdeliverability = Math.round(Double.parseDouble(WebUI.getTextElement(By.xpath("(//div[@class='col data'])[5]").replaceAll("[^\\d.]", "")))) + "%";
//		String batchesdeliverability = WebUI.getTextElement(By.xpath("(//div[@class='col data'])[5]").replaceAll("[^\\d.]", ""));
		String batchesdeliverability = WebUI.getTextElement(By.xpath("(//div[@class='col data'])[5]")).replaceAll("[^\\d.]", "").split("\\.")[0];

		System.out.println(batchesdeliverability);
		return batchesdeliverability;
		
	}
	public String batchesResponsepercentage() {
//		String batchesResponse = WebUI.getTextElement(By.xpath("(//div[@class='col data'])[6]")).replaceAll("[^\\d.]", "").replaceAll("\\.0*$", "") + "%";
		String batchesResponse = WebUI.getTextElement(By.xpath("(//div[@class='col data'])[6]")).replaceAll("[^\\d.]", "").split("\\.")[0];
		System.out.println(batchesResponse);
		return batchesResponse;
		
	}
}
