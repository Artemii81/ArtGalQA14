import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        //methods openSite & login are located in parent class TestBase
        goToGroupPage();
        selectFirstGroup();
        initGroupModification();
        fillGroupForm("new_name","new_header","");
        confirmGroupModification();
        goToGroupPage();
    }


}
