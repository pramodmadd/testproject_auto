package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions {

   /* public static void main (String [] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.lk");

        String expectedTitle = "Google";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles are not matching");

        driver.close();

    }*/

    public static void main (String [] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.lk");

        SoftAssert softAssert = new SoftAssert();

        String expectedTitle = "Google";
        String originalTitle = driver.getTitle();

        softAssert.assertEquals(originalTitle, expectedTitle);

        driver.close();

    }
}
