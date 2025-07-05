package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;

public class loginPageObj extends BaseClass {
	
WebDriver driver;
	@FindBy(id = "user-name")
	WebElement usernameInput;

	@FindBy(id = "password")
	WebElement passwordInput;

	@FindBy(id = "login-button")
	WebElement loginButton;

	public loginPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterUserNameWithJs(String userName) {
		//utilities.sendTextByJs(driver, usernameInput, userName);
		usernameInput.sendKeys(userName);
	}

	public void enterPasswordWithJs(String password) {
		//utilities.sendTextByJs(driver, passwordInput, password);
		passwordInput.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void LoginAs(String user, String pass) {
		enterUserNameWithJs(user);
		enterPasswordWithJs(pass);
		clickLoginButton();

	}
}
	
	