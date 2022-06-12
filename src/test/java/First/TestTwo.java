package First;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class TestTwo {


    @Test(priority = 2, alwaysRun = true, description = "First test", enabled = true)
    public static void Test(){
        System.out.println("Test");
    }

    @Test(priority = 1,alwaysRun = true,timeOut = 4 , invocationCount = 3)
    public static void testTwo(){
        System.out.println("First.TestTwo");
    }

    @DataProvider(name="env", parallel = true)
    public Object[][] dataprovider(){
        return new Object[][]{{"chrome,70.0"},{"chrome, 93.0"}};
    }

    @Test(dataProvider = "env")
    public void ourTest(String data){
        System.out.println(data);
    }

}
