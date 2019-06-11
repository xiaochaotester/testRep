package com.selenium.pageObject.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.dataProvider.loginDataProvider;
import com.selenium.pageObject.IndexPage;
import com.selenium.pageObject.LoginPage;
import com.utils.DriverUtils;
import com.utils.TestBase;

public class TestIndexPage extends TestBase{
  @Test(dataProvider="loginData",dataProviderClass=loginDataProvider.class)
  public void test(String username,String password,String exceptResult) throws InterruptedException {
	  System.setProperty("browser.type", "chrome");
	    WebDriver driver=DriverUtils.getDriver();
	    driver.get("http://localhost:5555/ecshop");
	    Thread.sleep(1000);
	    IndexPage indexPage=new IndexPage(driver);
	    indexPage.loginLink_click();
	    Thread.sleep(1000);
	    LoginPage loginPage=new LoginPage(driver);
	    loginPage.input_username(username);
	    loginPage.input_password(password);
	    loginPage.submit_click();
	   // System.out.println(driver.getPageSource()); 获取页面源码
	    loginPage.check_login_result(exceptResult);
	    Thread.sleep(5000);
	    driver.quit();
	    		
	    
  }
}
