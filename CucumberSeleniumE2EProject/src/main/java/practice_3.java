import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice_3 {
	@Test
	public void practice_3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.airbnb.co.in/india/stays");
		WebElement searchbtn=driver.findElement(By.cssSelector("a[class='igy44l dir dir-ltr']"));
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(searchbtn).build().perform();
		searchbtn.click();
		Thread.sleep(Duration.ofSeconds(2));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	}

}
