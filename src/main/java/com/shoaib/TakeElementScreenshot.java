package com.shoaib;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeElementScreenshot {

	public static void main(String[] args) throws IOException {
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		WebElement email = driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		WebElement password = driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		
		takeElementScreenshot(email, "emailElement");
		takeElementScreenshot(password, "passwordElement");
		takeElementScreenshot(loginButton, "loginButtonElement");

		driver.quit();

	}

	public static void takeElementScreenshot(WebElement element, String fileName) {
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
