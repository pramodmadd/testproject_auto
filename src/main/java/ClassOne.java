import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassOne {

    public static void main (String [] args) {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ChampWk51\\Desktop\\Drivers\\chromedriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.lk");

        System.out.println("Title is: " + driver.getTitle());

        System.out.println("Current URL is: " + driver.getCurrentUrl());

        System.out.println("Page Source is: " + driver.getPageSource());

        driver.close();

        driver.quit();

        driver.navigate().back();

    }

}
