package Mails;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Mail {

    WebDriver driver;

    @Test
    public void testMail() {
        System.out.println("This is the starting point of the test");
        //Initialize Chrome Driver
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mailtrap.io/signin");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        email.sendKeys("pramodcrazy063@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        password.sendKeys("Pramod@1234");

        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[2]/div/div/div[3]/div/div[1]/span/a")).click();

        List<WebElement> allMessages = driver.findElements(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[2]/ul/li/a"));

        if (allMessages.isEmpty()) {
            System.out.println("Test not passed");
        } else {
            System.out.println("Test passed");
        }
    }
}
