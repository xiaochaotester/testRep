package com.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	@FindBy(name="username")
	public WebElement user;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="submit")
	public WebElement submit;
	
	@FindBy(css="div.boxCenterList.RelaArticle>div>p:nth-of-type(1)")
	public WebElement login_result_text;
	
	public  LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void input_username(String userName)
	{
		user.sendKeys(userName);
	}
	
	public void input_password(String passWord)
	{
		//用excel读取进来的密码，自动加上小数点，需要根据“."进行字符串的分割，取整数部分
//		String[] passWd=passWord.split("\\.");
//		password.sendKeys(passWd[0]);
		password.sendKeys(passWord);
	}
	
	public void submit_click()
	{
		submit.click();
	}
	
	public void check_login_result(String exceptResult)
	{
		Assert.assertEquals(login_result_text.getText(), exceptResult);
	}

}
