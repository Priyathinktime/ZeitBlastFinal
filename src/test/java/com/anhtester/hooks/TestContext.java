package com.anhtester.hooks;

import java.time.Duration;

import javax.xml.transform.Templates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.driver.TargetFactory;
import com.anhtester.projects.website.Zeitblast.pages.BatchesPage;
import com.anhtester.projects.website.Zeitblast.pages.CampaignsPage;
import com.anhtester.projects.website.Zeitblast.pages.DashboardPage;
import com.anhtester.projects.website.Zeitblast.pages.DirectImportPage;
import com.anhtester.projects.website.Zeitblast.pages.DripAutomationsPage;
import com.anhtester.projects.website.Zeitblast.pages.InboxPage;
import com.anhtester.projects.website.Zeitblast.pages.Linux_Server;
import com.anhtester.projects.website.Zeitblast.pages.Mongo_DB;
import com.anhtester.projects.website.Zeitblast.pages.SettingsPage;
import com.anhtester.projects.website.Zeitblast.pages.TemplatesPage;
import com.anhtester.projects.website.Zeitblast.pages.ZeitblastAPI;
import com.anhtester.projects.website.Zeitblast.pages.ZeitblastUI;
import com.anhtester.utils.LogUtils;

public class TestContext {

	private WebDriver driver;

	public TestContext() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = ThreadGuard.protect(new TargetFactory().createInstance());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.WAIT_IMPLICIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		DriverManager.setDriver(driver);
		LogUtils.info("Driver in TestContext: " + getDriver());
	}

	private Mongo_DB mongoDB;
	private Linux_Server server;
	private	ZeitblastUI ui;
	private ZeitblastAPI api;
	private DashboardPage dashboardpage;
	private InboxPage inbox;
	private  DirectImportPage directimport;
	private CampaignsPage campaigns;
	private BatchesPage batches;
	private SettingsPage settings;
	private TemplatesPage templates;
	private DripAutomationsPage dripautomation;
	
	public ZeitblastAPI getAPI() {
		if (api == null) {
			api = new ZeitblastAPI();
		}
		return api;
	}
	
	public TemplatesPage getTemplatesPage() {
		if (templates == null) {
			templates = new TemplatesPage();
		}
		return templates;
	}
	
	public InboxPage getInboxPage() {
		if (inbox == null) {
			inbox = new InboxPage();
		}
		return inbox;
	}
	
	public SettingsPage getSettingsPage() {
		if (settings == null) {
			settings = new SettingsPage();
		}
		return settings;
	}
	
	public BatchesPage getBatchesPage() {
		if (batches == null) {
			batches = new BatchesPage();
		}
		return batches;
	}
	
	public CampaignsPage getCampaignsPage() {
		if (campaigns == null) {
			campaigns = new CampaignsPage();
		}
		return campaigns;
	}
	
	public DirectImportPage getDirectImportPage() {
		if (directimport == null) {
			directimport = new DirectImportPage();
		}
		return directimport;
	}
	
	
	
	public Mongo_DB getMongoDB() {
		if (mongoDB == null) {
			mongoDB = new Mongo_DB();
		}
		return mongoDB;
	}

	public Linux_Server getServer() {
		if (server == null) {
			server = new Linux_Server();
		}
		return server;
	}
	public ZeitblastUI getUI() {
		if (ui == null) {
			ui = new ZeitblastUI();
		}
		return ui;
	}
	public DashboardPage getDashboardPage() {
		if (dashboardpage == null) {
			dashboardpage = new DashboardPage();
		}
		return dashboardpage;
	}

	public DripAutomationsPage getDripAutomationsPage() {
		if (dripautomation == null) {
			dripautomation = new DripAutomationsPage();
		}
		return dripautomation;
	}
	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}

}
