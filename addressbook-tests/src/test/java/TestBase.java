import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestBase {
    private WebDriver driver;
    private boolean acceptNextAlert = true;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        siteOpen("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])")).click();
    }

    public void fillContactForms(String name, String secondName, String telNamber, String mail) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(name);

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(secondName);

        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(telNamber);

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(mail);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void goToContactPage() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void login(String user, String password) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
    }

    public void siteOpen(String url) {
        driver.get(url);
    }


    public void deletContact() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    //    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    //    closeAlertAndGetItsText();
        if (isAlertPresent()){driver.switchTo().alert().accept();
         }
    }

    public void selectFirstContact() {
        driver.findElement(By.name("selected[]")).click();

    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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
