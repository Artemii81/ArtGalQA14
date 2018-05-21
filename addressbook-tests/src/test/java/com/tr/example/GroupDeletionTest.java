package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


   @Test
    public void testGropDeletion() throws Exception {
       //methods openSite & login are located in parent class TestBase
        app.goToGroupPage();
        int before = app.getGroupCount();

        app.selectFirstGroup();
        app.deleteGroup();
       app.goToGroupPage();
       int after = app.getGroupCount();
       Assert.assertEquals(after,before-1);

   }

}
