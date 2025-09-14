package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.base.Base;
import com.demo.pages.LoginPage;

public class LoginDataDrivenTest extends Base {
    @DataProvider(name = "loginDetails")
    public Object[][] getLoginData() {

        return new Object[][] { { "standard_user", "secret_sauce", true },
                { "locked_out_user", "secret_sauce", false },
                { "problem_user", "secret_sauce", true },
                { "performance_glitch_user", "secret_sauce", true },
                { "error_user", "secret_sauce", true },
                { "visual_user", "secret_sauce", true }
        };
    }

    @Test(dataProvider = "loginDetails")
    public void verifyLoginForDifferentUsers(String email, String password, boolean canLogin) {
        // System.out.println(email+password);
        initializeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();
        loginPage.loginWith(email, password);
        String homePageURL = "https://www.saucedemo.com/inventory.html";
        String loginPageURL = "https://www.saucedemo.com/";

        if (canLogin == true) {
            Assert.assertEquals(driver.getCurrentUrl(), homePageURL, "Wrong URL");
        } else {
            Assert.assertEquals(driver.getCurrentUrl(), loginPageURL, "Wrong URL");
        }

    }
}