package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Section11 {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        //link_count();
        //Footer_linkcount();
        //click_eachlink();
        //rowlinkcout_footer();
        //pagename_link();
        //assignment_done();
        select_date();



    }
    public static void chrome_launch() {
        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Automation2\\NewPro\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //How many links are present on the screen
    public static void link_count(){
        driver.get("http://qaclickacademy.com/practice.php");
        int linkcount= (driver.findElements(By.tagName("a")).size());
        System.out.println(linkcount);
    }
    public static void Footer_linkcount(){
        driver.get("https://www.amazon.com/");
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]"));
        int footerlinks = footer.findElements(By.tagName("a")).size();
        System.out.println(footerlinks);
    }

    public static void rowlinkcout_footer(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement Footerrow = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[1]"));
        int footerlinks = Footerrow.findElements(By.tagName("a")).size();
        System.out.println(footerlinks);
    }

    //Click on the each link of the footer and get the title of each page

    public static void click_eachlink() {
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        WebElement footercolumn = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        for (int i = 1; i < footercolumn.findElements(By.tagName("a")).size(); i++) {
            String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            //footercolumn.findElements(By.tagName("a")).get(i).click();
            footercolumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
        }
        Set url = driver.getWindowHandles();
        Iterator<String> it = url.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }

    public static void pagename_link(){
            driver.get("http://qaclickacademy.com/practice.php");
            System.out.println(driver.findElements(By.tagName("a")).size());
            WebElement footerdriver=driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
            System.out.println(footerdriver.findElements(By.tagName("a")).size());
            WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
            System.out.println(coloumndriver.findElements(By.tagName("a")).size());

            // Verifying: click on each link in the coloumn and check if the pages are opening-
            for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
            {

                String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);

                coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
                //Thread.sleep(5000L);

            }// opening all the tabs
            Set<String> abc=driver.getWindowHandles();//4
            Iterator<String> it=abc.iterator();

            while(it.hasNext())
            {

                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());

            }
        }



    public static void assignment_done(){
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("checkBoxOption3")).click();
        String option=driver.findElement(By.id("checkBoxOption3")).getText();
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        Select s =new Select(dropdown);
        s.selectByVisibleText(option);
        driver.findElement(By.name("enter-name")).sendKeys(option);
        driver.findElement(By.id("alertbtn")).click();
        String text=  driver.switchTo().alert().getText();
        if(text.contains(option))
        {
            System.out.println("Alert message Showing");
        }
        else
            System.out.println("Something wrong with alert message");

    }
    //*[@id="checkBoxOption3"]

    public static void select_date(){
        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         //April 23
        driver.findElement(By.xpath("//*[@id=\"form-field-travel_comp_date\"]")).click();
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }
        List<WebElement> dates= driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
        int count=driver.findElements(By.className("day")).size();
        for(int i=0;i<count;i++)
        {
            String text=driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("21"))
            {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }
}
