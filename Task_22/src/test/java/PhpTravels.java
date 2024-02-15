import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PhpTravels {

    ChromeDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        driver.manage().window().maximize();
    }

    @Test
    public void phpTravels() throws IOException {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Test@test.com");

        //getting the data from element and adding it and sending the result
        int num1=Integer.parseInt(driver.findElement(By.xpath("//span[@id=\"numb1\"]")).getText());
        int num2=Integer.parseInt(driver.findElement(By.xpath("//span[@id=\"numb2\"]")).getText());
        int sum=num1+num2;
        driver.findElement(By.xpath("//input[@id=\"number\"]")).sendKeys(Integer.toString(sum));
        driver.findElement(By.xpath("//button[@id=\"demo\"]")).click();

        //using wait to verify if the element is there
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/h2")));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/h2")).getText(),"Instant demo request form");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[3]/h2/strong")));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"swup\"]/section[1]/div/div/div[1]/div/div/div/div/div/div/div/div[3]/h2/strong")).getText(),"Thank you!");

        //taking screenshot
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("C:\\Users\\ramra\\Desktop\\GUVI\\Task_22\\src\\test\\java\\screenshot.png"));
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
