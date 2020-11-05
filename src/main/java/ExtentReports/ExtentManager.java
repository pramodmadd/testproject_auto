/*
 *  This class has created an ExtentReports object and it can be reachable via getReporter() methdd.
 *  Also here we set the where the ExtentReports report HTML file location.
 */


package ExtentReports;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 */

public class ExtentManager {

    private static ExtentReports extent;

    private static String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "output_directory" + timeStamp +"_Automation-Report-Results.html",
                    false, DisplayOrder.NEWEST_FIRST );
            extent.loadConfig(new File(System.getProperty("user.dir") +  File.separator + "AutoTest\\src\\main\\resources\\extent-config.xml"));
        }
        return extent;
    }
}
