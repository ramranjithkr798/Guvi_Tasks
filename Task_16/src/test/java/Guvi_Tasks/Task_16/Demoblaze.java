package Guvi_Tasks.Task_16;

import org.openqa.selenium.chrome.ChromeDriver;

public class Demoblaze {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        if(driver.getTitle().equals("STORE"))
        	System.out.println("Page landed on correct website");
        else
        	System.out.println("Page not landed on correct website");
        driver.quit();
	}

}
