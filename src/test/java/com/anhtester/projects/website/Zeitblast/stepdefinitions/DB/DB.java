package com.anhtester.projects.website.Zeitblast.stepdefinitions.DB;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.hooks.TestContext;
import com.anhtester.projects.website.Zeitblast.pages.Mongo_DB;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DB {

	Mongo_DB mongoDB;

	public DB(TestContext testContext) {
		mongoDB = testContext.getMongoDB();
	}

	@Given("the user initializes the MongoDB connection")
	public void mongo_db_is_initialized() throws InterruptedException {
		mongoDB.initializeMongoDB();
	}

	@When("fetching the required data for phone {int}")
	public void fetching_the_required_data_for_phone_no(Integer int1) throws InterruptedException, IOException {
		int a = int1;
		switch (a) {
		case 1:
			mongoDB.fetchdatafromDB("phone1", "bandwithsendid1","Leadsdata1.xlsx");
			break;
		case 2:
			mongoDB.fetchdatafromDB("phone2", "bandwithsendid2","Leadsdata2.xlsx");
			                                   
			break;
		case 3:
			mongoDB.fetchdatafromDB("phone3", "bandwithsendid3","Leadsdata3.xlsx");
			break;
		default:

			System.out.println("Invalid value of 'a': " + a);
			break;
		}
	}



	@When("the user deletes all existing documents from the collection")
	public void deleting_the_mongo_db_documents() {
		mongoDB.deleteMongoDBDocuments("batches");
		mongoDB.deleteMongoDBDocuments("compaigns");
		mongoDB.deleteMongoDBDocuments("csvdatas");
		mongoDB.deleteMongoDBDocuments("directimports");
		mongoDB.deleteMongoDBDocuments("inboxes");
		mongoDB.deleteMongoDBDocuments("markets");
	}

	@When("assigning phone {int} leads as verified")
	public void assigning_leads_as_verified(Integer a) throws InterruptedException, IOException {
		switch (a) {
		case 1:
			mongoDB.updateverified("Leadsdata1.xlsx",1,FrameworkConstants.No_of_Verified_1);
			break;
		case 2:
			mongoDB.updateverified("Leadsdata2.xlsx",2,FrameworkConstants.No_of_Verified_2);	
			break;
//		case 3:
//			mongoDB.updateverified("Leadsdata3.xlsx",3);	
//			break;
		}

	}
	@Then("no documents should exist in the collection")
	public void verifyNoDocumentsExist() {
		   boolean isEmpty =mongoDB.isCollectionEmpty("batches");
		    Assert.assertTrue(isEmpty, "batches has no data");
		    boolean isEmpty1 =mongoDB.isCollectionEmpty("compaigns");
		    Assert.assertTrue(isEmpty1, "batches has no data");
		    boolean isEmpty2 =mongoDB.isCollectionEmpty("csvdatas");
		    Assert.assertTrue(isEmpty2, "batches has no data");
		    boolean isEmpty3 =mongoDB.isCollectionEmpty("directimports");
		    Assert.assertTrue(isEmpty3, "batches has no data");
		    boolean isEmpty4 =mongoDB.isCollectionEmpty("inboxes");
		    Assert.assertTrue(isEmpty4, "batches has no data");
		    boolean isEmpty5 =mongoDB.isCollectionEmpty("markets");
		    Assert.assertTrue(isEmpty5, "batches has no data");
		 
		    
	}
    @When("the user deletes documents with {string} equal to {string} from the {string} collection")
    public void deleteDocuments(String field, String value, String collectionName) {
    		mongoDB.deleteDocuments(field, value, collectionName);
    }

    @Then("those documents with {string} equal to {string} should no longer exist in the {string} collection")
    public void verifyDocumentsDeleted(String field, String value, String collectionName) {
    	 boolean isEmpty =mongoDB.isparticulardocumentdeleted(field, value, collectionName);
    	 Assert.assertTrue(isEmpty, "Documents has no data");
    }

	@Then("the user closes the MongoDB connection")
	public void MongoDBClose() {
		mongoDB.closeMongoClient();
	}
	
	@Then("delete the excelsheet {int}")
	public void deletesheetdata(Integer a) {
		switch (a) {
		case 1:
			mongoDB.exceldatadeleted("Leadsdata1.xlsx");
			break;
		case 2:
			mongoDB.exceldatadeleted("Leadsdata2.xlsx");
			break;
		case 3:
			mongoDB.exceldatadeleted("Leadsdata3.xlsx");
			break;
		}
		
	}
	public void verifydocumentdelete(String doc) {
	    boolean isEmpty =mongoDB.isCollectionEmpty(doc);
	    Assert.assertTrue(isEmpty, doc+" has no data");
	}
	@When("change the data in drip first automation for today")
	public void change_the_data_in_drip_first_automation_for_today() throws ParseException {
		mongoDB.isParticularDocumentChanged("to", "4010010", "inboxes",0);
		mongoDB.isParticularDocumentChanged("to", "4010009", "inboxes",0);
		mongoDB.isParticularDocumentChanged("to", "4010008", "inboxes",0);
	}
	@When("change the data in drip second automation for today")
	public void change_the_data_in_drip_automation_for_today() throws ParseException {
		mongoDB.isParticularDocumentChanged("to", "4010010", "inboxes",1);
		mongoDB.isParticularDocumentChanged("to", "4010009", "inboxes",1);
		mongoDB.isParticularDocumentChanged("to", "4010008", "inboxes",1);
	}
	@When("change the date in drip first automation for today")
	public void change_the_date_in_drip_first_automation_for_today() throws ParseException {
		mongoDB.isParticularDocumentChanged("to", "4010010", "inboxes",0);

	}
	@When("the user changes the value of initial message")
	public void change() {
		mongoDB.changetheintialmsg("name","Test Automation Smoke","initialandfollowtemplates");
	}
	@When("change the date in drip second automation for today")
	public void change_the_date_in_drip_automation_for_today() throws ParseException {
		mongoDB.isParticularDocumentChanged("to", "4010010", "inboxes",1);
	
	}
}
