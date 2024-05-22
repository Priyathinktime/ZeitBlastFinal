package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class ZeitblastUI {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void loginPage(String user) {
		String username = null;
		String password = null;

		switch (user) {
		case "super admin":
			username = FrameworkConstants.QA_ADMIN_EMAIL_ADDRESS;
			password = FrameworkConstants.QA_ADMIN_PASSWORD;
			break;
		case "agent":
			username = FrameworkConstants.QA_AGENT_EMAIL_ADDRESS;
			password = FrameworkConstants.QA_AGENT_PASSWORD;
			break;

		}
		WebUI.getURL(FrameworkConstants.QA_URL);
		WebUI.setText(By.xpath(FrameworkConstants.LOGIN_USERNAME_PATH), username);
		WebUI.setText(By.xpath(FrameworkConstants.LOGIN_PASSWORD_PATH), password);

		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.LOGIN_TERMS_CONDITION_BOX));
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.LOGIN_BUTTON)));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.LOGIN_BUTTON));

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleContains(FrameworkConstants.DASHBOARD_PAGE_TITLE));
		} catch (Exception e) {

			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.LOGIN_BUTTON));
		}
		WebUI.waitForPageLoaded();

	}
	
	public void logout() {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ACCOUNT_NAME_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.LOGOUT_BUTTON));
		
		
	}

}