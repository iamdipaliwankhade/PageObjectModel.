package com.facebook.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datadriventest.DataDrivenTest;
import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

import dev.failsafe.internal.util.Assert;

public class LoginPageTest extends TestBase {
     
	public DataDrivenTest utility;
	
	public String sheetname = "Sheet1";
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginTest() {

		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2)
	public void facebooklogo() {
		boolean flag = loginPage.validFacebookLogo();
		assertTrue(flag);
	}
	
	@DataProvider
	public Object[][]getLoginDetails() throws InvalidFormatException{
		Object data[][]=utility.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getLoginDetails",priority=3)
	public void MultiUserLogin(String un, String pw) {
		loginPage.multipleUserLogin(un,pw);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
	
}