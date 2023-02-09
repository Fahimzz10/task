package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Section10 {
    public static WebDriver driver;


    public static void main(String[] args) {
        chrome_launch();
        //handle_frame();
        action_perform();

    }

    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void handle_frame(){
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());


    }
    public static void action_perform(){
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[class='nav-a nav-a-2   nav-progressive-attribute']"));
        //action.moveToElement(move).build().perform();
        //action.moveToElement(move).contextClick().build().perform();
        action.contextClick(move).perform();
        System.out.println("Context Menu displayed");
    }
}
