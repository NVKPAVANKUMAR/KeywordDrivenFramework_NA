package com.qa.hs.keyword.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author NaveenKhunteta
 */
public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver init_driver(String browserName) {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (prop.getProperty("headless").equals("yes")) {
                //headless mode:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public Properties init_properties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\pavan.nemalikanti\\IdeaProjects\\Keyword-Driven-Web-UI-Framework\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
