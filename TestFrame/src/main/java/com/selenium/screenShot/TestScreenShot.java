package com.selenium.screenShot;

import java.io.File;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.bcel.generic.NEW;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.internal.ExitCode;

public class TestScreenShot extends TestListenerAdapter{

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		Field field;
	
			try {
				field = tr.getTestClass().getRealClass().getField("driver");//反射机制获取的driver的成员变量
				WebDriver driver=(WebDriver)field.get(tr.getInstance());//获取当前测试的driver值
				File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//获取截图的file
				//判断根目录是否有这个文件，没有则创建1个
				File screenShotDir=new File("screenShots");
				if(!screenShotDir.exists() && !screenShotDir.isDirectory()) {
					screenShotDir.mkdirs();
				}
				
				String classname=tr.getTestClass().getName();//获取当前测试的类名
				String methodName=tr.getName();//获取当前测试的方法名
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS");
				String time=dateFormat.format(new Date());//获取当前的日期
				file.renameTo(new File(screenShotDir,classname+"_"+methodName+"_"+time+".png"));//将file设置图文件名称
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		super.onTestFailure(tr);
	}
	

}
