package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue = {
		"stepDefinations" }, tags = {"@AddCustomer or @CreateUser or @Authentication or @CreateOrganisation"})
public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
	//tags = {"@VerfiyTokenEmail"}
	
	//tags = {"@AddCustomer or @CreateUser or @Authentication or @CreateOrganisation"}
	
}
