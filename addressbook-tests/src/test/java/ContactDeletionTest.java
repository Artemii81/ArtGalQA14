import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        goToContactPage();
        selectFirstContact();
        deletContact();

    }

}
