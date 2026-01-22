package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Factory.DriverFactory;
import Pages.Search_Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchProduct extends DriverFactory{
	WebDriver driver=DriverFactory.get_driver();
	Search_Product sp;
	@When("Click on Products button")
	public void click_on_products_button() throws InterruptedException {
		sp=new Search_Product(driver);
		sp.clickproductlink();
		Thread.sleep(Duration.ofSeconds(5));
		
	}

	@Then("user is navigated to ALL PRODUCTS page successfully")
	public void user_is_navigated_to_all_products_page_successfully() {
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/products"));
	}

	@Then("Enter {string} in search input and click search button")
	public void enter_in_search_input_and_click_search_button(String string) throws InterruptedException {
		
		sp.searchproduct(string);
		Thread.sleep(2000);
	}

	@Then("{string} is visible")
	public void is_visible(String string) {
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains(string));
	}

	@Then("all the products related to search are visible")
	public void all_the_products_related_to_search_are_visible() throws InterruptedException {
		List<WebElement>allelements=driver.findElements(By.cssSelector("div[class='features_items']>div[class='col-sm-4']>div>div>div[class='productinfo text-center']>p"));
		System.out.println("All elements:--------");
		for(WebElement element :allelements) {
			System.out.println(element.getText());
		}
	}
}
