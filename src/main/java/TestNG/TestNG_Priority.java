package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_Priority {

    WebDriver driver = new ChromeDriver();

    @Test (priority = 1)
    public void CloseBrowser() {
        driver.close();
        System.out.println("Closing Google Chrome browser");
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        System.out.println("Launching Google Chrome browser");
        driver.get("https://www.google.lk");
    }
}
