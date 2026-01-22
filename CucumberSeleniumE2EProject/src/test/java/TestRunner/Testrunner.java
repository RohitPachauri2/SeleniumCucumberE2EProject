package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin= {"pretty","html:Reports/Cucumber.html","json:Reports/Cucumber.json"},
		features= {"src/test/resources/Feature"},
		glue= {"StepDefinitions","Hooks"},
		dryRun = false,
//		tags= "@test3 or @test1",
		tags="@test5"
		
		)

public class Testrunner extends AbstractTestNGCucumberTests {

}
