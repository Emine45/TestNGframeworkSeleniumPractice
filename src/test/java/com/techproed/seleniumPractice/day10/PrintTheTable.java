package com.techproed.seleniumPractice.day10;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class PrintTheTable {
// 1.Go to https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table
// 2.Go down up to medal table
// 3.Print all the table on the console

    @Test
    public void printTable() {
        Driver.getDriver().get(ConfigReader.getProperty("olympic_table"));
        Actions actions = new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> listWeb = Driver.getDriver().findElements(By.xpath("(//table)[13]//tr"));
        for (WebElement webElement : listWeb) {
            System.out.println(webElement.getText());
        }
    }
}