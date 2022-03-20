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

public class AssertDropdownmenu {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        try {
            driver.get("https://www.ebay.com/");
            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
            dropdown.click();
            Select select = new Select(dropdown);
            select.selectByVisibleText("Антиквариат");
            WebElement search = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
            search.click();
            WebElement asia = driver.findElement(By.xpath("//*[@id=\"s0-27-9-0-1[0]-0-0-12-list\"]/li[2]/a/div/img"));
            asia.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,800);");
            WebElement asia_coin = driver.findElement(By.xpath("//*[@id=\"s0-27_2-9-0-1[0]-0-0\"]/ul/li[1]/div/div[2]/a/h3"));
            String text = asia_coin.getText();
            Assert.assertEquals(text, "Старинная китайская перламутр гербовый игровой счетчики фишки");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

