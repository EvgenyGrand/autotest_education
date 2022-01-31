import net.bytebuddy.asm.Advice;
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

public class sendkeys{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            driver.get("https://www.bspb.ru/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,2000);");
            WebElement ATM = driver.findElement(By.xpath("//*[@id=\"footer-menu\"]/div[4]/ul/li[1]/a"));
            ATM.click();
            JavascriptExecutor ss = (JavascriptExecutor) driver;
            ss.executeScript("scroll(0,400);");
            WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"metroSPB\"]"));
            Select select= new Select(dropdown1);
            select.selectByVisibleText("Автово");








        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
