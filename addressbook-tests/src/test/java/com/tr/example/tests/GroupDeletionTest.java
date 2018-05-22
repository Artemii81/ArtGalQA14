package com.tr.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


   @Test
    public void testGropDeletion() throws Exception {
       //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();

        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().deleteGroup();
       app.getNavigationHelper().goToGroupPage();
       int after = app.getGroupHelper().getGroupCount();
       Assert.assertEquals(after,before-1);

   }

}
