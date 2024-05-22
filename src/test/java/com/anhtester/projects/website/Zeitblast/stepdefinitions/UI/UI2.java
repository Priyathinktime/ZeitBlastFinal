package com.anhtester.projects.website.Zeitblast.stepdefinitions.UI;


import com.anhtester.hooks.TestContext;
import com.anhtester.projects.website.Zeitblast.pages.BatchesPage;
import com.anhtester.projects.website.Zeitblast.pages.CampaignsPage;
import com.anhtester.projects.website.Zeitblast.pages.DashboardPage;
import com.anhtester.projects.website.Zeitblast.pages.DirectImportPage;
import com.anhtester.projects.website.Zeitblast.pages.DripAutomationsPage;
import com.anhtester.projects.website.Zeitblast.pages.InboxPage;
import com.anhtester.projects.website.Zeitblast.pages.SettingsPage;
import com.anhtester.projects.website.Zeitblast.pages.TemplatesPage;
import com.anhtester.projects.website.Zeitblast.pages.ZeitblastUI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UI2 {
	ZeitblastUI ui;
	DashboardPage dashboard;
	DirectImportPage directimport;
 CampaignsPage campaigns;
	BatchesPage batches;
	SettingsPage settings;
	InboxPage inbox;
  TemplatesPage templates;
  DripAutomationsPage dripautomation;

	public UI2(TestContext testContext) {
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
	@Given("The user logs in the Zeitblast application with {string} credentials")
	public void the_user_logs_in_the_zeitblast_application_with_credentials(String user) {
		ui.loginPage(user);
	}

	@When("The user navigate to the direct import page from the home page")
	public void move_to_direct_import() throws InterruptedException {
		directimport.clickDirectImport();
	}
	@When("The user upload the excel file {string} in the import file field")
	public void the_user_upload_the_excel_file_in_the_import_file_field(String path) {
		directimport.importfile(path);
		
	}

	@When("The user import the excel file by clicking the import button")
	public void the_user_import_the_excel_file_by_clicking_the_import_button() {
          
		directimport.clickimport();
		}
	@Then("The excel file has to be imported")
	public void the_excel_file_has_to_be_imported(){
		directimport.verifyimport();
	}
	

@When("The User should be in the dashboard page")
public void the_user_should_be_in_the_dashboard_page() {
	dashboard.verifytitle();
}
@Then("The User should be able to navigate the Inbox page")
public void the_user_should_be_able_to_navigate_the_inbox_page() throws InterruptedException {
	inbox.clickInbox();
	inbox.verifytitle();
}
@Then("The User should be able to navigate the Direct Import page")
public void the_user_should_be_able_to_navigate_the_direct_import_page() throws InterruptedException {
	directimport.clickDirectImport();
	directimport.verifytitle();
}
@Then("The User should be able to navigate the Batches page")
public void the_user_should_be_able_to_navigate_the_batches_page() throws InterruptedException {
	batches.clickbatch();
	batches.verifytitle();
}
@Then("The User should be able to navigate the Campaigns page")
public void the_user_should_be_able_to_navigate_the_campaigns_page() throws InterruptedException {
	campaigns.clickCampaigns();
	campaigns.verifytitle();
}
@Then("The User should be able to navigate the Templates page")
public void the_user_should_be_able_to_navigate_the_templates_page() throws InterruptedException {
	templates.clickTemplates();
	templates.verifytitle();
}

@When("The user creates a new market and enters the market name {string}, Area code {string}, and Call forwarding number {string}")
public void the_user_creates_a_new_market_and_enters_the_market_name_area_code_and_call_forwarding_number(String name, String code, String no) throws InterruptedException {
	settings.clickSettings();
	settings.createmarket(name,code,no);

}
@Then("The user should observe a success message confirming the creation of the new market")
public void the_user_should_observe_a_success_message_confirming_the_creation_of_the_new_market() throws InterruptedException {
	settings.createMarketValidation();
}
@Then("The user adds an outbound number in the existing market")
public void the_user_adds_an_outbound_number_in_the_existing_market() {
	settings.addtomarket();
}
@Then("The user should observe a success message confirming the outbound number is added")
public void the_user_should_observe_a_success_message_confirming_the_outbound_number_is_added() throws InterruptedException {
	settings.AddMarketvalidation();
}
@Then("The user creates a new campaign and enters the campaign name and selects the market")
public void the_user_creates_a_new_campaign_and_enters_the_campaign_name_and_selects_the_market() throws InterruptedException {
	campaigns.clickCampaigns();
	campaigns.createcampaign();
}
@Then("The user should observe a success message confirming the creation of the new campaign")
public void the_user_should_observe_a_success_message_confirming_the_creation_of_the_new_campaign() throws InterruptedException {
	campaigns.createcampaignvalidation();
}
@Then("The user assigns the prospects to the created campaign in the direct import page")
public void the_user_assigns_the_prospects_to_the_created_campaign_in_the_direct_import_page() throws InterruptedException {
	directimport.clickDirectImport();
	directimport.campaignassign();
}

@Then("The User should be able to navigate the Settings page")
public void The_User_should_be_able_to_navigate_the_Settings_page() throws InterruptedException {
	settings.clickSettings();
	settings.verifytitle();

}
@Then("The User should not be able to navigate the Settings page")
public void The_User_should_not_be_able_to_navigate_the_Settings_page() throws InterruptedException {
	settings.notexistsettings();
}

@Then("The User should not be able to navigate the Drip Automation page")
public void The_User_should_not_be_able_to_navigate_the_Drip_Automations_page() throws InterruptedException {
	dripautomation.notexistdripautomation();
}

@When("The user should observe a success message confirming the creation of the new follow up campaign")
public void the_user_should_observe_a_success_message_confirming_the_creation_of_the_followup_campaign() throws InterruptedException {
	campaigns.createfollowupcampaignvalidation();
}

@Then("The user should observe a success message confirming the prospects assigned to the campaign")
public void the__user_assigns_the_prospects_to_the_created_campaign_in_the_direct_import_page() throws InterruptedException {
	directimport.assigncampaignvalidation();
	
   
}

@When("The user creates a batch by selecting the campaign, choosing the message template, and adding the batch size")
public void t_he_user_assigns_the_prospects_to_the_created_campaign_in_the_direct_import_page() throws InterruptedException {
	batches.clickbatch();
	batches.Selectcamaign();
//	batches.createbatch("Test Automation Smoke");
	batches.createbatch("Karachi02");
   
}
@When("The user creates batch for followup by selecting the campaign, choosing the message template, and adding the batch size")
public void t_he_user_assigns_the_prospects_to_the_created_FollowUP_campaign_in_the_direct_import_page() throws InterruptedException {
	batches.clickbatch();
	batches.Selectcamaign();
	batches.createbatch("QA followup message");
   
}

@When("The user Create New Follow Up Campaign in the Campaigns page")
public void  createfollowingupcampaign() {
	campaigns.createfollowupcampaign();
}
@When("The user creates a batch by selecting the campaign, choosing the message template")
public void selectcamaign() throws InterruptedException {
	batches.clickbatch();
	batches.Selectcamaign();
}
@Then("The user should observe a timeout message")
public void timeountmsg() throws InterruptedException {
	batches.timeoutmessage();
}


@When("The user sends a message to the prospects who were added in the batch")
public void th_e_user_assigns_the_prospects_to_the_created_campaign_in_the_direct_import_page() throws InterruptedException {
	batches.sendmsg();
   
}

@Then("The user should observe a success message confirming the message send successfully")
public void the_user_should_observe_a_success_message_confirming_the_message_send_successfully() throws InterruptedException {

	
}
@When("The user click the create new button in the Templates page")
public void the_user_click_the_create_new_button_in_the_templates_page() throws InterruptedException {
	templates.createnewinitialtempletes();
	
}
@When("The user enters the Template Name as {string} and selects the Template Type as {string}")
public void the_user_enters_the_and_selects_the(String name, String type) {
	templates.givenameandtype(name,type);
}
@When("The user enters all the {string} messages")
public void the_user_enters_all_the_messages(String name) {
	templates.setinitailtempleatemsg(name);
}
@When("The user saves the message templates")
public void the_user_saves_the_created_inital_message_templates() {
	templates.savetemplate();
}
@Then("The user should observe a success message confirming the message templates created successfully")
public void the_user_should_observe_a_success_message_confirming_the_inital_message_templates_created_successfully() {
	templates.verifysuccessinitialandfollowtext();
}
@Then("The user logs out from the Zeitblast application")
public void the_user_logs_out_from_the_zeitblast_application() {
	ui.logout();
}	
@When("The user clicks the follow up message tab")
public void click_follow_up() {
	templates.clickfollowuptab();
}
	
@When("The user clicks the quick reply message tab")
public void the_user_clicks_the_quick_reply_message_tab() {
	templates.quickreplytab();
}
@When("The user Create New Category as {string} in the Templates page")
public void the_user_create_new_category_as_in_the_templates_page(String category) {
	templates.createnewcategory(category);
}
@When("The user selects {string} from the list of categories")
public void the_user_selects_from_the_list_of_categories(String category) {
	templates.selectctegory(category);
}
@When("The user enters the title name as {string}")
public void the_user_enters_the_title_name_as(String title) {
	templates.entertitle(title);
}
@When("The user enters the {string} message")
public void the_user_enters_the_message(String message) {
	templates.entermessage(message);
}
@When("The user saves the quick reply message")
public void the_user_saves_the_quick_reply_message() {
	templates.savequickreply();
}
@Then("The user should observe a success message confirming the Quickreply message templates created successfully")
public void the_user_should_observe_a_success_message_confirming_the_Quickreply_message_templates_created_successfully() {
	templates.verifysuccessquicktext();
}

}
