package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;
import com.utilities.utilities;

public class cartPage extends BaseClass {
	@FindBy(xpath = "//button[@id=\"checkout\"]")
	WebElement checkoutButton;


public cartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);

} 

public void clickCheckoutButton() {
    checkoutButton.click();
}
}
