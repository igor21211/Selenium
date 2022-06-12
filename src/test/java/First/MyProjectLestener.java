package First;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyProjectLestener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test Start successfully");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test run saccessed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skip");
    }


}


