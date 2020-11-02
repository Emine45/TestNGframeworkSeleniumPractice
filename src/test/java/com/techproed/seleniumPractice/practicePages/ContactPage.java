package com.techproed.seleniumPractice.practicePages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    public ContactPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText="Contacts" )
    public WebElement contacts;
    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputName;
    @FindBy(xpath = "(//button[@accesskey='c'])[2]")
    public WebElement createbutton2;
    @FindBy(xpath = "//td/input[@name='name']")
    public WebElement contactName;
    @FindBy(xpath = "(//td/input[@name='email'])[2]")
    public WebElement email;
    @FindBy(xpath = "//td/input[@name='phone']")
    public WebElement phone;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary'])[1]")
    public WebElement save_close;
    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement save;
    @FindBy(linkText = "Login")
    public WebElement login;
    @FindBy(id = "login")
    public WebElement enterEmail;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement getLogin;
    public void login(String userEmail,String userPassword){
        login.click();
        enterEmail.sendKeys(userEmail);
        password.sendKeys(userPassword);
        getLogin.click();
    }
}
