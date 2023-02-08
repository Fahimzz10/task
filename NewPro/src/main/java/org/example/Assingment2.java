package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Assingment2 {
    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        //assign2();
        //handling_alerts();
        alternate_assignment2();

    }


    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void assign2(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("rahul");
        driver.findElement(By.name("email")).sendKeys("hello@abc.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select abc = new Select(dropdown);
        abc.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("02/02/1992");
        driver.findElement(By.cssSelector(".btn-success")).click();
        //System.out.println(driver.findElement(By.cssSelector("body > app-root > form-comp > div > div:nth-child(2) > div")).getText());
        System.out.println(driver.findElement(By.cssSelector(".alert-dismissible")).getText());

        //System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
    }
    public static void alternate_assignment2(){

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Sakib");
        driver.findElement(By.name("email")).sendKeys("Salhasn18@hotmail.com");
        driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("skass@18");
        driver.findElement(By.xpath("//input[contains(@id,'Check1')]")).click();
        WebElement Dropdown = driver.findElement(By.cssSelector("select[id*='Form']"));
        Select options = new Select(Dropdown);
        options.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("26-10-1789");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String display = driver.findElement(By.cssSelector("div[class*='alert']")).getText();
        System.out.println(display);
        driver.close();
    }
}
