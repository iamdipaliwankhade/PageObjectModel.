package com.facebook.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.SignUpPage;

public class SignUpTest extends TestBase{


	public SignUpPage signUpPage;

		public SignUpTest() {
			super();
		}
		
		@BeforeMethod
		//in this anotation first we calling properties in parent class then we are doing initialization
			public void setUp() {
			initialization();
				signUpPage = new SignUpPage();
			}
		@Test
		public void SignUpPageTest() throws InterruptedException {
			signUpPage.Signup(prop.getProperty("FirstName"),
					prop.getProperty("LastName"),
					prop.getProperty("Email"),
					prop.getProperty("ReEnterEmail"),
					prop.getProperty("newPass"),
					prop.getProperty("days"),
					prop.getProperty("months"),
					prop.getProperty("years"));
		}
		
		@AfterMethod
		public void tearDown() throws InterruptedException  {
			Thread.sleep(4000);
		
			driver.quit();
			
		}
	}