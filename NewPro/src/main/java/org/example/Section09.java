package org.example;

import com.google.common.base.Function;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Section09 {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        //explicitWait();
        //fluentwait();
        explicit_wait2();

    }
    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public static void explicitWait() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
        driver.findElement(By.id("H-destination")).sendKeys("nyc");
        driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);
        driver.findElement(By.id("H-fromDate")).sendKeys(Keys.ENTER);
        Duration d = Duration.ofSeconds(15);
        WebDriverWait d2=new WebDriverWait(driver, d);
        d2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]")));
        //Thread.sleep(5000L);
        driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();

    }
//    public static void fluentwait(){
//        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        driver.findElement(By.cssSelector("#start > button")).click();
//        Duration d = Duration.ofSeconds(20);
//        Duration d2 = Duration.ofSeconds(20);
//        Wait wait=new FluentWait(driver).withTimeout(d).pollingEvery(d2).ignoring(NoSuchElementException.class);
//        WebElement woo = wait.until(new Function() {
//            @Override
//            public @Nullable Object apply(Object o) {
//                return null;
//            }
//        } {
//        })
//
//    }
    public static void explicit_wait2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start > button")).click();
        Duration d = Duration.ofSeconds(15);
        WebDriverWait d2=new WebDriverWait(driver, d);
        WebElement result = d2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"finish\"]/h4")));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println(result.getText());


    }

}
