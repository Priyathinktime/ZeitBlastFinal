 package com.anhtester.runners;

import com.anhtester.hooks.CucumberListener;
import com.anhtester.utils.EmailSendUtils;
import com.anhtester.utils.ZipUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/TC10_createcampaign.feature",
        glue = {"com.anhtester.projects.website.Zeitblast.stepdefinitions",
                "com.anhtester.hooks"},
        plugin = {"com.anhtester.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/LoginCMSTestRunner.html",
                "json:target/cucumber-reports/LoginCMSTestRunner.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        , monochrome = true,
        tags = "@createcampaign"
)

public class TC10_createcampaign_TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
        ZipUtils.zipReportFolder();
        EmailSendUtils.sendEmail(CucumberListener.count_totalTCs
                , CucumberListener.count_passedTCs
                , CucumberListener.count_failedTCs
                , CucumberListener.count_skippedTCs);
    }
}