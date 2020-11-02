package com.techproed.seleniumPractice.day6;

import com.techproed.seleniumPractice.practicePages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;


public class TestCase1 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigReader.getProperty("zeroLink"));
        Thread.sleep(2000);
        loginPage.signinButton1.click();
        loginPage.LoginZeroBank();
    }
}
