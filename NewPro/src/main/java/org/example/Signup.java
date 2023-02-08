package org.example;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Signup {
    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        signup_cos();

    }
    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void signup_cos(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://test-app.chargeonsite.com/customer/register");
        driver.findElement(By.id("basic_fName")).sendKeys("Steve");
        driver.findElement((By.id("basic_lName"))).sendKeys("Smith");
        driver.findElement(By.id("basic_email")).sendKeys("stsmith@yahoo.com");
        driver.findElement(By.id("basic_zip")).sendKeys("87001");
        driver.findElement(By.id("basic_password")).sendKeys("Paaswoi12@");
        driver.findElement(By.cssSelector("input[placeholder='Confirm password']")).sendKeys("Paaswoi12@");
        driver.findElement(By.cssSelector(".ant-checkbox-input")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url ="+ currentUrl);
        String expecturl= "https://test-app.chargeonsite.com/customer/verify?email=stsmith@yahoo.com";
        if (currentUrl == expecturl){
            System.out.println("Test case passed");
        }
        else {
            System.out.println("Test case failed");
        }

        //Assert.assertEquals(currentUrl,expecturl);



    }
}
