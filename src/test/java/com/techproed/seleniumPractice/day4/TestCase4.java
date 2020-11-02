package com.techproed.seleniumPractice.day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase4 extends TestBase {

// 1.Go to http://webdriveruniversity.com/Actions
// 2.Hover over the Me First
//3.Click Link 1
// 4.Print the popup message
//5.Accept the popup
//6.Click and hold
//7.Get the text click and hold
// Double click to the double click me

    @Test
    public void testCase(){
        driver.get("http://webdriveruniversity.com/Actions/");
        WebElement hoverOver = driver.findElement(By.className("dropbtn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOver).perform();
        WebElement link1 = driver.findElement(By.linkText("Link 1"));
        link1.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        System.out.println(clickAndHold.getText());
        WebElement doubleClick = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();
    }
}
