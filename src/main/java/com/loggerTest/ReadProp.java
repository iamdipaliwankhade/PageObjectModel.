package com.loggerTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProp {
	
	public static void main(String[] args) throws IOException {
			WebDriver driver = null;
			// TODO Auto-generated method stub
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Dipal\\eclipse-workspace\\PageObjectModel\\src"
					+ "\\main\\java\\com\\facebook\\qa\\config\\config.properties");
			prop.load(ip);
			System.out.println(prop.getProperty("browser"));
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Dipal\\Downloads\\chromedriver_win32\\chromedriver.exe");
				 driver =new ChromeDriver();
				 
			}else {
				System.out.println("no browser value is given");
			}
			driver.get(prop.getProperty("url"));
			driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("pass")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.name("login")).click();
	}
}
			
			
			
			
		
		
	


