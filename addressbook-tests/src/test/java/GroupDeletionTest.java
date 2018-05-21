import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


   @Test
    public void testGropDeletion() throws Exception {
       //methods openSite & login are located in parent class TestBase
        goToGroupPage();
        selectFirstGroup();
        deleteGroup();
       goToGroupPage();


   }

}
