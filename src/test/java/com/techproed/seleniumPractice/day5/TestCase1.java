package com.techproed.seleniumPractice.day5;

import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCase1 extends TestBaseCross {
//1.Go to http://webdriveruniversity.com/
// 2.Go down to Login Portal
//3.Click the Login Portal
//4.Go to second windows
//5.Fill the username and password
//6.Click the login button
//7.Print the popup text
//Accept the popup

    @Test
    public void test1() {
        driver.get("http://webdriveruniversity.com/");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement login = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        login.click();
        Set<String> allWindows = driver.getWindowHandles();
        String firstWindow = driver.getWindowHandle();
        for (String tap : allWindows) {
            if (!tap.equals(firstWindow)) {
                driver.switchTo().window(tap);
            }
        }
        WebElement userName = driver.findElement(By.id("text"));
        userName.sendKeys("Text");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
}
