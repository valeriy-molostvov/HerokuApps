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

    @Test
    public void homeworkCheckboxes() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        Assert.assertFalse(firstCheckbox.isSelected(), "Checked");
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), "Unchecked");
        Assert.assertTrue(secondCheckbox.isSelected(), "Unchecked");
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected(), "Checked");
        driver.quit();
    }

    @Test
    public void homeworkDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> listOfDropdownValues = select.getOptions();
        Assert.assertEquals(listOfDropdownValues.size(), 3, "Not all of the elements are shown");
        select.selectByVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Option 1']")).isSelected(),
                "Option 1 is not selected");
        select.selectByVisibleText("Option 2");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Option 2']")).isSelected(),
                "Option 2 is not selected");
        driver.quit();
    }

    @Test
    public void homeworkInput() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        String inputNumber = "34";
        String negativeInputNumber = "-34";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement number = driver.findElement(By.xpath("//div[@class='example']//input"));
        number.click();
        number.sendKeys(inputNumber);
        Assert.assertEquals(number.getAttribute("value"), inputNumber, "Value isn't equal");
        number.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(number.getAttribute("value"), String.valueOf(Integer.parseInt(inputNumber) + 1),
                "number isn't changed after ARROW_UP");
        number.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(number.getAttribute("value"), inputNumber, "number isn't changed after ARROW_UP");
        number.clear();
        number.sendKeys(negativeInputNumber);
        Assert.assertEquals(number.getAttribute("value"), negativeInputNumber, "Neg values are not supported");
        number.clear();
        number.sendKeys("letters");
        Assert.assertEquals(number.getAttribute("value"), "", "Letters input is possible");
        number.clear();
        number.sendKeys("!@$");
        Assert.assertEquals(number.getAttribute("value"), "", "Symbols input is possible");
        driver.quit();
    }

    @Test
    public void homeworkTypos() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/typos");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/div/p[2]")).getText(),
                "Sometimes you'll see a typo, other times you won,t.",
                "Found mistake in the text");
        driver.quit();
    }

    @Test
    public void homeworkTables() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");

        getParameters("//table//tr[1]", "Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com");
        getParameters("//table//tr[2]", "Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www.frank.com");
        getParameters("//table//tr[3]", "Doe", "Jason", "jdoe@hotmail.com", "$100.00", "http://www.jdoe.com");
        getParameters("//table//tr[4]", "Conway", "Tim", "tconway@earthlink.net", "$50.00", "http://www.timconway.com");
        driver.quit();
    }


    private void getParameters(String locator, String lastName, String firstName, String email, String due, String webSite) {
        Assert.assertEquals(driver.findElement(By.xpath(locator + "/td[1]")).getText(), lastName, "lastName is not equal");
        Assert.assertEquals(driver.findElement(By.xpath(locator + "/td[2]")).getText(), firstName, "firstName is not equal");
        Assert.assertEquals(driver.findElement(By.xpath(locator + "/td[3]")).getText(), email, "email is not equal");
        Assert.assertEquals(driver.findElement(By.xpath(locator + "/td[4]")).getText(), due, "due is not equal");
        Assert.assertEquals(driver.findElement(By.xpath(locator + "/td[5]")).getText(), webSite, "webSite is not equal");
    }
}
