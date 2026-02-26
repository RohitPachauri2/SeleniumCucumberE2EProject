package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue= {"StepDefinitions","Hooks"},
		features= {"src/test/resources/Feature"},
		plugin= {"pretty","html:Reports/newtestrunner.html"},
//		dryRun=false,
		monochrome=true,
		tags="@test4"
		)

public class NewTestRunner extends AbstractTestNGCucumberTests{

	
}
