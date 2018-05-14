import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        //methods openSite & login are located in parent class TestBase
        goToContactPage();
        selectFirstContact();
        deletContact();

    }

}
