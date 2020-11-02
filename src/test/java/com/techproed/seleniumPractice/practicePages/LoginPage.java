package com.techproed.seleniumPractice.practicePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
//    Go to http://zero.webappsecurity.com/
//  2. Write a useful method which is named login under the
//     practicePage
//  3.Call the login method from TestCase1 class.
//    Enter login ( “username”)
//    password (“password”)

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(id = "signin_button")
    public WebElement signinButton1;
    @FindBy(id = "user_login")
    public WebElement userLogin;
    @FindBy(id = "user_password")
    public WebElement userPassword;
    @FindBy(name = "submit")
    public WebElement submitButton;
    public  void LoginZeroBank() throws InterruptedException {
        Thread.sleep(2000);
        userLogin.sendKeys("username");
        userPassword.sendKeys("password");
        submitButton.click();
    }
}