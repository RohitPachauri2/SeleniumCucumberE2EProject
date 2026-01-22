package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.Cart_TestCase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartTestCase {
Cart_TestCase ct;
WebDriver driver=DriverFactory.get_driver();
@Then("add the first product in cart")
public void add_the_first_product_in_cart() throws InterruptedException {
    ct=new Cart_TestCase(driver);
    ct.addtocart();
}

@Then("click on logout")
public void click_on_logout() throws InterruptedException {
   ct.loggingout();
}



@Then("clicks on cart button and verify the element is visible")
public void clicks_on_cart_button_and_verify_the_element_is_visible() throws InterruptedException {
    ct.clickoncartbutton();
    System.out.println("Element name is: "+ct.getelementname());
}
}
