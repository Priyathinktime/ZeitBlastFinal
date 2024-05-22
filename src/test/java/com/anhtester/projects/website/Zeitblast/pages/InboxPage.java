package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class InboxPage {
	List<String> textList;
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

	public void verifytitle() {

		wait.until(ExpectedConditions.titleContains(FrameworkConstants.INBOX_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(), FrameworkConstants.INBOX_PAGE_TITLE);
	}

	public void clickInbox() throws InterruptedException {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.INBOX_PAGE));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));

	}

	public void sendquickreply() {
//		List<WebElement> msg=WebUI.getWebElements(By.xpath("//p[@id='messageControler-displaynone']"));
		for (int i = 1; i <= 5; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]")));
			WebUI.clickElementWithJs(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]"));
			WebUI.clickElement(By.xpath(FrameworkConstants.QUICK_REPLY_BUTTON));
			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.QUICK_REPLY_TEMPLATE));
//			QA TEST  Smoke test
			WebUI.clickElement(By.xpath(FrameworkConstants.SEND_BUTTON));

		}
	}

	public void senddrips() throws InterruptedException {

		for (int i = 1; i <= 3; i++) {
			WebUI.clickElementWithJs(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]"));

			if (WebUI.getWebElement(By.xpath(FrameworkConstants.VERIFIED_BUTTON)).getAttribute("aria-label")
					.equalsIgnoreCase("This number is marked as Verified")) {

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrameworkConstants.LEADS_NAME)));
				WebUI.mouseHover(By.xpath(FrameworkConstants.LEADS_NAME));
//				(//div[@class='left'])[47]   (//h6)[27]  (//h6)[12]  //div[contains(@class,'desktop-rightSide')]/descendant::div[@class='items']

//				WebUI.mouseHover(By.xpath("//div[contains(@class,'desktop-rightSide')]/descendant::div[@class='items']"));

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.DRIP_ICON)));
				WebUI.clickElementWithJs(By.xpath(FrameworkConstants.DRIP_ICON));
				List<WebElement> names = WebUI.getWebElements(By.xpath(FrameworkConstants.DRIP_NAME));
				for (int j = 0; j < names.size(); j++) {

					int z = j + 1;
					if (WebUI.getWebElement(By.xpath("(//div[@class='item']/p)[" + z + "]")).getText()
							.equalsIgnoreCase("xyz")) {
//						Thread.sleep(1000);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[@class='item']/p)[" + z + "]/parent::div/div/button)[2]")));
						WebUI.clickElement(By.xpath("((//div[@class='item']/p)[" + z + "]/parent::div/div/button)[2]"));

						Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.DRIP_ASSIGN_SUCESS_MESSAGE)),
								"status was added");
						Thread.sleep(1000);
						break;
					}
				}
				WebUI.mouseHover(By.xpath(FrameworkConstants.LEADS_NAME));
				Assert.assertTrue(WebUI.getWebElement(By.xpath(FrameworkConstants.ASSIGNED_DRIP)).isDisplayed());
				System.out.println(WebUI.getTextElement(By.xpath(FrameworkConstants.NEXT_DRIP)));
//				(//span)[122]
				Assert.assertTrue(WebUI.getTextElement(By.xpath(FrameworkConstants.NEXT_DRIP))
						.contains("Next drip"));
				Thread.sleep(3000);

			}

		}

	}
	public boolean verifydripstatus() {

		return WebUI.getTextElement(By.xpath(FrameworkConstants.NEXT_DRIP))
				.contains("Next drip");
	}
	public boolean nodripstatus() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.DRIP_STATUS));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(FrameworkConstants.NO_STATUS_DRIP), FrameworkConstants.NO_DRIP_STATUS));

		return WebUI.getTextElement(By.xpath(FrameworkConstants.NO_STATUS_DRIP))
				.contains(FrameworkConstants.NO_DRIP_STATUS);
		
	}
	
	public void vailiadatedripmsg() throws InterruptedException {
		Thread.sleep(25000);
		for (int i = 1; i <= 3; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]")));
			WebUI.clickElementWithJs(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]"));
			Assert.assertTrue(WebUI.getTextElement(By.xpath(FrameworkConstants.DRIP_MESSAGE)).contains("234"));
			
		}
	}
	public void expiretag() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrameworkConstants.DRIP_EXPIRED)));
		Assert.assertTrue(WebUI.getWebElement(By.xpath(FrameworkConstants.DRIP_EXPIRED)).isDisplayed());
		
	}
	public void refresh() throws InterruptedException{
		WebUI.reloadPage();
		Thread.sleep(10000);
	}
	
	public void clicktheinboxmsg() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.LEAD_MESSAGE)));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.LEAD_MESSAGE));
	}
