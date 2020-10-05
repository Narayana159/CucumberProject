package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	
	@CucumberOptions(
			features = "src/test/java/Features", 
			glue = { "stepDefinitions" }, 
			tags = "@JobBoard_activity or @HRM_activity or @CRM_activity",
			monochrome=true,
			strict=true,
			plugin={"html:target/test-reports/html/html_Report"}
	)

public class ActivitiesRunner {

}
