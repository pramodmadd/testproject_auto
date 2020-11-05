package TestNG.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNG_Retry implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 4;

    @Override
    public boolean retry(ITestResult result) {

        if(counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
