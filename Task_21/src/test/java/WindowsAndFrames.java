import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsAndFrames {
    ChromeDriver driver;
    String baseUrl;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        baseUrl="https://the-internet.herokuapp.com/";
        driver.manage().window().maximize();
    }
    @Test
    public void iframe(){
        driver.get(baseUrl+"iframe");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).clear();
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("Hello People");
    }

    @Test
    public void windows(){
        driver.get(baseUrl+"windows");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(windows);
        driver.switchTo().window(windowsList.get(1));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h3")).getText(),"New Window");
        driver.close();
        driver.switchTo().window(windowsList.get(0));
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void nestedFrames() {
        driver.get(baseUrl + "nested_frames");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        List<WebElement> frameCount = driver.findElements(By.tagName("frame"));
        Assert.assertEquals(frameCount.size(),3);
        //switching to left frame
        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body")).getText(),"LEFT");
        //Switching to top frame
        driver.switchTo().parentFrame();
        //Switching to middle frame
        driver.switchTo().frame(1);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]")).getText(),"MIDDLE");
        //Switching to top frame
        driver.switchTo().parentFrame();
        //Switching to Right frame
        driver.switchTo().frame(2);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body")).getText(),"RIGHT");
        //Switching to top frame
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent(); //switching to main
        //Switching to bottom
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body")).getText(),"BOTTOM");
        driver.switchTo().defaultContent();
        Assert.assertNotEquals(driver.getTitle(),"Frames");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
