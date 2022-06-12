package First;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class OurSecondTest {


    @Factory
    @Test()
    public Object [] myFactory() {
        Object [] factory = new Object[2];
        factory[0] = new TestTwo();
        factory[1]= new MyFristTest();
        return factory;
    }
}
