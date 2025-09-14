package com.demo.tests;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.base.Base;
import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;

public class AddMaxPriceProductToCart extends Base {

	@Test
	public void verifyAddToCartFunctionality() {
		LoginPage loginPage = new LoginPage(Base.driver);
		HomePage homePage = new HomePage(Base.driver);

		loginPage.navigateToLoginPage();
		String loginPageTitle = "Swag Labs";
		Assert.assertEquals(loginPageTitle, driver.getTitle(), "Title do not match");

		String homePageURL = "https://www.saucedemo.com/inventory.html";		
		loginPage.loginWith("standard_user", "secret_sauce");
		boolean isURLCorrect = (driver.getCurrentUrl().equals(homePageURL));
		Assert.assertTrue(isURLCorrect, "Incorrect URL");

		List<Double> allPrices = homePage.getAllItemPrices();
		double maxPrice = Collections.max(allPrices);
		homePage.cartButtonForIteWithPrice(maxPrice).click();
		String textOnCartAfterButtonAfterAddition = homePage.cartButtonForIteWithPrice(maxPrice).getText();
		Assert.assertEquals(textOnCartAfterButtonAfterAddition, "Remove", "Wrong Text");

		double minPrice = Collections.min(allPrices);
		homePage.cartButtonForIteWithPrice(minPrice).click();
		textOnCartAfterButtonAfterAddition = homePage.cartButtonForIteWithPrice(minPrice).getText();
		Assert.assertEquals(textOnCartAfterButtonAfterAddition, "Remove", "Wrong Text");
	}

}
