package com.anhtester.projects.website.Zeitblast.stepdefinitions.API;

import java.io.IOException;

import com.anhtester.hooks.TestContext;

import com.anhtester.projects.website.Zeitblast.pages.ZeitblastAPI;

import io.cucumber.java.en.Given;

public class API {
	ZeitblastAPI api;
	 public API(TestContext testContext) {
	        api= testContext.getAPI();
	    }
	@Given("the Send Message API is triggered for {int} leads for phone no {int}")
	public void the_send_message_api_is_triggered_for_leads_for_phone_no(Integer int1, Integer int2) throws IOException, InterruptedException {
		api.sendmsgAPI(int2);
	}

@Given("the Delivery API is triggered for phone no {int}")
public void the_delivery_api_is_triggered_for_phone_no(Integer int1) throws IOException, InterruptedException {
	api.APIDelevirey(int1);
}
 @Given("the Send Message API is triggered for the leads for phone no {string}")
  public void sendmsgforno(String phonenum) throws InterruptedException {
	 Thread.sleep(50000);
	api.sendmsgforparticularno(phonenum);
}

}
