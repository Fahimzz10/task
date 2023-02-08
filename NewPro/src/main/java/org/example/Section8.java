package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Section8 {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        additem();

    }
    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void additem(){
        String[] itemsNeeded= {"Cucumber","Cauliflower","Beetroot","Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        int j=0;
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++) {
            //Brocolli - 1 Kg
            // Brocolli,    1 kg

            String[] name=products.get(i).getText().split("-");
            String formattedName=name[0].trim();
            //format it to get actual vegetable name
            // convert array into array list for easy search
            // check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(formattedName)) {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemsNeeded.length) {
                    break;
                }
            }
        }
    }

}











