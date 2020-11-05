/*
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Test() throws Exception {

    try {

        } catch () {

        }
    public void test_login() {

    }


    public static  void main (String [] args) throws Exception {

        //WebDriver driver ;
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //goto url

        driver.get("https://www.google.lk");

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile=new File("D:\\testGoogle.png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

        driver.close();
    }
}
*/
