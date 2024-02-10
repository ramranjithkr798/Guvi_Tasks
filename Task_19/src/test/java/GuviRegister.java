import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuviRegister {
    ChromeDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.guvi.in/register");
        driver.manage().window().maximize();
    }

    @Test
    public void registerName(){
        driver.findElement(By.id("name")).sendKeys("Data sending to ");
        driver.findElement(By.className("form-control")).sendKeys("Name ");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("using multiple ");
        driver.findElement(By.tagName("input")).sendKeys("different ");
        driver.findElement(By.cssSelector("#name")).sendKeys("identifiers");
    }

    @Test
    public void registerEmail(){
        driver.findElement(By.id("email")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("efg");
        driver.findElement(By.cssSelector("#email")).sendKeys("@gmail.com");
    }

    @Test
    public void registerPassword(){
        driver.findElement(By.id("password")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("@123");
        driver.findElement(By.cssSelector("#password")).sendKeys("!");
    }

    @Test
    public void registerPhoneNo(){
        driver.findElement(By.id("mobileNumber")).sendKeys("9876");
        driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("5432");
        driver.findElement(By.cssSelector("#mobileNumber")).sendKeys("10");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
