import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuApp {
    WebDriver driver;

    @Test
    public void homeworkAddRemoveElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement webElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        webElement.click();
        webElement.click();
        driver.findElement(By.className("added-manually")).click();
        int elementNumber = driver.findElements(By.className("added-manually")).size();
        Assert.assertEquals(elementNumber, 1, "Invalid number of elements");
        driver.quit();
    }
}
