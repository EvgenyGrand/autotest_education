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

public class changePosition {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        try {
            driver.get("https://ru.ebay.com/");
            Actions action = new Actions(driver);
            WebElement mva = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
            WebElement mva2 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[2]/a"));
            action.moveToElement(mva).build().perform();
            Thread.sleep(2000);
            action.moveToElement(mva2).click().build().perform();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,900);");
            Thread.sleep(5000);
            WebElement text = driver.findElement(By.xpath("//*[@id=\"s0-27-9-0-1[2]-1-1-1\"]/div/h2[1]/strong"));
            String tex= text.getText();
            String url = driver.getCurrentUrl();
            Assert.assertEquals(tex,"Shop Video Games & Consoles");
            Assert.assertEquals(url,"https://ru.ebay.com/b/Gaming/1249/bn_1850232");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

