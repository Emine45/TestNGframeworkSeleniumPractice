package com.techproed.seleniumPractice.day5;

import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {

//    1.Go to ” https://demoqa.com/dynamic-properties”
//    2.Verify the Visible After 5 Seconds button is displayed

    @Test
    public void Test() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement visibleElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(visibleElement.isDisplayed());
    }
}

