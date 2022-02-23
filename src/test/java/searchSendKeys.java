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
import java.util.List;

public class searchSendKeys {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://ru.ebay.com/");
        try {
            Thread.sleep(2000);

            WebElement window = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
            window.sendKeys("Honor 10i");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
            button.click();
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,400);");
            WebElement box = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/h3"));
            box.click();
            String currentTab = driver.getWindowHandle();
            for (String tab : driver.getWindowHandles()) {
                if (!tab.equals(currentTab)) {
                    driver.switchTo().window(tab);
                }
            }
            WebElement model = driver.findElement(By.xpath("//*[@id=\"msku-sel-1\"]"));
            WebElement color = driver.findElement(By.xpath("//*[@id=\"msku-sel-2\"]"));
            Select select = new Select(model);
            Select select1 = new Select(color);
            select.selectByVisibleText("For Huawei Honor 8A");
            select1.selectByVisibleText("Black");
            WebElement buy = driver.findElement(By.xpath("//*[@id=\"binBtn_btn\"]"));
            buy.click();
            WebElement alert = driver.findElement(By.xpath("//*[@id=\"sbin-text-content\"]/p"));
            String al = alert.getText();
            Assert.assertEquals(al,"Bling Glitter Soft Case & Holder for Huawei Honor 10 Lite 20 8S Nova 5T Y6S Y5");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }

}


