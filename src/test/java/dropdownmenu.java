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
import java.time.Duration;
import java.util.List;

public class dropdownmenu{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        try {
            driver.get("https://ru.ebay.com/");
            Actions actions = new Actions(driver);
            WebElement button1 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
            actions.moveToElement(button1).perform();
            WebElement button2 = driver.findElement(By.partialLinkText("Apple"));
            button2.click();
            WebElement iphone11 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/div[2]/a[1]/div[1]/img"));
            iphone11.click();
            WebElement click= driver.findElement(By.xpath("//*[@id=\"s0-27_2-9-0-1[0]-0-0-6-5-4[5]-flyout\"]/button"));
            click.click();
            WebElement click1= driver.findElement(By.xpath("//*[@id=\"s0-27_2-9-0-1[0]-0-0-6-5-4[5]-flyout\"]/div/ul/li[3]/a/span[1]"));
            click1.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,700);");
            WebElement telef = driver.findElement(By.xpath("//*[@id=\"s0-27_1-9-0-1[0]-0-0\"]/ul/li[5]/div/div[1]/div/a/div/div/img"));
            telef.click();
            WebElement telef1 = driver.findElement(By.xpath("//*[@id=\"s0-0-18-5-12-26-14\"]/div/ul/li[2]/a/img"));
            String url = driver.getCurrentUrl();
            Assert.assertEquals(true,telef1.isDisplayed());
            Assert.assertEquals(url,"https://www.ebay.com/p/19034211509?iid=403113641660");
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            driver.quit();
        }

    }
}