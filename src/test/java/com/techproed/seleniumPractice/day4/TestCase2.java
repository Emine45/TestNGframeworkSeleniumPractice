package com.techproed.seleniumPractice.day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {

//1.Go to http://webdriveruniversity.com/File-Upload/
// 2.Click the Choose file button
//3.Create a text document in your desktop
//4.Upload this document from your desktop
//5.Click the Submit button
//6.Verify the “Your file has now been uploaded!” is displayed
//7.Accept the popup

    @Test
    public void testCase(){
        driver.get("http://webdriveruniversity.com/File-Upload");
        String filePath ="/Users/eminebatar/Desktop/FLOWER. IMG.jpg";
        WebElement chooseFile = driver.findElement(By.id("myFile"));
        chooseFile.sendKeys(filePath);
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
        String actualMessage = driver.switchTo().alert().getText();
        String  expectedMessage = "Your file has now been uploaded!";
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.switchTo().alert().accept();
    }
}
