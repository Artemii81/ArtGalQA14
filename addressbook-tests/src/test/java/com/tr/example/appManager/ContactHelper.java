package com.tr.example.appManager;

import com.tr.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }
    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])"));
       }

    public void fillContactForms(ContactData contact) {
      /*  driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getName());
        */

      type(By.name("firstname"), contact.getName());
    /*
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contact.getSecondName());
 */
        type(By.name("lastname"), contact.getSecondName());
        type(By.name("mobile"), contact.getTelNamber());
      /*  driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contact.getTelNamber());
*/
      type(By.name("email"), contact.getMail());
        type(By.name("address"), contact.getAdress());
     // type(By.name("photo"),contact.getPhoto().getAbsolutePath());
       attach(By.name("photo"),contact.getPhoto());
       if(isElementPresent(By.xpath("//*[@name='new_group']"))) {
           new Select(driver.findElement(By.xpath("//*[@name='new_group']")))
                   .selectByVisibleText(contact.getGroup());
       }
      /*
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contact.getMail());
        */
    }
/*    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
*/
    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deletContact() {
        click(By.xpath("//input[@value='Delete']"));
        //    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        //    closeAlertAndGetItsText();
     //   if (isAlertPresent()){driver.switchTo().alert().accept();}
        driver.switchTo().alert().accept();
    }

    public void selectFirstContact() {
        click(By.name("selected[]"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        initContactCreation();
        fillContactForms(new ContactData()
                .withfName("Serg")
                .withlName("Goreli")
                .withTelNamber("555 55 55")
                .withMail("serg@mail.com"));
        submitContactCreation();

    }

}
