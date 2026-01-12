package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Factory.DriverFactory;
import Pages.Contact_us;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contactus {
	WebDriver driver = DriverFactory.get_driver();
	Contact_us cu = new Contact_us(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	Actions action;

	@When("user clicks on Contact Us button")
	public void user_clicks_on_contact_us_button() throws InterruptedException {
		cu.clickoncontactbutton();
	}

	@When("user can see get in touch text")
	public void user_can_see_get_in_touch_text() throws InterruptedException {
		String text = cu.getintouchtext();
		Assert.assertEquals(text, "GET IN TOUCH");

	}

//	@Then("^user can write \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	@Then("user can write {string} {string} {string} and {string}")
	
	public void user_can_write_email_subject_and_message(String name, String email, String subj, String message)
			throws InterruptedException {

		cu.sendusernamesubjectmessage(name, email, subj, message);
	}

	@Then("user can upload a file")
	public void user_can_upload_a_file() {
		cu.clickonupload();
		System.out.println("successfull");
	}

	@Then("user can submit and click ok")
	public void user_can_submit_and_click_ok() throws InterruptedException {
		cu.clickonsubmit();
	}


	@Then("user can see success message")
	public void user_can_see_success_message() throws IOException, InterruptedException {

	    // Verify success message
		cu.suceessalert();

	    // Take screenshot
	    TakesScreenshot tk = (TakesScreenshot) driver;
	    File src = tk.getScreenshotAs(OutputType.FILE);

	    // Create timestamp (Windows-safe)
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
	    String timestamp = LocalDateTime.now().format(formatter);

	    // Ensure screenshots folder exists
	    File dest = new File("screenshots/success_message_" + timestamp + ".png");
	    dest.getParentFile().mkdirs();

	    // Save screenshot
	    FileUtils.copyFile(src, dest);
	}



	@Then("user can click home button to land on home page successfully")
	public void user_can_click_home_button_to_land_on_home_page_successfully() throws InterruptedException {
		Thread.sleep(2000);
		cu.clickonhomebutton();
	}
}