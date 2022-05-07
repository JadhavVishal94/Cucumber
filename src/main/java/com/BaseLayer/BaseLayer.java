package com.BaseLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseLayer {
	public static WebDriver driver;
	public static Properties prop;
	public BaseLayer()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Vishal\\eclipse-workspace\\OrangeHRMFrame\\src\\main\\java\\com\\Config\\config.propertiesOrangeHrm");
			prop.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		
	
	public static void initialization()
	{
		String browsername=prop.getProperty("browserName");
		if(browsername.equals("chrome"))
		{
		      System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		     driver =new ChromeDriver();
		}
		else if(browsername.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browsername.equals("opera"))
		{
			System.setProperty("webdriver.opera.driver",System.getProperty("user.dir") +"\\Drivers\\operadriver.exe");
			driver=new OperaDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageloadTime"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		driver.manage().deleteAllCookies();
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.get(prop.getProperty("url"));
	}
	
	
	
		
	}
	
	




