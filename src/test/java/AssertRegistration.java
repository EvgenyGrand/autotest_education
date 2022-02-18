import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import javax.swing.*;
import java.awt.*;
import java.security.Key;
import java.time.Duration;
import java.util.List;

public class AssertRegistration{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        try {
            driver.get("http://qa.jtalks.org/jcommune/");
            WebElement cred = driver.findElement(By.xpath("//*[@id=\"signin\"]"));
            cred.click();
            WebElement login = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
            login.clear();
            login.sendKeys("test-user");
            WebElement password = driver.findElement(By.cssSelector("#password"));
            password.sendKeys("test-user");
            WebElement input = driver.findElement(By.xpath("//*[@id=\"signin-submit-button\"]"));
            input.click();
            WebElement tu = driver.findElement(By.xpath("//*[@id=\"user-dropdown-menu-link\"]"));
            tu.click();
            WebElement ta = driver.findElement(By.xpath("//*[@id=\"user-menu-profile\"]"));
            ta.click();
            WebElement prof = driver.findElement(By.xpath("//*[@id=\"editProfileForm\"]/div[1]/h2/span"));
            String url = driver.getCurrentUrl();
            Assert.assertEquals(prof.getText(),"test-user");
            Assert.assertEquals(url,"http://qa.jtalks.org/jcommune/user");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }

}