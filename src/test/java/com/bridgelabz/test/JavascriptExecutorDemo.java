package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavascriptExecutorDemo extends BaseClass {
    @Test(description = "Demo of the javascriptExecutor")
    public void demo() throws InterruptedException {
        driver.get("https://www.guru99.com/api-testing.html");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.println("execute script : " + executor.executeScript("return window.length"));

        int noOfFrames = Integer.parseInt(executor.executeScript("return window.length").toString());
        System.out.println("No of frames : "+noOfFrames);

        executor.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(500);
    }
}
