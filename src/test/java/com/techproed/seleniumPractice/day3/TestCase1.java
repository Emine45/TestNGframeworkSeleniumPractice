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
import java.util.concurrent.TimeUnit;

public class TestCase1 {

//1.Go to “https://facebook.com”
//2. Click create new account button
// 3. Enter a name firstName input box
// 4. Enter a surname surName input box
// 5. Enter an email into email input box
//6. Re-enter the same email into email input box
//7. Enter a new password
//8. Select a day
//9. Select a moth
//10. Select a year
//11. Select a gender
//12. Verify the gender is selected and verify the other gender is not selected

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void TestCase1() throws InterruptedException {
        driver.get("https://facebook.com");
        WebElement createNewUser = driver.findElement(By.linkText("Create New Account"));
        createNewUser.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Emily");

        WebElement surName = driver.findElement(By.name("lastname"));
        surName.sendKeys("Arlington");

        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("EmilyArlington@gmail.com");

        WebElement reEnter = driver.findElement(By.name("reg_email_confirmation__"));
        reEnter.sendKeys("EmilyArlington@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        password.sendKeys("tg123*");

        WebElement day = driver.findElement(By.id("day"));
        Select dayOptions = new Select(day);
        dayOptions.selectByVisibleText("20");

        WebElement month = driver.findElement(By.id("month"));
        Select monthOptions = new Select(month);
        monthOptions.selectByValue("4");

        WebElement year = driver.findElement(By.id("year"));
        Select yearOptions = new Select(year);
        yearOptions.selectByValue("1999");

        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        female.click();
        Assert.assertTrue(female.isSelected());

        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));
        Assert.assertFalse(male.isSelected());
        Assert.assertFalse(custom.isSelected());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
