package TestNG.Reports;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (ITestSample1.class)
public class ITestReport {

    @Test
    public void testReportOne(){
        Assert.assertTrue(true);
    }

    @Test
    public void testReportTwo(){
        Assert.assertTrue(false);
    }

    //Test case depends on failed testcase= testReportTwo
    @Test(dependsOnMethods="testReportTwo")
    public void testReportThree(){
    }
}
