import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JqueryuiCalendar {
    ChromeDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
    }
    @Test
    public void setDate() throws InterruptedException {
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@title='Next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-date='22']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value"));
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
