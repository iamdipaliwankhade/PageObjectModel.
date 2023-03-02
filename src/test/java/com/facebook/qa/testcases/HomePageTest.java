package com.facebook.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
public class HomePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homepage;

	public HomePageTest() {
		super();

	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 2)
	public void searchingFacebook() throws InterruptedException {
		Thread.sleep(2000);
		homepage.serchFacebook(prop.getProperty("search"));
	}
	@Test(priority = 1)
	public void homebtn() throws InterruptedException {
		Thread.sleep(2000);
		homepage.homebutton();

	}
	@Test(priority = 3)
	public void namelink() throws InterruptedException {
		Thread.sleep(2000);
		homepage.profilelink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


