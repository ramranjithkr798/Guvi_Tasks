package Guvi_Tasks.Task_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Snapdeal {
    ChromeDriver driver;
    @BeforeTest
    public void before(){
        driver = new ChromeDriver();
        driver.get("http://www.snapdeal.com");
        driver.manage().window().maximize();
    }

    @Test
    public void snapDeal() throws InterruptedException {
        Actions action=new Actions(driver);
        WebElement link=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div"));
        action.moveToElement(link).build().perform();
        WebElement login=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]"));
        login.click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("test123@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"checkUser\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[8]/div[2]/form/div[1]/input"))
                .sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/div/div/div[8]/div[2]/form/button"))
                .click();
        boolean flag=driver.getCurrentUrl().contains("loginSuccess=success");
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains("loginSuccess=success")) {
        	System.out.println("Login is success");
        }
        else {
			System.out.println("Login is failure");
		}
        Assert.assertFalse(flag);
	}

    @AfterTest
    public void after(){
        driver.close();
    }
}
 