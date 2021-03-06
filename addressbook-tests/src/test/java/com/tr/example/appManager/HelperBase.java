package com.tr.example.appManager;

import org.openqa.selenium.*;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void attach (By locator, File file) {
        if(file!=null) {
               driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
