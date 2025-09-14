package com.demo.tests;
import org.testng.annotations.Test;

import com.demo.base.Base;
import com.demo.pages.LoginPage;

public class LoginWithEmailAndPassword extends Base {

	@Test
	public void verifyValidLogin() {
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);

		loginPage.navigateToLoginPage();
		loginPage.loginWith("standard_user", "secret_sauce");
	}

}
