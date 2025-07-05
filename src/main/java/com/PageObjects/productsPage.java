package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;
import com.utilities.utilities;

public class productsPage extends BaseClass{
	
	@FindBy(xpath = "//div/button[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement addToCartitem;
	
	@FindBy(xpath = "//a/span[@class=\"shopping_cart_badge\"]")
	WebElement cartCount;
	
	@FindBy(xpath ="//div/a[@class=\"shopping_cart_link\"]")
	WebElement cartItem;
	
	@FindBy(xpath = "//div/button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
	WebElement clickCartItem;
	
	public productsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddtoCart() {
		utilities.waitForClickable(addToCartitem, 10);
		addToCartitem.click();
	}
	
	public String getCartCount() {
		return cartCount.getText();
	}
	
	public void clickCarticon() {
		cartItem.click();
		
	}
	
	public void addItemToCart() {
		utilities.scrollToElement(clickCartItem);
		utilities.clickElement(clickCartItem);
	}
	
	public String getPageTitle() {
		return getDriver().getTitle();
		
	}
	

}
