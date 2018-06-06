package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectFirstGroup();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.getGroupHelper().initGroupModification();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     //   app.getGroupHelper().fillGroupForm(new GroupData("new_name", "new_header", ""));
        app.getGroupHelper().confirmGroupModification();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);

    }


}
