package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.BaseClass;
import com.utilities.utilities;

public class checkoutOverviewPage extends BaseClass{
//	@FindBy(xpath = "//*[@data-test=\"finish\"]")
//	WebElement finishButton;
//	
	public checkoutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickFinishButton() throws InterruptedException {
		


		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test=\"finish\"]")));

		element.click();


	}
	 
	
}
