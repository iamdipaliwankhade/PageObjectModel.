package com.loggerTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.log4testng.Logger;

public class GenerateLogs {
	
	public static void main(String[] args) {
			
		Logger log = Logger.getLogger(GenerateLogs.class);
		WebDriver driver = new ChromeDriver();
		
		log.info("launching browser");
		driver.get("http://www.facebook.com/");
		log.info("chrome url has been launched");
		
		String title = driver.getTitle();
		System.out.println("title value is: "+ title);
		
		log.info("title value is : "+ title);
		
		if(title.equals("Chrome")) {
			System.out.println("correct title is chrome");
			log.info("Correct title is Chrome and test cases is passed");
			
		}else {
			System.out.println("correct title is not chrome");
			log.info("Correct title is not Chrome and test cases is failed");
			
		}
		driver.quit();
		log.info("browser is closed");
		
		
		

		}

	}


