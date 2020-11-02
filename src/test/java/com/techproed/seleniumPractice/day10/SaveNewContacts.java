package com.techproed.seleniumPractice.day10;

import com.techproed.seleniumPractice.practicePages.ContactPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SaveNewContacts extends TestBase {

//    @Test
//    public void saveContact() throws InterruptedException {
//        ExcelUtil excelUtil=new ExcelUtil("src/test/java/resources/dataContact.xlsx","data");
//        List<Map<String ,String>> data =excelUtil.getDataList();
//        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
//        String userEmail =ConfigReader.getProperty("username_for_erp");
//        String password = ConfigReader.getProperty("password_for_erp");
//        ContactPage contactPage = new ContactPage();
//        contactPage.login(userEmail,password);
//        int lastRow=excelUtil.rowCount();
//        for (int i = 0; i < lastRow-1; i++) {
//            Thread.sleep(3000);
//            contactPage.contacts.click();
//            Thread.sleep(3000);
//            contactPage.createButton.click();
//            contactPage.inputName.sendKeys(data.get(i).get("FirstName"));
//            contactPage.createbutton2.click();
//            String fullName = data.get(i).get("FirstName") + " " + data.get(i).get("LastName");
//            contactPage.contactName.sendKeys(fullName);
//            contactPage.email.sendKeys(data.get(i).get("Email"));
//            contactPage.phone.sendKeys(data.get(i).get("Phone"));
//            contactPage.save_close.click();
//            contactPage.save.click();
//            Thread.sleep(3000);
//        }
//    }

    @Test
    public void saveContact() throws InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil("src/test/java/resources/dataContact.xlsx", "data");
        List<Map<String, String>> data = excelUtil.getDataList();
        extentTest = extentReports.createTest("Save New Contact", "Test");
        extentTest.info("Opening Browser");
        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
        String userEmail = ConfigReader.getProperty("username_for_erp");
        String password = ConfigReader.getProperty("password_for_erp");
        ContactPage contactPage = new ContactPage();
        extentTest.info("Logging with valid credentials");
        contactPage.login(userEmail, password);
        int lastRow = excelUtil.rowCount();
        for (int i = 0; i < lastRow - 1; i++) {
            Thread.sleep(3000);
            extentTest.info("navigate to Contact page");
            contactPage.contacts.click();
            Thread.sleep(3000);
            extentTest.info("clicking the create button");
            contactPage.createButton.click();
            extentTest.info("enter name");
            contactPage.inputName.sendKeys(data.get(i).get("FirstName"));
            contactPage.createbutton2.click();
            String fullName = data.get(i).get("FirstName") + " " + data.get(i).get("LastName");
            extentTest.info("Enter full Name");
            contactPage.contactName.sendKeys(fullName);
            extentTest.info("Enter email");
            contactPage.email.sendKeys();
            extentTest.info("Enter Phone");
            contactPage.phone.sendKeys(data.get(i).get("Phone"));
            extentTest.info("click the save and close button");
            contactPage.save_close.click();
            extentTest.info("click the save button");
            contactPage.save.click();
            Thread.sleep(3000);
        }
    }
}