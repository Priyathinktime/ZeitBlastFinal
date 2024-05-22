package com.anhtester.projects.website.Zeitblast.stepdefinitions.UI;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.hooks.TestContext;
import com.anhtester.keywords.WebUI;
import com.anhtester.projects.website.Zeitblast.pages.BatchesPage;
import com.anhtester.projects.website.Zeitblast.pages.CampaignsPage;
import com.anhtester.projects.website.Zeitblast.pages.DashboardPage;
import com.anhtester.projects.website.Zeitblast.pages.DirectImportPage;
import com.anhtester.projects.website.Zeitblast.pages.DripAutomationsPage;
import com.anhtester.projects.website.Zeitblast.pages.InboxPage;
import com.anhtester.projects.website.Zeitblast.pages.SettingsPage;
import com.anhtester.projects.website.Zeitblast.pages.TemplatesPage;
import com.anhtester.projects.website.Zeitblast.pages.ZeitblastUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UI {
	ZeitblastUI ui;
	DashboardPage dashboard;
	DirectImportPage directimport;
 CampaignsPage campaigns;
	BatchesPage batches;
	SettingsPage settings;
	InboxPage inbox;
	DripAutomationsPage dripautomation;
  TemplatesPage templates;
  String deliver;
  String deliver1;
  String Response;
  String Response1;

	public UI(TestContext testContext) {
		ui = testContext.getUI();
		dashboard = testContext.getDashboardPage();
		directimport=testContext.getDirectImportPage();
		campaigns=testContext.getCampaignsPage();
		batches=testContext.getBatchesPage();
		settings=testContext.getSettingsPage();
		inbox =testContext.getInboxPage();
		templates=testContext.getTemplatesPage();
		dripautomation=testContext.getDripAutomationsPage();
	}

//
////	@Given("Navigating to the Zeitblast Website with credetials")
////	public void navigating_to_the_zeitblast_website_with_credetials() throws InterruptedException {
////
////		ui.loginPage("super admin");
////	}
//
	@When("Verifing the Send message and delivery count in Dashboard {int}")
	public void verifing_the_send_message_and_delivery_count_in_dashboard(Integer a) throws InterruptedException {
		
		
		switch (a) {
		case 0:
//			dashboard.checkdashboard("0/0", "0/0");
			dashboard.checkdashboard(0,0);
			break;
		case 1:
			int deleviery1=FrameworkConstants.No_of_Delivery_1;
			int sendmsg1=FrameworkConstants.No_of_SendMSg_1;
//			dashboard.checkdashboard("50/100", "40/50");
			dashboard.checkdashboard(deleviery1, sendmsg1);
			break;
		case 2:
//			dashboard.checkdashboard("50/170", "40/50");
//			dashboard.checkdashboard("0/70", "0/0");
			dashboard.checkdashboard(0,0);
			break;
		case 3:
			int deleviery2=FrameworkConstants.No_of_Delivery_2;
			int sendmsg2=FrameworkConstants.No_of_SendMSg_2;
//			dashboard.checkdashboard("100/170", "80/100");
//			dashboard.checkdashboard("50/70", "40/50");
			dashboard.checkdashboard(deleviery2, sendmsg2);
			break;
		case 4:
//			dashboard.checkdashboard("100/210", "80/100");
//			dashboard.checkdashboard("0/40", "0/0");
			dashboard.checkdashboard(0,0);
			break;
		case 5:
			int deleviery3=FrameworkConstants.No_of_Delivery_3;
			int sendmsg3=FrameworkConstants.No_of_SendMSg_3;
//			dashboard.checkdashboard("140/210", "120/140");
//			dashboard.checkdashboard("40/40", "40/40");
			dashboard.checkdashboard(deleviery3, sendmsg3);
			break;
		}

	}
	@When("The User should select the leads to send the quick reply")
	public void The_User_should_select_the_leads_to_send_the_quick_reply() {
		inbox.sendquickreply();
	}
	@When("The User should select the leads to send the Drips")
	public void The_User_should_select_the_leads_to_send_the_Drips() throws InterruptedException {
		inbox.senddrips();
	}
	
	@Then("The user should observe the first drip assigned to the lead")

	public void dripassignstatus() throws InterruptedException {
		inbox.clicktheinboxmsg();
		Assert.assertTrue(inbox.verifydripstatus());
		
	}
	@Then("The user should observe no drip assigned for the lead") 
	public void nodripassigned() throws InterruptedException {
		inbox.clicktheinboxmsg();
		Assert.assertTrue(inbox.nodripstatus());
		
	}
	@Then("The User should observe the message send for the lead should appear only in the same leads inbox")
	public void observenosuffledinmsg() throws InterruptedException {
		
		inbox.Noshuffledmsg();
	}
	 
	 
	 @Then("The user should wait for a minute and observe a expired tag")
	 public void expiredtagvalidation() throws InterruptedException {
		 Thread.sleep(120000);
		 inbox.clicktheinboxmsg();
		 inbox.refresh();
		 inbox.expiretag();
		 
	 }
	
	
	@Then("The User is navigated to the Inbox page")
	public void The_User_is_navigated_to_the_Inbox_page() {
		inbox.verifytitle();
		
	}
	@Then("The user should send the quick reply message")
	public void The_user_should_send_the_quick_reply_message() throws InterruptedException {
		inbox.clicktheinboxmsg();
		inbox.sendquickmsgindrip();
	}
	@Then("The initial message count in the header and the message count in the messages send today should be same")
	public void verifyinitialmsgcount() {
		settings.Verifymessagecounttoday();
	}
	
	@When("The User grab the deliverability and response percentage from the batches page")
	public void grab_deliverability_and_response_percentage() {
	deliver=batches.batchesdeliverabilitypercentage();
	 Response=batches.batchesResponsepercentage();
		
	}
	
	 @When("The User grab the deliverability and response percentage from the Campaigns page")
	 public void grab_deliverability_and_response_percentage_campaign() {
//		 (//div[@class='col data']/p)[1]
		 campaigns.Campaigndetails();
	deliver1=campaigns.Campaigndeliverabilitypercentage();
		 Response1=campaigns.CampaignResponsepercentage();
		 
		 
	 }
	 
	    @Then("The  deliverability and response percentage from the batches and Campaigns page should be same")
		 public void grab_deliverability_and_response_percentage_campaign_validation() {
	   Assert.assertEquals(deliver, deliver1);
	   Assert.assertEquals(Response, Response1);
	    
	    }
	    @When("The User should be able to navigate the Drip Automations page")
		public void the_user_should_be_able_to_navigate_the_drip_automations_page() {
			dripautomation.clickdripautomation();
		}
		@When("The User clicks the Create New Drip")
		public void the_user_clicks_the_create_new_drip() {
			dripautomation.createnewdrip();
		}
		@When("The User enters the Drip Automation name as {string}")
		public void the_user_enters_the_drip_automation_name_as(String name) {
			dripautomation.enterdripname(name);
		}
		@When("The User enters the message")
		public void the_user_enters_the_send_on_day_as_and_enters_the_message() {
			dripautomation.addmessage();
		}

		@When("The User saves the Drip Automation")
		public void the_user_saves_the_drip_automation() {
			dripautomation.savedrip();
		}
		@Then("The user should observe a success message confirming the drip is created successfully")
		public void the_user_should_observe_a_success_message_confirming_the_drip_is_created_successfully() {
			dripautomation.successmsg();
		}
		@When("The user Changes the message view option as {string}")
		    public void changeMessageViewOption(String option) {
		    inbox.changeoption(option);
		    }

		    @And("The user grabs the prospects name")
		    public void grabProspectsName() {
		    	inbox.grapthesendmsgtext();
		    }
		    @Then("The user should send the quick reply message for single lead")
		    public void quick_reply_message_for_single_lead() throws InterruptedException {
		    	Thread.sleep(90000);
		    	inbox.clicktheinboxmsg();
		    	inbox.sendquickmsgindrip();
		    	
		    }
		    @Then("The User should select the single leads to send the Drips")
		    public void single_lead_drip_msg() throws InterruptedException {
		    	inbox.senddripsforsinglelead();
		    }

		    @Then("To validate that the prospects list is shown in order")
		    public void validateProspectListOrder() {
		    	inbox.verifyinorder();	
		    }
		    
		    @Then("The user should observe a success message confirming the file of 20K prospects uploaded successfully")
		    public void fileuploadedsuccessmsg_20k_validation() {
             directimport.fileupload0f20k();
		    }
		    
		    @Then("The user should observe a success message confirming the file of 30K prospects uploaded successfully")
		    public void fileuploadedsuccessmsg_30k_validation() {
		    	directimport.fileupload0f30k();
		    }
		    
		    @Then("The user should observe a success message confirming the file of 50K prospects uploaded successfully")
		    public void fileuploadedsuccessmsg_50k_validation() {
		    	directimport.fileupload0f50k();
		    }
		    
		    
		    
		    

}
		

