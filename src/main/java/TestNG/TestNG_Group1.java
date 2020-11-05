package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Group1 {

    WebDriver driver;

    // Saving the expected title of the Webpage
    String title = "Google";


    @Test
    public void starting_point(){
        System.out.println("This is the starting point of the test");
        //Initialize Chrome Driver
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.lk/?gws_rd=ssl");
    }


    @Test(groups = { "demo" })
    public void checkTitle() {
        String testTitle = "Google";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
    }

    @Test(groups = { "demo" })
    public void click_element() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).click();
        System.out.println("Home Page heading is displayed");
        driver.close();
    }


}
