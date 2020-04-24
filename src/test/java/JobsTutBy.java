import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JobsTutBy {

        WebDriver driver;

        @Test
        public void jobsTutBy() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("https://jobs.tut.by/");
            driver.findElement(By.id("banner_630t"));
            driver.findElement(By.className("supernova-overlay"));
            driver.findElement(By.name("keywords"));
            driver.findElement(By.tagName("iframe"));
            driver.findElement(By.partialLinkText("Новос"));
            driver.findElement(By.linkText("TUT.BY"));
            driver.findElement(By.xpath("//div[contains(@class,'supernova-overlay__navi')]/ancestor::div[@class='supernova-overlay']"));
            driver.findElement(By.xpath("//div[@class='supernova-navi-item supernova-navi-item_lvl-1 supernova-navi-item_active']" +
                    "/ancestor-or-self::div[@class='supernova-navi supernova-navi_lvl-1']"));
            driver.findElement(By.xpath("//a[attribute::data-qa]"));
            driver.findElement(By.xpath("//div/descendant::div/div[@class='grid__columns-wrapper']"));
            driver.findElement(By.xpath("//div[@class='bloko-columns-wrapper']/child::div/div[contains(@class,'bloko-column')]"));
            driver.findElement(By.xpath("//div/descendant-or-self::button[@data-overlay-name='none']"));
            driver.findElement(By.xpath("//div[@class='bloko-columns-wrapper']/following::button[@data-overlay-name='none']"));
            driver.findElement(By.xpath("//div[@class='grid__columns-wrapper']/div[1]/following-sibling::div[5]"));
            driver.findElement(By.xpath("//h2[@class='bloko-header-2']/parent::div"));
            driver.findElement(By.xpath("//div[@class='top-menu']/preceding::div[@class='bloko-columns-wrapper']"));
            driver.findElement(By.xpath("//div[contains(@class,'HHC-Debug-Grid grid-absolute g-hidden')]//div[16]/preceding-sibling::div[7]"));
            driver.findElement(By.xpath("//h2[@class='bloko-header-2']/self::h2"));
            driver.findElement(By.cssSelector("img[src$='.jpg']"));
            driver.findElement(By.cssSelector("a[href*='mail.tut.by']"));
            
            driver.get("https://jobs.tut.by/article/26573");
            driver.findElement(By.cssSelector(".supernova-logo-wrapper"));
            driver.findElement(By.cssSelector(".bloko-column.bloko-column_xs-4.bloko-column_s-8.bloko-column_m-12.bloko-column_l-16"));

            driver.get("https://jobs.tut.by/account/signup?backurl=%2Fapplicant%2Fresumes%2Fnew&from=header_new");
            driver.findElement(By.cssSelector("*.bloko-column"));
            driver.findElement(By.cssSelector("a[data-qa]"));
            driver.findElement(By.cssSelector("div.supernova-footer"));
            driver.findElement(By.cssSelector("div,a[data-qa]"));
            driver.findElement(By.cssSelector("div p.supernova-footer-nav-cards"));
            driver.findElement(By.cssSelector("div + span"));
            driver.findElement(By.cssSelector("a ~ div"));
            driver.findElement(By.cssSelector("[data-qa]"));
            driver.findElement(By.cssSelector("[data-navi-item-name=copiny]"));
            driver.findElement(By.cssSelector("[data-page-analytics-event~=promoCreate]"));
            driver.findElement(By.cssSelector("[data-qa|=mainmenu_profile]"));
            driver.findElement(By.cssSelector("a[href^='https']"));
        }
}
