package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.utilities;

public class checkoutPage {
	@FindBy(id="first-name")
	WebElement firstNameInput;
	
	@FindBy(id="last-name")
	WebElement lastNameInput;
	
	@FindBy(id="postal-code")
	WebElement postalCodeInput;
	
	@FindBy(css ="[data-test=\"continue\"]")
	WebElement continueButton;
	
	public checkoutPage(WebDriver driver) {
		 PageFactory.initElements(driver, this); // Uncomment if using PageFactory
	}
	
	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void enterPostalCode(String postalCode) {
		postalCodeInput.sendKeys(postalCode);
	}
	
	public void clickContinueButton() {
		utilities.waitForVisibility(continueButton,10);
        continueButton.click();
    }
	
	public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
		clickContinueButton();
	}

}
