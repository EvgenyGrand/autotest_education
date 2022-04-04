import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import javax.swing.*;
import java.awt.*;
import java.security.Key;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class dropdownSelect {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            driver.get("https://www.ebay.com/");
            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
            dropdown.click();
            Select select = new Select(dropdown);
            select.selectByVisibleText("Книги");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
            button.click();
            WebElement collection = driver.findElement(By.xpath("//*[@id=\"s0-27-9-0-1[0]-0-1[0]-0-12-list\"]/li[2]/a/p"));
            collection.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,400);");
            WebElement chek = driver.findElement(By.xpath("//*[@id=\"s0-27_2-9-0-1[0]-0-0-6-5-4[4]-flyout\"]/button"));
            chek.click();
            WebElement box = driver.findElement(By.xpath("//*[@id=\"s0-27_2-9-0-1[0]-0-0-6-5-4[4]-flyout\"]/div/ul/li[3]/a/span[1]"));
            box.click();
            WebElement book = driver.findElement(By.xpath("//*[@id=\"s0-27_1-9-0-1[0]-0-0\"]/ul/li[1]/div/div[2]/a/h3"));
            book.click();
            WebElement picture = driver.findElement(By.xpath("//*[@id=\"vi_main_img_fs_thImg0\"]/table/tbody/tr/td/div/img"));
            String url = driver.getCurrentUrl();
            Assert.assertEquals(true, picture.isDisplayed());
            Assert.assertEquals(url, "https://www.ebay.com/itm/393866548019?hash=item5bb4469333:g:78IAAOSwPx1h3v8m");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();

        }
    }
}