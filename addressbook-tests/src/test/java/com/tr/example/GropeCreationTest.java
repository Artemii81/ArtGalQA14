package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GropeCreationTest extends TestBase {

    @Test
    public void testGropeCreation() {
        //methods openSite & login are located in parent class TestBase
        app.goToGroupPage();
        int before = app.getGroupCount();
        // driver.findElement(By.xpath("(//input[@name='new'])[2]")).click();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("name", "header", "footer"));
        app.submitGroupCreation();
        app.goToGroupPage();
        int after = app.getGroupCount();

        Assert.assertEquals(after, before+1);

    }

}
