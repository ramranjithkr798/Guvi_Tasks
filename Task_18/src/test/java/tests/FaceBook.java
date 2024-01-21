package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FaceBook {
    ChromeDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void faceBook() throws InterruptedException {
        driver.findElement(By.
                xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"))
                .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/input"))
                .sendKeys("Test");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div[1]/div[2]/div/div[1]/input"))
                .sendKeys("User");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div/div[1]/input"))
                .sendKeys("testUser@test.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"))
                .sendKeys("testUser@test.com");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']"))
                .sendKeys("Test@123");
        WebElement day=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select=new Select(day);
        select.selectByValue("11");
        WebElement month=driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select monthSelect=new Select(month);
        monthSelect.selectByValue("5");
        WebElement year=driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select yearSelect=new Select(year);
        yearSelect.selectByValue("1985");

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input"))
                .click();
        driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"))
                .click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
