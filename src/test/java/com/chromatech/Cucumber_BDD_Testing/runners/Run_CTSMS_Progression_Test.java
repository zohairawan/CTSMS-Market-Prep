package com.chromatech.Cucumber_BDD_Testing.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"html:target/cucumber-reports/cucumber-html-report.html", "json:target/cucumber.json",
        "rerun:target/failed.txt",
        "pretty"},
        features = "src/test/resources/features",
        glue = {"com.chromatech.Cucumber_BDD_Testing.stepDefinitions", "hooks"},
        tags = "@Progression",
        dryRun = false
//        dryRun = true
)
public class Run_CTSMS_Progression_Test extends AbstractTestNGCucumberTests {
}