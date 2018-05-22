package com.tr.example.appManager;

import com.tr.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {

        this.driver = driver;
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])")).click();
    }

    public void fillContactForms(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getName());

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getSecondName());

        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getTelNamber());

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getMail());
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void deletContact() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        //    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        //    closeAlertAndGetItsText();
     //   if (isAlertPresent()){driver.switchTo().alert().accept();}
        driver.switchTo().alert().accept();
    }

    public void selectFirstContact() {
        driver.findElement(By.name("selected[]")).click();

    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
