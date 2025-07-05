package com.utilities;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	    public static WebDriver getDriver() {
	        return tlDriver.get();
	    }

	    @BeforeMethod
	    public void setUp() {
	        Properties prop = utilities.loadProperties();
	        String browserName = prop.getProperty("browser");

	        WebDriver driver = null;

	        if (browserName.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } else {
	            throw new RuntimeException("Unsupported browser: " + browserName);
	        }

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	        driver.manage().window().maximize();
	        driver.get(prop.getProperty("url"));

	        // Set driver to ThreadLocal
	        tlDriver.set(driver);

	        
	    }
	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	    }
	   
	}
