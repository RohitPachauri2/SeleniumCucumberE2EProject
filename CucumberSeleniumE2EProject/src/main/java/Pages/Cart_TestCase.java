package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cart_TestCase {
	
	WebDriver driver;
	
	public Cart_TestCase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="div[class='choose']>ul>li:nth-child(1)>a") WebElement viewproduct;
	@FindBy(css="button[class='btn btn-default cart']") WebElement Addtocart;
	@FindBy(css="button[class='btn btn-success close-modal btn-block']") WebElement continueshopping;
	@FindBy(css="div[class='shop-menu pull-right']>ul>li:nth-child(4)>a") WebElement logoutbutton;
	@FindBy(css="div[class='shop-menu pull-right']>ul>li:nth-child(3)") WebElement cartbutton;
	@FindBy(css="td[class='cart_description']>h4>a") WebElement elementname;
	public void addtocart() throws InterruptedException{
		Thread.sleep(2000);
		viewproduct.click();
		Thread.sleep(2000);
		Addtocart.click();
		Thread.sleep(2000);
		continueshopping.click();
		
	}
	public void loggingout() throws InterruptedException{
		Thread.sleep(2000);
		logoutbutton.click();
		Thread.sleep(2000);
	}
	public void clickoncartbutton()throws InterruptedException{
		Thread.sleep(2000);
		cartbutton.click();
		Thread.sleep(2000);
	}
	public String getelementname() throws InterruptedException{
		String name=elementname.getText();
		return name;
	}
	
}
