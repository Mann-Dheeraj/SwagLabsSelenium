package com.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    protected static WebDriver driver;

    // existing method — you can still call it manually
    public static void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        driver.manage().window().maximize();
    }

    // TestNG hooks
    @BeforeMethod
    public void setUp() {
        // Default browser → firefox (you can change later to chrome/edge/config file)
        initializeDriver("firefox");
    }

    // @AfterMethod
    // public void tearDown() {
    //     if (driver != null) {
    //         driver.quit();
    //         driver = null;
    //     }
    // }
}
