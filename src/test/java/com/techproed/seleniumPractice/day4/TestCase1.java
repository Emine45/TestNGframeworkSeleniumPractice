package com.techproed.seleniumPractice.day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase1 extends TestBase {
//    1. Go to http://zero.webappsecurity.com/
//            2. Click Sign in button
// 3. Enter login ( “username”)
// 4. Enter wrong password (“password”)
// 5. Click Sign in button
//6. Go to Pay Bills page
//7. Click Purchase Foreign Currency
//8. Select Eurozone from currency drop dawn menu
//9. Verify the Euro zone is selected
//10. Verify the List Options is following {Select One,Australia (dollar), Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}

    @Test
    public void TestCase(){
        driver.get("http://zero.webappsecurity.com");
        WebElement singIn = driver.findElement(By.id("signin_button"));
        singIn.click();
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();
        WebElement payBills = driver.findElement(By.linkText("Pay Bills"));
        payBills.click();
        WebElement PurForCur = driver.findElement(By.linkText("Purchase Foreign Currency"));
        PurForCur.click();
        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropDown);
        select.selectByValue("EUR");
        String expectedSlectedOp = "Eurozone (euro)";
        String actualSelectedOp = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOp,expectedSlectedOp);
        List<String> expetedAllOptions = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        List<WebElement> elementList =select.getOptions();
        List<String> actualAllOptions =new ArrayList<>();
        for (WebElement element : elementList) {
            actualAllOptions.add(element.getText());
        }
        Assert.assertEquals(actualAllOptions,expetedAllOptions);
    }
}
