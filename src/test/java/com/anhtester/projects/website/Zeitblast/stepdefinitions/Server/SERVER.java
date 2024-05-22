package com.anhtester.projects.website.Zeitblast.stepdefinitions.Server;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.hooks.TestContext;
import com.anhtester.projects.website.Zeitblast.pages.Linux_Server;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SERVER {
	Linux_Server server;

	public SERVER(TestContext testContext) {
		server = testContext.getServer();
	}

	@Given("the user turns on the server using valid credentials")
	public void credentials_to_access_the_server() throws InterruptedException {
		server.InitiateServer();
	}

	@When("the user sets the time zone to UTC on the server")
	public void the_utc_timing_is_adjusted() throws InterruptedException {
		server.commandinserver("sudo timedatectl set-ntp 1");
		server.commandinserver("sudo timedatectl set-timezone UTC");
		server.commandinserver("sudo ntpdate -u pool.ntp.org");
		
	}

	@When("changing the EST timing to next day")
	public void changing_the_est_timing_after_24hours() throws InterruptedException {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);

		server.commandinserver("sudo timedatectl set-ntp 0");
		server.commandinserver("sudo timedatectl set-timezone America/New_York");
		String date = formatDate(tomorrow);
		server.commandinserver("sudo timedatectl set-time '" + date + " 08:00:00'");
		Thread.sleep(50000);
	
	}

	@When("changing the EST timing to day after next day")
	public void changing_the_est_timing_after_48hours() throws InterruptedException {
		LocalDate today = LocalDate.now();
		LocalDate dayaftertomorrow = today.plusDays(2);

		server.commandinserver("sudo timedatectl set-ntp 0");
		server.commandinserver("sudo timedatectl set-timezone America/New_York");
		String date = formatDate(dayaftertomorrow);
		server.commandinserver("sudo timedatectl set-time '" + date + " 08:00:00'");
		Thread.sleep(50000);
		
	}

	@When("the EST timing is adjusted for today")
	public void the_est_timing_is_adjusted() throws InterruptedException {
		LocalDate today = LocalDate.now();

		server.commandinserver("sudo timedatectl set-ntp 0");
//		server.commandinserver("sudo timedatectl set-timezone America/New_York");
		server.commandinserver("sudo timedatectl set-timezone "+FrameworkConstants.Time_Zone);
		String date = formatDate(today);
		server.commandinserver("sudo timedatectl set-time '" + date + " 08:00:00'");
//		FrameworkConstants
	
	
	}
	@When("changing the EST timing to next Week")
	public void nextweek() throws InterruptedException {
		LocalDate today = LocalDate.now();
		LocalDate nextweek = today.plusDays(7);

		server.commandinserver("sudo timedatectl set-ntp 0");
		server.commandinserver("sudo timedatectl set-timezone America/New_York");
		String date = formatDate(nextweek);
		server.commandinserver("sudo timedatectl set-time '" + date + " 08:00:00'");
		Thread.sleep(120000);
		
	}
	
	@When("the EST timing is adjusted for today night")
	public void the_est_timing_is_adjustedtonight() throws InterruptedException {
		LocalDate today = LocalDate.now();

		server.commandinserver("sudo timedatectl set-ntp 0");
		server.commandinserver("sudo timedatectl set-timezone America/New_York");
		String date = formatDate(today);
		server.commandinserver("sudo timedatectl set-time '" + date + " 22:00:00'");
	
	
	
	}

	@Then("the user turns off the server")
	public void serverclose() {
		server.CloseServer();
	}

	private static String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
}