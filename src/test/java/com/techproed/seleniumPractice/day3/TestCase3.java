package com.techproed.seleniumPractice.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase3 {
// 1. Go to http://zero.webappsecurity.com/
// 2. Click Sign in button
// 3. Enter login ( “username”)
// 4. Enter wrong password (“password.”)
// 5. Click Sign in button
// 6. Go to Account Activity page
// 7.Select Brokerage from account drop down menu
// 8.Verify in the account dropdown menu Brokerage is selected
// 9.Verify the drop down menu is following { Savings, Checking, Savings, Loan, Credit Card, Brokerage}

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void TestCase4() {
        driver.get("http://zero.webappsecurity.com/");
        WebElement singIn = driver.findElement(By.id("signin_button"));
        singIn.click();
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();
        WebElement accountActivity = driver.findElement(By.xpath("//a[text()='Account Activity']"));
        accountActivity.click();
        WebElement accountDropDownMenu = driver.findElement(By.id("aa_accountId"));
        Select accountOptions = new Select(accountDropDownMenu);
        accountOptions.selectByIndex(5);
        Assert.assertEquals(accountOptions.getFirstSelectedOption().getText(), "Brokerage");
        List<String> expectedList = Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");
        List<WebElement> webElementList = accountOptions.getOptions();
        List<String> actualList = new ArrayList<String>();
        for (WebElement webElement : webElementList) {
            actualList.add(webElement.getText());
        }
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(actualList, expectedList);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}