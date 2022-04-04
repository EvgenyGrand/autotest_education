import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.List;

public class AssertCSSValue {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get("https://www.google.ru/");
            WebElement context = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]"));
            String fine =context.getCssValue("padding");
            Assert.assertEquals(fine,"0px 16px");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}

