package com.demo.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver = null;

	public static void initializeDriver(String browser) {
		switch (browser) {

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Base.driver= new FirefoxDriver();
			break;
			
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Base.driver= new ChromeDriver();
			break;
			
		default:
			System.out.println("Invalid browser choice");
			break;

		}
		Base.driver.manage().window().maximize();
		
	}
	
	public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

}
}
