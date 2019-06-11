package com.selenium.dataProvider;

import org.testng.annotations.Test;

import com.utils.Config;

import org.testng.annotations.DataProvider;

public class loginDataProvider {
	Config config = new Config("config.properties");
  @DataProvider(name = "loginData")
  public Object[][] data() {
		String excelName=config.getConfig("excelName");
		return ReadExcel.readDataFromExcel(excelName, 0);
    };
  }
