package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.base.DataProviderD;
import com.bridgelabz.base.ReporterListener;
import com.bridgelabz.base.TestNgListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


//@Listeners(TestNgListener.class)
@Listeners(ReporterListener.class)
public class WebinarScreen extends BaseClass {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @Test(description = "Webinar Screen Automation", priority = 0, dataProvider = "dataProvider", dataProviderClass = DataProviderD.class)
    public void webinarScreen(String phoneNo, String emailId) throws InterruptedException {
        driver.get("https://bldev.bridgelabz.com/webinar");
        WebElement phoneText = driver.findElement(By.cssSelector("div.material-textfield"));
        System.out.println("text :"+phoneText.getText());

        boolean flag = driver.findElement(By.name("ContactNumber")).isDisplayed();
        if(flag)
        {
            driver.findElement(By.name("ContactNumber")).sendKeys(phoneNo);
        }
        Thread.sleep(500);

        driver.findElement(By.id("deftemail")).sendKeys(emailId);
        Thread.sleep(500);
//        List<WebElement> elements = driver.findElements(By.xpath("//div"));
//        System.out.println("No. of elements : "+elements.size());
//        for (int i=0; i<elements.size(); i++){
//            System.out.println("Element Text :" +elements.get(i).getAttribute("value"));
//        }
//
//        WebElement element = driver.findElement(By.name("passoutYear"));
//        Thread.sleep(1000);
//        element.sendKeys(Keys.PAGE_DOWN);
//        Thread.sleep(1000);
//        element.click();Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@value='2021']")).click();
//        Thread.sleep(1000);
    }

    @Test(dataProvider = "dataProvider",dataProviderClass = DataProviderD.class, priority = 1)
    public void phoneNo(String emailId) throws InterruptedException {
        driver.get("https://bldev.bridgelabz.com/webinar");
        driver.findElement(By.id("deftemail")).sendKeys(emailId);
        Thread.sleep(500);
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
