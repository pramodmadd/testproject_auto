package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNG_ParallelExecution {

    public WebDriver driver;

    @Test
    public void FirefoxTest()
    {

        WebDriverManager.firefoxdriver().setup();
        //Initializing the firefox driver (Gecko)
        driver = new FirefoxDriver();
        driver.get("https://www.google.lk");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
        driver.quit();

    }

    @Test
    public void ChromeTest()
    {
        WebDriverManager.chromedriver().setup();
        //Initialize the chrome driver
        driver = new ChromeDriver();
        driver.get("https://www.google.lk");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
        driver.quit();

    }
}
