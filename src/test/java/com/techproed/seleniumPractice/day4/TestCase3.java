package com.techproed.seleniumPractice.day4;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {

// 1.Go to http://webdriveruniversity.com/IFrame
// 2.Click the Our Products button
//3.Click Cameras product
//4.Print the message from popup
//5.Click the close button

    @Test
    public void testCase() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/");
        WebElement iframe = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        WebElement products = driver.findElement(By.xpath("//a[text()='Our Products']"));
        products.click();
        WebElement firstProduct = driver.findElement(By.id("container-product1"));
        firstProduct.click();
        WebElement popMessage = driver.findElement(By.xpath("//h4[@class='modal-title']"));
        Thread.sleep(2000);
        System.out.println(popMessage.getText());
        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));
        closeButton.click();
    }
}
