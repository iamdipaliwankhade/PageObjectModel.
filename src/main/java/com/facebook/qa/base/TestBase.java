package com.facebook.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.facebook.qa.util.TestUtil;

public class TestBase {
	public static Logger Log = Logger.getLogger(TestBase.class);
	
	
	public static WebDriver driver;
    public static Properties prop;
    
    public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	
	public  TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Dipal\\eclipse-workspace\\PageObjectModel\\"
					+ "src\\main\\java\\com\\facebook\\qa\\config\\config.properties");
					
					
			prop.load(ip);
	 	}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
					
		} 
		
}
	public static void initialization() {
		Log.info("Browser Name :"+ prop.getProperty("browser"));
		String browserName =prop.getProperty("browser");
		if(browserName.equals("chrome")){
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dipal\\Downloads\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();
	   Log.info("app url:"+ prop.getProperty("url"));
		}
		
		driver.get(prop.getProperty("url"));
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
	}
}
