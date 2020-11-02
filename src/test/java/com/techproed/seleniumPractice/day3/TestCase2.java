package com.techproed.seleniumPractice.day3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestCase2 {
// 1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
// 2. Click CLICK ME of JavaScript Alert
// 3. Get the pop up text
// 4. Verify the Message is “I am an alert box!“
// 5. Accept the pop up

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void alert1() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement clickMe = driver.findElement(By.id("button1"));
        clickMe.click();
        Alert popUp = driver.switchTo().alert();
        String popText = popUp.getText();
        String expectedText = "I am an alert box!";
        Assert.assertEquals(popText,expectedText);
        Thread.sleep(2000);
        popUp.accept();
    }

// Write these code in test case 4 class
// 1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
// 2. Click CLICK ME of JavaScript Confirm Box
// 3. Get the pop up text
// 4. Verify the Message is “Press a button“ (the message is wrong but I want to complete my test case)
// 5. Dismiss the pop up
// 6. Verify the “You pressed Cancel!” is displayed
// 7. Use the dependsOnMethods according to testCase4

    @Test(dependsOnMethods = "alert1")
    public void alert2(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement clickMe = driver.findElement(By.id("button4"));
        clickMe.click();
        String actualPopText = driver.switchTo().alert().getText();
        String expectedPopText = "Press a button!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualPopText,expectedPopText);
        driver.switchTo().alert().dismiss();
        WebElement message = driver.findElement(By.id("confirm-alert-text"));
        String actualMessage = message.getText();
        String expectedMessage = "You pressed Cancel!";
        Assert.assertEquals(actualMessage,expectedMessage);
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

