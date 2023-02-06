package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        open_website();


    }
    public static void chrome_launch(){
        System.setProperty("web-driver.chrome.driver","D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void open_website(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://test-app.chargeonsite.com/customer/login");
        driver.findElement(By.cssSelector("input[placeholder=Email]")).sendKeys("sabihatesting.01@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys("T7777777");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.xpath("//*[@id=\"map\"]/div/div/div[2]/div[2]/div/div[3]/div[3]/img")).click();
        //driver.findElement(By.cssSelector("input[type=text]")).sendKeys("Messi");
        //driver.findElement(By.xpath("//div[@class='lJ9FBc']//input[@value='Google Search']")).click();
//        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
//        for (int i=0;i<products.size();i++)
//        {
//            String name= products.get(i).getText();
//
//
//            if (name.contains("Cucumber")){
//                driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[3]/button"));
//            }
 //       }
    }
}