import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main (String [] args) {

        //System.setProperty("webdriver. chrome. driver", "D:\\Drivers\\Chrome\\chromedriver_85\\chromedriver");
        //WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.lk/");


        driver.quit();
    }


}
