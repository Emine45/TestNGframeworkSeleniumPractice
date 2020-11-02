package com.techproed.seleniumPractice.day6;

import com.techproed.seleniumPractice.practicePages.WebTable;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;


public class TestCase2 extends TestBase {

//  1.Go to ” https://demoqa.com/webtables”
//  2.Print Department from the headers
//  3.Print  the department name of Alden


    @Test
    public void testCase2(){
        WebTable webTable = new WebTable(driver);
        driver.get("https://demoqa.com/webtables");
        System.out.println(webTable.department.getText());
        String nameDepartment = webTable.departmentNameWithMethod("Cierra");
        System.out.println(nameDepartment);
    }
}
