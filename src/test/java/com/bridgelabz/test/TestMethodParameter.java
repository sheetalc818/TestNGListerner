package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMethodParameter extends BaseClass {
    @Test
    @Parameters({"phoneNo","emailId"})
    public void Test(String phoneNo, String emailId) throws InterruptedException {
        driver.get("https://bldev.bridgelabz.com/webinar");
        driver.findElement(By.name("ContactNumber")).sendKeys(phoneNo);
        Thread.sleep(500);
        driver.findElement(By.id("deftemail")).sendKeys(emailId);
        Thread.sleep(500);
    }
}
