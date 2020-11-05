import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

    public static void main (String [] args) {

        /*WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);

        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get("https://www.google.com");
        System.out.println("Executing Firefox Driver in Headless mode.. \n");

        System.out.println("Page Title is: " + driver.getTitle());

        System.out.println("Current URL is: " + driver.getCurrentUrl());*/


        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com");
        System.out.println("Executing Chrome Driver in Headless mode..\n");

        System.out.println(">> Page Title : "+driver.getTitle());
        System.out.println(">> Page URL  : "+driver.getCurrentUrl());
    }
}
