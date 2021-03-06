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
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.List;

public class ActionMovetoElement{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        try {
            driver.get("https://ru.ebay.com/");
            WebElement selectweb = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"))).build().perform();
            Thread.sleep(5000);
            WebElement web = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[1]/a"));
            web.click();
            WebElement banner= driver.findElement(By.xpath("/html/body/div[5]/div[2]/section/div[1]/div[2]/h2"));
            String text=banner.getText();
            String url = driver.getCurrentUrl();
            Assert.assertEquals(text,"Лучшие помощники для жизни и работы");
            action.moveToElement(web).click().build().perform();
            Thread.sleep(5000);
            WebElement prof= selectweb.findElement(By.xpath("//*[@id=\"gh-logo\"]"));
            String url1= driver.getCurrentUrl();
            Assert.assertEquals(true,prof.isDisplayed());
            Assert.assertEquals(url1,"https://ru.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
