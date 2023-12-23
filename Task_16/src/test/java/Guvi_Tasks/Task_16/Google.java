package Guvi_Tasks.Task_16;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Google {

	public static void main(String[] args) {

		FirefoxDriver driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Current URL of the page is:"+driver.getCurrentUrl());
		driver.navigate().refresh();
		driver.close();
	}

}
