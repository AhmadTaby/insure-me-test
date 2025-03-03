package com.selenium.test.insure_me_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// load the driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);

        driver.get("http://18.117.151.196:8081/contact.html");

        driver.getTitle();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement name = driver.findElement(By.id("inputName"));
        name.sendKeys("First Name");
        WebElement number = driver.findElement(By.id("inputNumber"));
        number.sendKeys("999999999");
        WebElement email = driver.findElement(By.id("inputMail"));
        email.sendKeys("taby@gmail.com");
        WebElement message = driver.findElement(By.id("inputMessage"));
        message.sendKeys("Hello, how are you? ");
        WebElement submitButton = driver.findElement(By.id("my-button"));
        Thread.sleep(3000);
        submitButton.click();
        Thread.sleep(3000);

        WebElement response = driver.findElement(By.id("response"));
        response.getText();
        
        if(response.getText().equalsIgnoreCase("Message sent")) {
        	System.out.println("test case passed");
        }
        else
        {
        	System.out.println("test case failed");
        }
        Thread.sleep(3000);
        System.out.println(response.getText());
        Thread.sleep(3000);
        driver.quit();

	}
}
