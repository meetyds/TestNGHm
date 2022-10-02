import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.Set;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    //@Test
    void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Software\\Driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

    }
    @Test
    void execute() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("//img[@alt='Picture for category Desktops']")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        driver.findElement(By.xpath("//input[@class='qty-input']")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        driver.findElement(By.name("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[text()='Checkout as Guest']")).click();

        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Meet");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Patel");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Unify Testing");
        //DropDown
        //Select drp = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Upton Park");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("E13 OSN");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9824661648");
        driver.findElement(By.xpath("//button[@class='button-1 new-address-next-step-button' and @name='save']")).click();

    }
    @AfterTest
    //@Test
    void frame()
    {
       // WebElement frame=driver.findElement(By.tagName("<a href=\"/cart\">shopping cart</a>"));
       // driver.switchTo().frame("frame");
        //driver.switchTo().frame("//*[@id=\"bar-notification\"]/div/p");
        //driver.findElement(By.xpath("//a[text()='shopping cart']")).click();
        //driver.findElement(By.)
     /*   Set<String> wids=driver.getWindowHandles();
        if (wids.size()>1)
        {
            driver.switchTo().window("give name or window handle");
            try {
                WebElement elementOnPopup=driver.findElement(By.xpath("//a[text()='shopping cart']"));
                if (elementOnPopup.isDisplayed())
                {
                    elementOnPopup.click();
                }
            }catch (NoSuchElementException ne){
                System.out.println("Alert is Displayed");
            }
        }
        else
        {
            System.out.println("Popup Window is Not Displayed");
        }*/
    }
}
