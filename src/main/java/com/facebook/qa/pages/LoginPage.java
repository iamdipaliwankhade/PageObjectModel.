package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginBotton;
	
	@FindBy(xpath="//img[@alt='Facebook']")
	WebElement facebookLogo;

	@FindBy(xpath="//div[@class='_6ltj']")
	WebElement forgetpassword;
	
	@FindBy(xpath="//a[contains(text(),'Create a Page')]")
	WebElement createAPage;
	
	//initializing page object
	public LoginPage () {
		PageFactory.initElements(driver,this);
	}
	//actions
	public boolean validFacebookLogo() {
		return facebookLogo.isDisplayed();
				
	}
	public HomePage login (String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBotton.click();
		return new HomePage();
	}
	
	public void multipleUserLogin(String un, String pw) {
		 username.sendKeys(un);
		 password.sendKeys(pw);
		 password.click();
		 
	 }
	

}


