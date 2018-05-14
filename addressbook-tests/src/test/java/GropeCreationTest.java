import org.testng.annotations.Test;

public class GropeCreationTest extends TestBase {

    @Test
    public void testGropeCreation() throws Exception {
        //methods openSite & login are located in parent class TestBase
        goToGroupPage();
        // driver.findElement(By.xpath("(//input[@name='new'])[2]")).click();
        initGroupCreation();
        fillGroupForm("name", "header","footer");
        submitGroupCreation();
        goToGroupPage();
    }

}
