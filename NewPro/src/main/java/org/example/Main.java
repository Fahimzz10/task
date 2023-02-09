package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        //open_website();
        //select_checkbox();
        //add_cart();
        //udemy_Assingment();
        //assignment_alternative();
        handling_alerts();



    }

    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void open_website() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://test-app.chargeonsite.com/customer/login");
        driver.findElement(By.cssSelector("input[placeholder=Email]")).sendKeys("sabihatesting.01@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys("T7777777");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
//        for (int i = 0; i <3 ; i++){
//            driver.findElement(By.xpath("//*[@id=\"map\"]/div/div/div[13]/div/div/div/button[1]")).click();
//            //Thread.sleep(2000);
//        }
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

    public static void select_checkbox(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
          //boolean isnotchecked = driver.findElement(By.cssSelector("input[type=checkbox]")).isSelected();
//        System.out.println(isnotchecked);
//        if (isnotchecked=true){
//            driver.findElement(By.xpath("//*[@id=\"checkBoxOption1\"]")).click();
//
//        }
        //count the number of checkbox
//        int sizeofCheckbox= driver.findElements(By.cssSelector("input[type=checkbox]")).size();
//        System.out.println(sizeofCheckbox);


        //click all checkboxes
        List <WebElement> AllCheckboxes =  driver.findElements(By.cssSelector("input[type=checkbox]"));

        int size = AllCheckboxes.size();
        System.out.println(size);

        for(int i = 0; i<size; i++) {

            String value = AllCheckboxes.get(i).getAttribute("option1");

            AllCheckboxes.get(i).click();
        }

        //check checkbox is selected or not
        WebElement chkbox = driver.findElement(By.cssSelector("input[type=checkbox]"));

        if(chkbox.isSelected()) {

            System.out.println("Checkbox is ON");
        }
        else {


            System.out.println("Checkbox is Off");
        }



    }
//  Question: Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
    public static void udemy_Assingment(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox = driver.findElement(By.cssSelector("input[type=checkbox]"));
        checkbox.click();

        //verify
        if(checkbox.isSelected()) {

            System.out.println("Successfully Checked");
        }
        else {
            System.out.println("unchecked");
        }
        WebElement checkbox1 = driver.findElement(By.cssSelector("input[type=checkbox]"));
        checkbox1.click();

        //verify
        if(checkbox1.isSelected()) {

            System.out.println("Successfully Checked");
        }
        else
        {
            System.out.println("unchecked");
        }

        //count the number of checkbox
        int sizeofCheckbox= driver.findElements(By.cssSelector("input[type=checkbox]")).size();
        System.out.println(sizeofCheckbox);

    }

                                          // Alternate way to solve the assignment1
    public static void assignment_alternative(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();

        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected()); //Should Print True

        driver.findElement(By.id("checkBoxOption1")).click();

        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected()); //Should Print false

    }
    public static void handling_alerts(){

        String text="Rahul";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();

    }





}






