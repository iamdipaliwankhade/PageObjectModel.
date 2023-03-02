package com.facebook.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class HomePage extends TestBase {
	
	

		@FindBy(xpath = "//input[contains(@class,'x1i10hfl')][1]")
		WebElement search;
		
		@FindBy(xpath = "//body/div[@id='mount_0_0_Os']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]")
		WebElement home;
	     @FindBy(xpath="//span[contains(text(),'Dipali Wankhade')]")
	 	WebElement profile ;
		// initializing page object
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		// actions
		public void serchFacebook(String serching) {
			search.sendKeys(serching,Keys.ENTER);
		}
		public void homebutton() {
			home.click();
	}
		public void profilelink() {
			profile.click();
	}}


