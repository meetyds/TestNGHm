import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A_FirstTestNGTestCase {
    WebDriver driver;
    @BeforeTest
   // @Test(priority = 1)
    void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Software\\Driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        //System.out.println("This is Setup Method");
    }
    @Test//(priority = 2)
    void execute() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("//img[@alt='Picture for category Desktops']")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
        Thread.sleep(4000);

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
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
       driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Upton Park");
       driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("E13 OSN");
       driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9824661648");
       driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")).sendKeys("India");
       driver.findElement(By.xpath("//button[@class='button-1 new-address-next-step-button' and @name='save']")).click();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
       driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
       Thread.sleep(2000);
       driver.findElement(By.id("CreditCardType")).sendKeys("Visa");
       driver.findElement(By.xpath("//input[@name='CardholderName']")).sendKeys("Test");
       driver.findElement(By.name("CardNumber")).sendKeys("789412368523");
       driver.findElement(By.name("ExpireMonth")).sendKeys("05");
       driver.findElement(By.name("ExpireYear")).sendKeys("2026");
       driver.findElement(By.name("CardCode")).sendKeys("123");
       driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
    }
    @AfterTest
   // @Test(priority = 3)
    void closeBrowser()
    {
        driver.close();
       // driver.manage().window().
        //System.out.println("To close The Browser");
    }
}
