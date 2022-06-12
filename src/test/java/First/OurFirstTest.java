package First;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFirstTest {

    @Parameters({"username","password"})
    @Test(enabled = false)
    public void ourFirstTest(String username, String password){
        System.out.println(username + " " + password);
    }

    @Test(invocationCount = 100,invocationTimeOut = 1)
    public void ourSecondTest(){
        System.out.println("it is second test");
    }
}
