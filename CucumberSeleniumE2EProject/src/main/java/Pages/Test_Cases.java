package Pages;

import java.time.Duration;
import java.util.*;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Cases {
	WebDriver driver;
	WebDriverWait wait;

	public Test_Cases(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body")
	WebElement body;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[5]//a")
	WebElement testcasehyperlink;

	@FindBy(xpath = "//div[@class='container']//div[@class='panel-group']//a//u")WebElement elements;
	

	public boolean homepagesuccess() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(body));
		return body.isDisplayed();
	}
	
	public void clickonhyperlink() {
		wait.until(ExpectedConditions.visibilityOf(testcasehyperlink));
		testcasehyperlink.click();
	}
	public String testcasetitle() {
		String title=driver.getTitle();
		return title;
	}
	public List<WebElement> alltestcases(){
		wait.until(ExpectedConditions.visibilityOfAllElements
				(driver.findElements(By.xpath("//div[@class='container']//div[@class='panel-group']//a//u"))));
		List<WebElement> allelements=driver.findElements(By.xpath("//div[@class='container']//div[@class='panel-group']//a//u"));
		return allelements;
		
		
	}
	

}
