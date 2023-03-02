package com.facebook.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.AddStory;

public class AddStoryTest extends TestBase {
		public AddStory FbPg;

		public AddStoryTest() {
			super();
		}
		
		@BeforeMethod
		
			public void setUp() {
			initialization();
				FbPg = new AddStory();
			}
		@Test
		public void FB_Addtest() throws InterruptedException, AWTException, IOException {
			FbPg.FB_Add_story(prop.getProperty("email"),prop.getProperty("password"));
		}
		
		public void tearDown() throws InterruptedException {
			Thread.sleep(4000);
			driver.quit();
		}

	}


