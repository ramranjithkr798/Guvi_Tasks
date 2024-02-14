import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuviRegisterLogin {
    ChromeDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.guvi.in/");
        driver.manage().window().maximize();
    }
    @Test
    public void guviRegisterLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"accountGroup\"]/ul/li[2]/a")).click();
        driver.findElement(By.id("name")).sendKeys("Name");
        driver.findElement(By.cssSelector("#email")).sendKeys("Test1234@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test123@123");
        driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");
        driver.findElement(By.xpath("//a[@id='signup-btn']")).click();
        driver.get("https://www.guvi.in/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"accountGroup\"]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@123");
        driver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(),"GUVI | courses");

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
