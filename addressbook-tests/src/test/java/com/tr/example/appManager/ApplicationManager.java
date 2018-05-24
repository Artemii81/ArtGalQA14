package com.tr.example.appManager;

import com.tr.example.model.ContactData;
import com.tr.example.model.GroupData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.internal.GroupsHelper;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private GroupHelper groupHelper;
    private ContactHelper contactHelper ;
    private NavigationHelper navigationHelper;
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void start() {
          if(browser.equals(BrowserType.CHROME)){
              driver = new ChromeDriver();
          } else if(browser.equals(BrowserType.FIREFOX)){
              driver=new FirefoxDriver();
          } else if(browser.equals(BrowserType.IE)){
              driver = new InternetExplorerDriver();
          }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        siteOpen("http://localhost/addressbook/");
        login("admin", "secret");
        groupHelper = new GroupHelper(driver);
        contactHelper= new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
    }
    public void login(String user, String password) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void siteOpen(String url) {
        driver.get(url);
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
