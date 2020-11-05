package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_CrossBrowser {

    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass

    // Passing Browser parameter from TestNG xml

    public void beforeTest(String browser) {

        // If the browser is Firefox, then do this

        if(browser.equalsIgnoreCase("firefox")) {

            //Initializing the firefox driver (Gecko)
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {

            //Initialize the chrome driver
            driver = new ChromeDriver();

        }

        // Enter the website address in the browser

        driver.get("https://www.google.lk");

    }

    // Once Before method is completed, Test method will start

    @Test
    public void login() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();

    }

    @AfterClass
    public void afterTest() {

        driver.quit();

    }
}
