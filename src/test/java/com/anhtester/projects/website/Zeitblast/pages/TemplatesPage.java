package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class TemplatesPage {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	public void quickreplytab() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.QUICK_REPLY_TAB));	
	}

	public void createnewcategory(String category) {
		WebUI.clickElement(By.xpath(FrameworkConstants.CREATE_NEW_CATEGORY_BUTTON));
		WebUI.setText(By.xpath(FrameworkConstants.CATEGORY_NAME),category);
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SAVE_BUTTON));
	}
	
	public void selectctegory(String category) {
		
		WebUI.selectOptionByText(By.xpath(FrameworkConstants.SELECT_OPTIONS),category);
	}
	
	public void entertitle(String title) {
		WebUI.setText(By.xpath(FrameworkConstants.INPUT_TITLE),title );
	}

	public void entermessage(String message) {
		WebUI.setText(By.xpath(FrameworkConstants.TEMPLATE_TEXTAREA),message );
	}
	
	public void savequickreply() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SAVE_QUICK_REPLY_BUTTON)); 
	}
	
	public void verifytitle() {
	
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.INITIAL_MESSAGE_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(),FrameworkConstants.INITIAL_MESSAGE_PAGE_TITLE);
	}
	
	public void clickTemplates() throws InterruptedException {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.TEMPLATE_PAGE));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
		
	}
	public void createnewinitialtempletes()
	{
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_INITIAL_MESSAGE));
		
	}
	public void givenameandtype(String name, String type) {
		WebUI.setText(By.xpath(FrameworkConstants.INPUT_TEMPLATE_NAME), name);
		WebUI.selectOptionByValue(By.xpath(FrameworkConstants.SELECT_TEMPLATE_TYPE), type);
	}
	public void clickfollowuptab() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.CREATE_FOLLOWUP_MESSAGE));
		
	}
	public void setinitailtempleatemsg(String name) {
		int a=0;
		int b=0;
		switch (name) {
		case "initial":
			a=1;
			b=4;

			break;
		case "followup":
			a=11;
			b=14;
	
			break;
		}
		for(int i=a;i<=b;i++) {
		WebUI.setText(By.xpath(FrameworkConstants.TEXTAREA),FrameworkConstants.MESSAGE_TEMPLATE + i);
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.NEXT_BUTTON));
		}
		WebUI.setText(By.xpath(FrameworkConstants.TEXTAREA), "QATesting");
	
	}
	public void savetemplate() {
		WebUI.clickElement(By.xpath(FrameworkConstants.SUBMIT_BUTTON));
	}
	public void verifysuccessinitialandfollowtext() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.TEMPLATE_CREATED_SUCCESS_MESAGE_PATH), FrameworkConstants.TEMPLATE_CREATED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.TEMPLATE_CREATED_SUCCESS_MESAGE_PATH)),FrameworkConstants.TEMPLATE_CREATED_SUCCESS_MESSAGE);

	}
	
	public void verifysuccessquicktext() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.CATEGORY_CREATED_SUCCESS_MESAGE), FrameworkConstants.CATEGORY_CREATED_SUCCESS_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.CATEGORY_CREATED_SUCCESS_MESAGE)), FrameworkConstants.CATEGORY_CREATED_SUCCESS_MESSAGE);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.SUCCESSFULLY_CREATED_SUCCESS_MESAGE), FrameworkConstants.SUCCESSFULLY_CREATED_MESSAGE));
		Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.SUCCESSFULLY_CREATED_SUCCESS_MESAGE)), FrameworkConstants.SUCCESSFULLY_CREATED_MESSAGE);
		//		Category created successfully!  Successfully created

	}
}
