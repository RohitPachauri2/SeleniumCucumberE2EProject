package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;
import Factory.DriverFactory;
import Pages.Test_Cases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCases {
	Test_Cases tp;
	WebDriver driver = DriverFactory.get_driver();
	WebDriverWait wait;

	@Given("home page is visible successfully")
	public void home_page_is_visible_successfully() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		tp = new Test_Cases(driver);
		Assert.assertEquals(true, tp.homepagesuccess());
	}

	@When("clicks on test cases hyperlink")
	public void clicks_on_test_cases_hyperlink() {
		tp.clickonhyperlink();
	}

	@Then("user is navigated to test cases page successfully")
	public void user_is_navigated_to_test_cases_page_successfully() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(5));
		System.out.println(tp.testcasetitle());
		Assert.assertTrue(tp.testcasetitle().contains("Test Cases"));
	}

	@Then("user is able to fetch all the test cases in console")
	public void user_is_able_to_fetch_all_the_test_cases_in_console() {
		int count=0;
		System.out.println("All the test_cases are utputted below:--------------------");
		List<WebElement> allelements=tp.alltestcases();
		for(WebElement element:allelements) {
			count+=1;
			System.out.println(element.getText());
		}
		Assert.assertEquals(count, 27);
	}
}
