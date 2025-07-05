package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebgetDriver()Wait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class utilities extends BaseClass {

	public static Properties loadProperties() {
		Properties prop = new Properties();
		String PROP_FILE_PATH = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources"
				+ File.separator + "testData.properties";
		try (FileInputStream fis = new FileInputStream(PROP_FILE_PATH)) {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

//Assertion method
	public static void verifyTitle(String actualTitle, String expectedTitle) {
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
	}
	
	public static void verifyCompletedMsg(String actual, String expected, String expectedMsg) {
		Assert.assertEquals(actual,expected, expectedMsg);
		System.out.println("Validation passed:" + expectedMsg);
	}

	public static void verifyElementDisplayed(WebElement element, String elementName) {
		Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed on the page");
	}

	public static void verifyElementEnabled(WebElement element, String elementName) {
		Assert.assertTrue(element.isEnabled(), elementName + " is not enabled on the page");
	}

	public static void verifyElementSelected(WebElement element, String elementName) {
		Assert.assertTrue(element.isSelected(), elementName + " is not selected on the page");
	}

//Screenshot method
	public static String captureScreenshot(String testName) {
	    new File("test-output/screenshots").mkdirs(); // Ensure folder
	    File src = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
	    String path = "test-output/screenshots/" + testName + ".png";
	    try {
	        FileUtils.copyFile(src, new File(path));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return path;
	}


	

//javascript executor methods
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", element);
	}

	public static void clickElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", element);
	}

//explicit wait methods
	public static void waitForVisibility(WebElement element, int timeInSeconds) {
		WebDriverWait Wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(timeInSeconds));
		Wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickable(WebElement element, int timeInSeconds) {
		WebDriverWait Wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(timeInSeconds));
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//Actions methods	
	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(element).perform();

	}





	
	
}


