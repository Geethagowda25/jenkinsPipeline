package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;

public class checkoutComplete extends BaseClass {

	@FindBy(xpath = "//h2[text()=\"Thank you for your order!\"]")
	WebElement completeMsg;
	
	public checkoutComplete(WebDriver driver) {
		PageFactory.initElements(driver, this); // Uncomment if using PageFactory
	}
	
	public String getCompleteMessage() {
		return completeMsg.getText();
	}
}
