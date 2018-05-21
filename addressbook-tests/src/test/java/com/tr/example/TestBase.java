package com.tr.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        app.start();
        app.siteOpen("http://localhost/addressbook/");
        app.login("admin", "secret");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }


}