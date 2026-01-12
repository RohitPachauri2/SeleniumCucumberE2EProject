package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Product {
	WebDriver driver;

	public Search_Product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='shop-menu pull-right']>ul>li:nth-child(2)>a")
	WebElement product_link;
	@FindBy(id = "search_product")
	WebElement searchbox;
	@FindBy(css="i[class='fa fa-search']")
	WebElement searchbutton;
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']//div//div//div//div//p")
	WebElement elementsnames;

	public void clickproductlink() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2));
		product_link.click();
	}
	
	public void searchproduct(String value) throws InterruptedException{
		Thread.sleep(Duration.ofSeconds(2));
		searchbox.sendKeys(value);
//		searchbox.sendKeys(Keys.ENTER);
		searchbutton.click();
	}
	
	public WebElement allproductelementsname() throws InterruptedException{
		Thread.sleep(Duration.ofSeconds(2));
		return elementsnames;
	}

}
