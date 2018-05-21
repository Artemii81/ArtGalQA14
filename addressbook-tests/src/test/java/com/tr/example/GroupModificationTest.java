package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        //methods openSite & login are located in parent class TestBase
        app.goToGroupPage();
        int before = app.getGroupCount();
        app.selectFirstGroup();
        app.initGroupModification();
        app.fillGroupForm(new GroupData("new_name", "new_header", ""));
        app.confirmGroupModification();
        app.goToGroupPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after,before);

    }


}
