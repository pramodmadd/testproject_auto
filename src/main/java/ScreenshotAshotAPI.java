import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotAshotAPI {

    // Capture Full Page Screenshot with AShot API
    @Test
    public void testAshotScreenshot() throws Exception {

        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.lk");
        driver.manage().window().maximize();

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.
                viewportPasting(1000)).takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "jpg",
                new File("D:\\ElementScreenshot.jpg"));

        driver.close();*/

    }

    //Taking a screenshot of a particular element of the page
    @Test
    public void testAshotScreenshot2 () throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.lk");

        driver.manage().window().maximize();

        WebElement element = driver.findElement
                (By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));

        Screenshot screenshot = new AShot().coordsProvider
                (new WebDriverCoordsProvider()).
                shootingStrategy(ShootingStrategies.
                        viewportPasting(1000)).
                takeScreenshot(driver, element);

        ImageIO.write(screenshot.getImage(), "jpg",
                new File("D:\\ElementScreenshot2.jpg"));

        driver.close();

    }

    // Image Comparison using AShot
    @Test
    public void imageComparrisonAshot () {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.lk");

        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"gsr\"]"));
        Screenshot logoElementScreenshot = new AShot().
                coordsProvider(new WebDriverCoordsProvider()).
                shootingStrategy(ShootingStrategies.
                        viewportPasting(1000)).
                takeScreenshot(driver, logoElement);

        // read the image to compare

        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(
                    new File("D:\\testGoogle.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage actualImage = logoElementScreenshot.getImage();

        // Create ImageDiffer object and call method makeDiff()

        ImageDiffer imgDiff = new ImageDiffer();
        assert expectedImage != null;
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

        if (diff.hasDiff()) {
            System.out.println("Images are same");

        } else {
            System.out.println("Images are different");
        }
        driver.quit();

    }

}
