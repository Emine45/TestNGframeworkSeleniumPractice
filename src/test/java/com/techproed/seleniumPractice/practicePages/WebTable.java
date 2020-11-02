package com.techproed.seleniumPractice.practicePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class WebTable {
    WebDriver driver;
    public WebTable(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//div[@class='rt-thead -header']/div/div[6]")
    public WebElement department;
    @FindBy(xpath = "//div[@class='rt-tbody']/div[3]/div/div[6]")
    public WebElement departmentName;
    public String departmentNameWithMethod(String name){
        WebElement departName= driver.findElement(By.xpath("//div[@class='rt-tbody']/div/div/div[text()='"+name+"']/../div[6]"));
        return departName.getText();
    }
}
