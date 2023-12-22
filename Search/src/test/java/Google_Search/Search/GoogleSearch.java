package Google_Search.Search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //APjFqb -> box
        //By -> locators -> id ,name , css , tagname , linkText , partial
        WebElement element = driver.findElement(By.id("APjFqb"));
        element.sendKeys("Selnium Browser Driver");
        element.sendKeys(Keys.ENTER);
//        driver.quit();

	}

}
