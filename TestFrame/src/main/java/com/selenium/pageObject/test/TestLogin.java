package com.selenium.pageObject.test;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.dataProvider.loginDataProvider;
import com.selenium.pageObject.IndexPage;
import com.selenium.pageObject.LoginPage;
import com.utils.TestBase;

public class TestLogin extends TestBase {
	@Test(dataProvider="loginData",dataProviderClass=loginDataProvider.class)
	public void test(String username,String password,String expectedResult) throws InterruptedException {
		driver.get("http://localhost:5555/ecshop");
		IndexPage indexPage=new IndexPage(driver);
		indexPage.loginLink_click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.input_username(username);
		loginPage.input_password(password);
		loginPage.submit_click();
//        System.out.println(driver.getPageSource());
		loginPage.check_login_result(expectedResult);
		Thread.sleep(3000);

	}
}
