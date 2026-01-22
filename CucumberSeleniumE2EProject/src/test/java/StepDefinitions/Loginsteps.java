package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsteps {

	WebDriver driver = DriverFactory.get_driver();
	LoginPage lp = new LoginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	Actions action;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		action = new Actions(driver);

		driver.get("https://automationexercise.com/");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));

//		lp.clickonsiginlink();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("email"))));
//		lp.enterusername(null);
//		lp.enterpass(null);
//		lp.clickonsubmit();

	}
	@Given("user is on the link")
	public void user_is_on_the_link() {
	    System.out.println("user is on the link");
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		Assert.assertTrue(driver.getTitle().contains(string));
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String usr) throws InterruptedException {
		Thread.sleep(2000);
		lp.clickonsiginlink();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("email"))));
		lp.enterusername(usr);
		Thread.sleep(2000);
	}
	
	@Then("user enters the given username {string}")
	public void user_enters_the_given_username(String string) throws InterruptedException {
		Thread.sleep(2000);
		lp.enterusername(string);
		Thread.sleep(2000);
	}

	

	@When("user enters password {string}")
	public void user_enters_password(String pass) throws InterruptedException {
		lp.enterpass(pass);
		Thread.sleep(2000);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		lp.clickonsubmit();
		Thread.sleep(2000);
	}
	@Then("user gets the page title")
	public void user_gets_the_page_title() {
		System.out.println(lp.gettitle());
	}


	@Then("title of page should be {string}")
	public void title_of_page_should_be(String actualtitle) {
		Assert.assertEquals(driver.getTitle(), actualtitle);
		System.out.println(lp.getsigninbtntext());
		Assert.assertEquals(lp.getsigninbtntext(), "Logout");
	}

}
