package Guvi_Tasks.Task_16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        //searchInput
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys("Artifical Intelligence");
        searchField.sendKeys(Keys.ENTER);
        WebElement history=driver.findElement(By.xpath("//*[@id=\"ca-history\"]/a/span"));
        history.click();
        System.out.println(driver.getTitle());
        driver.quit();
	}

}
