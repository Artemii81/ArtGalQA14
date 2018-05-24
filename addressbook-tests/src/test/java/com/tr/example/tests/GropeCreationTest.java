package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GropeCreationTest extends TestBase {

    @Test(priority = 2)
    public void testGropeCreation() {
        //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        // driver.findElement(By.xpath("(//input[@name='new'])[2]")).click();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("name", "header", "footer"));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupCount();

        Assert.assertEquals(after, before+1);

    }

}
