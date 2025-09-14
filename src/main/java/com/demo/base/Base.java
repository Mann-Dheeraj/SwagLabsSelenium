package com.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    public static WebDriver driver;

    public static void initializeDriver() {
        // Setup Firefox driver with WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Configure Firefox options for headless mode
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");              // run without GUI
        options.addArguments("--no-sandbox");            // needed in Docker/CI
        options.addArguments("--disable-dev-shm-usage"); // prevents crashes in containers

        // Launch Firefox
        driver = new FirefoxDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
