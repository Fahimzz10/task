package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;


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
    public static void section_assignment2(){
        driver.get("http://qaclickacademy.com/practice.php");



        WebElement table=driver.findElement(By.id("product"));
        System.out.println(table.findElements(By.tagName("tr")).size());
        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        System.out.println(secondrow.get(0).getText());

        System.out.println(secondrow.get(1).getText());
        System.out.println(secondrow.get(2).getText());

    }

    }
}
