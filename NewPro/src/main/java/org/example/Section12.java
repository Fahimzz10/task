package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Section12 {
    public static WebDriver driver;
    public static void main(String[] args) throws IOException {
        chrome_launch();
        //Section12_Assignment();
        //section_assignment2();
        //section13_ss();
        search_filter();




    }

    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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




    public static void section13_ss() throws IOException {
        //login page- verify login url


        driver.get("http://google.com");

        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("D:\\New folder\\screen2.png"));
        driver.quit();
    }



}
