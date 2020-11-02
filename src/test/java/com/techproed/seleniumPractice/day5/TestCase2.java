package com.techproed.seleniumPractice.day5;


import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase2 extends TestBaseCross {
//    1.Go to ”https://www.mediawiki.org/wiki/Download”
//    2.Click Download MediaWiki 1.34.2
//    3.Verify the file is downloaded

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.mediawiki.org/wiki/Download");
        WebElement downloadFile = driver.findElement(By.linkText("Download MediaWiki 1.35.0"));
        downloadFile.click();
        Thread.sleep(5000);
        String userPath = System.getProperty("user.home");
        String secondPath ="/Downloads/mediawiki-1.35.0.tar.gz.crdownload";
        boolean isDownloaded = Files.exists(Paths.get(userPath+secondPath));
        Thread.sleep(3000);
        Assert.assertTrue(isDownloaded);

    }
}