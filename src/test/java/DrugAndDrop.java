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

public class DrugAndDrop{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get("https://www.bspb.ru/retail/consumer-loan/");
            WebElement Podrob= driver.findElement(By.xpath("//*[@id=\"link_loansMore\"]"));
            Podrob.click();
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,415);");
            Thread.sleep(2000);
            Actions move = new Actions(driver);
            WebElement insuaranse= driver.findElement(By.xpath("//*[@id=\"currentInsurance\"]"));
            insuaranse.click();
            WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"LoanCalculator\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div[2]/div"));
            move.dragAndDropBy(slider1,260,0).click();
            move.build().perform();
            WebElement slider2= driver.findElement(By.xpath("//*[@id=\"LoanCalculator\"]/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div"));
            move.dragAndDropBy(slider2,200,0).click();
            move.build().perform();

            WebElement payment = driver.findElement(By.xpath("//*[@id=\"LoanCalculator\"]/div/div[2]/div/div[1]/div/big"));
            Thread.sleep(2000);
            Assert.assertEquals(payment.getAttribute("innerText"),"14 547");
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.bspb.ru/retail/consumer-loan/salary/?bspb_param=analytics-link-salary");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
         driver.quit();
        }
    }

}