public void sendquickmsgindrip() throws InterruptedException { 
	WebUI.clickElement(By.xpath(FrameworkConstants.QUICK_REPLY_BUTTON));
	WebUI.clickElementWithJs(By.xpath(FrameworkConstants.DRIP_MESSAGE_TEMPLATE));

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.SEND_BUTTON)));
	WebUI.clickElement(By.xpath(FrameworkConstants.SEND_BUTTON));
	
		
	}

	public void changeoption(String option) {
		WebUI.getJsExecutor().executeScript("arguments[0].scrollIntoView(true);",
				WebUI.getWebElement(By.xpath(FrameworkConstants.SELECT_OPTIONS)));
		WebUI.selectOptionByValue(By.xpath(FrameworkConstants.SELECT_OPTIONS), option);
	}

	public void grapthesendmsgtext() {

		textList = WebUI.getListElementsText(By.xpath(FrameworkConstants.GRAB_SEND_MESSAGE));

	}

	public void verifyinorder() {
		for (int i = 40; i >= 1; i--) {
			String expectedText = "Automation_" + String.format("%02d", i) + " Tester_" + String.format("%02d", i);
			Assert.assertEquals(textList.get(40 - i), expectedText);
		}

	}
	public void senddripsforsinglelead() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.LEAD_MESSAGE)));
		
			WebUI.clickElementWithJs(By.xpath(FrameworkConstants.LEAD_MESSAGE));

			if (WebUI.getWebElement(By.xpath(FrameworkConstants.VERIFIED_BUTTON)).getAttribute("aria-label")
					.equalsIgnoreCase("This number is marked as Verified")) {
//				WebUI.mouseHover(By.xpath("(//h6)[12]"));

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrameworkConstants.LEAD_MESSAGE_NAME)));
				WebUI.mouseHover(By.xpath(FrameworkConstants.LEAD_MESSAGE_NAME));
//				(//div[@class='left'])[47]   (//h6)[27]  (//h6)[12]    //div[contains(@class,'desktop-rightSide')]/descendant::div[@class='items'] (//div[@class='css-za3tm3']/div)[2]

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FrameworkConstants.ASSIGNED_DRIP_LEADS)));
				WebUI.clickElementWithJs(By.xpath(FrameworkConstants.ASSIGNED_DRIP_LEADS));
				List<WebElement> names = WebUI.getWebElements(By.xpath(FrameworkConstants.DRIP_NAME));
				for (int j = 0; j < names.size(); j++) {

					int z = j + 1;
					if (WebUI.getWebElement(By.xpath("(//div[@class='item']/p)[" + z + "]")).getText()
							.equalsIgnoreCase("xyz")) {

						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[@class='item']/p)[" + z + "]/parent::div/div/button)[2]")));
						WebUI.clickElement(By.xpath("((//div[@class='item']/p)[" + z + "]/parent::div/div/button)[2]"));

						Assert.assertEquals(WebUI.getTextElement(By.xpath(FrameworkConstants.DRIP_ASSIGN_SUCESS_MESSAGE)),
								"status was added");

						break;
					}
				}
				WebUI.mouseHover(By.xpath(FrameworkConstants.LEAD_MESSAGE_NAME));
				Assert.assertTrue(WebUI.getWebElement(By.xpath(FrameworkConstants.ASSIGNED_DRIP)).isDisplayed());
				System.out.println(WebUI.getTextElement(By.xpath(FrameworkConstants.NEXT_DRIP)));
//				(//span)[122]
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrameworkConstants.NEXT_DRIP)));
				Assert.assertTrue(WebUI.getTextElement(By.xpath(FrameworkConstants.NEXT_DRIP))
						.contains("Next drip"));


			

		}

	}
	
	public void Noshuffledmsg() throws InterruptedException {
//	
		for (int i = 1; i <= 10; i++) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]")));
			WebUI.clickElementWithJs(By.xpath("(//p[@id='messageControler-displaynone'])[" + i + "]"));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrameworkConstants.LEAD_NUMBER_PATH)));
			String text=WebUI.getTextElement(By.xpath(FrameworkConstants.LEAD_NUMBER_PATH));
			System.out.println(text);
			System.out.println(WebUI.getTextElement(By.xpath(FrameworkConstants.LEAD_RESPONSE_MESSAGE)));
			Assert.assertTrue(WebUI.getTextElement(By.xpath(FrameworkConstants.LEAD_RESPONSE_MESSAGE)).contains(text));

			
		}
		
	}
}