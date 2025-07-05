package firstproject;

import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjects.cartPage;
import com.PageObjects.checkoutComplete;
import com.PageObjects.checkoutOverviewPage;
import com.PageObjects.checkoutPage;
import com.PageObjects.loginPageObj;
import com.PageObjects.productsPage;
import com.dataProvider.LoginDataProvider;
import com.utilities.BaseClass;
import com.utilities.utilities;

@Listeners(com.utilities.ExtentTestListener.class)

public class LoginPage extends BaseClass {
	//loginPage
	
	
    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void testLogin(String userName, String password) throws InterruptedException {

    	//@Test  	
    	//public void testLogin() throws InterruptedException {
	    loginPageObj loginPage = new loginPageObj(getDriver());  	    
	    loginPage.LoginAs(userName, password);
	    
//		Properties prop = utilities.loadProperties();       
//		String userName = prop.getProperty("user");
//		String password = prop.getProperty("pass");
//		loginPage.enterUserNameWithJs(userName);           
//		loginPage.enterPasswordWithJs(password);          
//		loginPage.clickLoginButton();                   
//    
    
//ProductsPage
    // @Test()
     //public void testProducts() throws InterruptedException {
     	    	
		productsPage product = new productsPage(getDriver());
		product.clickAddtoCart();
		product.addItemToCart();
		String actualresult = product.getCartCount();
		utilities.verifyTitle(actualresult, "2");
		System.out.println("Assertion is success " + actualresult);
		product.clickCarticon();
    	
      

 //CartPage
	//@Test()
	//public void testCartPage() throws InterruptedException {
		cartPage cart = new cartPage(getDriver());
		cart.clickCheckoutButton();
    	

//checkoutPage
  // @Test()
   //public void testCheckout() throws InterruptedException {
		checkoutPage checkout = new checkoutPage(getDriver());
		Properties prop1 = utilities.loadProperties();
		String firName = prop1.getProperty("firstname");
		String laName = prop1.getProperty("lastname");
		String zipCode = prop1.getProperty("zip");
		checkout.fillCheckoutDetails(firName, laName, zipCode);
    	
    
    
  //checkoutOverviewPage
  // @Test()
  // public void testOverview() throws InterruptedException {
   
		checkoutOverviewPage overview = new checkoutOverviewPage(getDriver());
		overview.clickFinishButton();

   
    
  //checkoutCompletePage
	//@Test()
	//public void testCheckoutComplete() throws InterruptedException {
		checkoutComplete completed = new checkoutComplete(getDriver());
		String actualMsg = completed.getCompleteMessage();
		String expectedMsg = "Thank you for your order!";
		utilities.verifyCompletedMsg(actualMsg, expectedMsg, "Order completion message does not match expected.");

	  		
		
    	}
		
		
    }	

	


