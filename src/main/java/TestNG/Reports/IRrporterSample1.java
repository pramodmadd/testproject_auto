package TestNG.Reports;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value=IReporterReport.class)
public class IRrporterSample1 {

    @Test(priority=0,description="testReporterOne")
    public void testReporterOne(){

        //Pass test case
        Assert.assertTrue(true);
    }

    @Test(priority=1,description="testReporterTwo")
    public void testReporterTwo(){

        //Fail test case
        Assert.assertTrue(false);
    }

}
