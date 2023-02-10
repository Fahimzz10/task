package org.example;


import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Section14 {
    public static WebDriver driver;


    public static void main(String[] args) throws IOException {
        chrome_launch();
        //relative_locator();
        //filter();
        //screenshot_partial();
        search_filter();

    }

    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    public static void screenshot_partial() throws IOException {
        driver.get("https://rahulshettyacademy.com/angularpractice/");

                             //Switching Window

        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentWindowId = it.next();
        String childWindow =it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentWindowId);
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);
                                //Screenshot

        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("D:\\Automation\\Automation2\\sss3.png"));
                               //GEt Height & Width
        System.out.println(name.getRect().getDimension().getHeight());

        System.out.println(name.getRect().getDimension().getWidth());
    }

    public static void relative_locator(){
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
        WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
        WebElement rdb = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
    }
    public static void filter(){
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());


    }

    public static void search_filter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://test-admin.chargeonsite.com/login");
        driver.findElement(By.cssSelector("input[placeholder=Email]")).sendKeys("jo@email.com");
        driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys("2&57DyhUTH1c");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        // Locate the dropdown element
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Properties')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Chargers')]")).click();
        driver.findElement(By.xpath("//button[contains(.,'Add Advance Filter')]")).click();
        WebElement dropdown = driver.findElement(By.xpath("(//div[@class='ant-select-selection-overflow'])[1]"));
        Select menu= new Select(dropdown);
        menu.selectByVisibleText("New Updated Property");
        //identify menu
//        WebElement n=driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Properties')]"));
//        // Create a new instance of the Select class
//        // object of Actions with method moveToElement
//        Actions a = new Actions(driver);
//        a.moveToElement(n).click().perform();
        //driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Properties')]")).click();
        //driver.findElement(By.xpath("(//div[@class='ant-select-selection-overflow'])[1]")).click();
        //driver.findElement(By.xpath("Xpath /html/body/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div/div/div")).sendKeys(Keys.DOWN);



    }
}
