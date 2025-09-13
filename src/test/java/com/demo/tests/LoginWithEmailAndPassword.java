package com.demo.tests;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;

import com.demo.base.Base;
import com.demo.pages.LoginPage;

public class LoginWithEmailAndPassword extends Base 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		Base.initializeDriver("edge");
		LoginPage loginPage = new LoginPage(Base.driver);

		loginPage.navigateToLoginPage();
		loginPage.loginWith("standard_user", "secret_sauce");
	}

}
