import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        //methods openSite & login are located in parent class TestBase
        goToContactPage();
        initContactCreation();
        fillContactForms("Serg", "Goreli", "555 55 55", "serg@mail.com");
        submitContactCreation();

    }
}
