package com.dataProvider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	@DataProvider(name = "loginData",parallel = true)
    public static Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"visual_user", "secret_sauce"},
        };
    }

}
