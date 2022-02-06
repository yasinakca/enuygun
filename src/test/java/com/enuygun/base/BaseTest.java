package com.enuygun.base;

import com.enuygun.Log4j;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        Log4j.info("Browser running...");
    }

    @After
    public void tearDown() {
        driver.quit();
        Log4j.info("Driver quitting...");
    }
}
