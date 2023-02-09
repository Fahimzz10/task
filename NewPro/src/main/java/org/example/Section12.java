package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Section12 {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        Section12_Assignment();



    }

    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void Section12_Assignment(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
    }
}
