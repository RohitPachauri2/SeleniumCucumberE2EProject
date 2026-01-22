package Hooks;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import Factory.DriverFactory;
import Utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHook{
	private DriverFactory df;
	private WebDriver driver;
	private ConfigReader cr;
	Properties prop;
	
	@Before(order = 0)
	public void getproperty() throws IOException {
		cr=new ConfigReader();
		prop=cr.init_prop();
	}
	@Before(order = 1)
	public void launch_browser() {
		String target_browser=prop.getProperty("browser");
		df=new DriverFactory();
		driver=df.init_driver(target_browser);
	}
	
	
	@After(order =0)
	public void quit_browser() {
		driver.quit();
	}
	
	@After(order =1)
	public void tear_down(Scenario sc) {
		if(sc.isFailed()) {
			//take screenshot
			
			String screenshotname=sc.getName().replaceAll(" ", "_");
			TakesScreenshot tk=(TakesScreenshot)driver;
			byte[] sourcepath=tk.getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcepath, "image/png", screenshotname);
			// Take screenshot
		    File src = tk.getScreenshotAs(OutputType.FILE);

		    // Create timestamp (Windows-safe)
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		    String timestamp = LocalDateTime.now().format(formatter);

		    // Ensure screenshots folder exists
		    File dest = new File("screenshots/"+sc.getName()+timestamp + ".png");
		    dest.getParentFile().mkdirs();

		    // Save screenshot
		    try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
	}
	
	
	
	
}
