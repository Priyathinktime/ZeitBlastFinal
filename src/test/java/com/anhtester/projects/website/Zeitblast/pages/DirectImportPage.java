package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class DirectImportPage {

	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void verifytitle() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.PAGE_ICON));
		
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.DIRECT_IMPORT_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(), FrameworkConstants.DIRECT_IMPORT_PAGE_TITLE);
	}
	
	public void clickDirectImport() throws InterruptedException {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.DIRECT_IMPORT_BUTTON));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
		
	}

	public void importfile(String uploadfile) {
		String file=null;
		switch (uploadfile) {
		case "LEADS_EXCEL_DATA_FILE_PATH":
			file=FrameworkConstants.LEADS_EXCEL_DATA_FILE_PATH;
			break;
		case "EXCEL_DATA_20K_FILE_PATH":
			file=FrameworkConstants.EXCEL_DATA_20K_FILE_PATH;
			break;
		case "XLX_DATA_30K_FILE_PATH":
			file=FrameworkConstants.XLX_DATA_30K_FILE_PATH;
			break;
		case "CSV_DATA_50K_FILE_PATH":
			file=FrameworkConstants.CSV_DATA_50K_FILE_PATH;
			break;
		case "TESTDATA_10_PATH":
			file=FrameworkConstants.TESTDATA_10_PATH;
			break;
		case "TESTDATA_01_PATH":
			file=FrameworkConstants.TESTDATA_01_PATH;
			break;
		case "LEADS_EXCEL_DATA_200_FILE_PATH":
			file=FrameworkConstants.LEADS_EXCEL_DATA_200_FILE_PATH;
			break;
			
		

		}
		

		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.IMPORT_LIST_BUTTON));
		WebElement fileInput = WebUI.getWebElement(By.xpath(FrameworkConstants.INPUT_FILE_PATH));
		fileInput.sendKeys(file);
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.INPUT_FIELD_BUTTON));

		String[] values = { "FirstName", "LastName", "MailingAddress", "MailingCity", "MailingState", "MailingZip",
				"PropertyAddress", "PropertyCity", "PropertyState", "PropertyZip", "Phone1", "Phone2", "Phone3" };
		selectOptionsFromDropdowns(values, 13);

	}

	public void clickimport() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.IMPORT_BUTTON));
	}

	public void verifyimport() {
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.ADDED_SUCCESS_MESSAGE)), FrameworkConstants.FILE_IMPORTED_SUCCESS_MESSAGE);

	}

	private void selectOptionsFromDropdowns(String[] values, int dropdownCount) {
		for (int i = 1; i <= dropdownCount; i++) {
			WebElement dropdown = WebUI.getWebElement(By.xpath("(//select)[" + i + "]"));
			Select select = new Select(dropdown);
			select.selectByValue(values[i - 1]);
		}
	}
	public void campaignassign() throws InterruptedException {
		
		WebUI.waitForElementClickable(By.xpath(FrameworkConstants.ASSIGN_CAMPAIGN_BUTTON));
		try {
			WebUI.clickElement(By.xpath(FrameworkConstants.ASSIGN_CAMPAIGN_BUTTON));

		} catch (ElementClickInterceptedException e) {
			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ASSIGN_CAMPAIGN_BUTTON));
		}

		WebUI.clickElement(By.xpath(FrameworkConstants.SELECT_BUTTON));

	}
	public void assigncampaignvalidation() throws InterruptedException {
		
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.ASSIGN_SUCCESSFULLY_SUCESS_MESSAGE),FrameworkConstants.CAMPAIGN_ASSIGNED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.ASSIGN_SUCCESSFULLY_SUCESS_MESSAGE)), FrameworkConstants.CAMPAIGN_ASSIGNED_SUCCESS_MESSAGE);
		Thread.sleep(2000);
	}
	
	public void fileupload0f20k() {
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(900));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE),FrameworkConstants.FILE_UPLOADED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE)), FrameworkConstants.FILE_UPLOADED_SUCCESS_MESSAGE);
		
	}
	
	
	public void fileupload0f30k(){
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1200));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE),FrameworkConstants.FILE_UPLOADED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE)), FrameworkConstants.FILE_UPLOADED_SUCCESS_MESSAGE);
	
	}
	public void fileupload0f50k() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1500));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE),FrameworkConstants.FILE_UPLOADED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE)), FrameworkConstants.FILE_UPLOADED_SUCCESS_MESSAGE);
	
	}
	
	
	
	
}
