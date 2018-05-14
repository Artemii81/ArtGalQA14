import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


   @Test
    public void testGropDeletion() throws Exception {
        goToGroupPage();
        selectFirstGroup();
        deleteGroup();
       goToGroupPage();


   }

}
