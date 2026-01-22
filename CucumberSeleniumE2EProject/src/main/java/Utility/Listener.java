package Utility;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;

import Factory.DriverFactory;	
public class Listener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result+" failed");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result+" passed");
	}
	
	
}
