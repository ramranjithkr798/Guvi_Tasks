package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Jqueryui {
    ChromeDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
    }

    @Test
    public void dragBox(){
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),
                driver.findElement(By.xpath("//div[@id='droppable']")))
                .perform();
        //System.out.println(driver.findElement(By.xpath("//div[@id='droppable']")).getCssValue("background"));
        boolean flag=driver.findElement(By.xpath("//div[@id='droppable']")).
                getCssValue("background").contains("rgb(255, 250, 144)");
        Assert.assertTrue(flag);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/p")).getText(),"Dropped!");
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/p")).getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
