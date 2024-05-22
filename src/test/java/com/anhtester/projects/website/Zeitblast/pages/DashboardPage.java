package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class DashboardPage {

	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void checkdashboard(String delivery, String response) throws InterruptedException {
	
	}
	public void checkdashboard(int delivery, int response) throws InterruptedException {
		
		Thread.sleep(4000);
		WebUI.reloadPage();
		Thread.sleep(6000);

		
		String DeliveryRate = WebUI.getTextElement(By.xpath(FrameworkConstants.AVERAGE_DELIVERY_RATE)).split("/")[0];
		Assert.assertEquals(DeliveryRate, Integer.toString(delivery));
		String msgRate = WebUI.getTextElement(By.xpath(FrameworkConstants.AVERAGE_RESPONSE_RATE)).split("/")[0];
		Assert.assertEquals(msgRate, Integer.toString(response));
	}
	
	public void verifytitle() {

		
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.DASHBOARD_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(), FrameworkConstants.DASHBOARD_PAGE_TITLE);
	}
	
	
}
