package com.bridgelabz.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BaseClass {
    public static WebDriver driver = null;
    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String Browser){
      if (Browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
     }else if(Browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    public static void takeScreenshot(String testName) throws IOException {
        Date date = new Date();
        TakesScreenshot shot = (TakesScreenshot) driver;
        File srcFile = shot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot/"+testName+date.getTime()+".png");
        FileUtils.copyFile(srcFile,destFile);
    }
}
