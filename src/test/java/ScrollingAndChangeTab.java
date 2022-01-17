import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.List;

public class ScrollingAndChangeTab {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        try {
            driver.get("https://www.google.ru/");

        WebElement input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        input.sendKeys("Java", Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,400);");
        WebElement hyper = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div[1]/a/div/cite"));
        hyper.click();
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                WebElement name1 = driver.findElement(By.xpath("//*[@id=\"p-logo\"]/a"));
                WebElement name2 = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/div[4]/div/a/img"));
                String url = driver.getCurrentUrl();
                Assert.assertEquals(true,name1.isDisplayed());
                Assert.assertEquals(true,name2.isDisplayed());
                Assert.assertEquals(url, "https://ru.wikipedia.org/wiki/Java");

            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}