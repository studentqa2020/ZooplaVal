package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.Wait;

public class BaseLogin {

	
	
	public static void getLogin() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		WebDriver driver = new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(BaseConfig.getconfig("URL"));
        
        driver.findElement(By.xpath("(//*[@type='button'])[2] ")).click(); //  This will Click the Accept Cookies
        
        LoginPage login =new LoginPage(driver);
        
        System.out.println(driver.getTitle());
        
        login.getLogin().click();// click
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Wait.getExplicitWaitClicable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		login.getSubmit().click();
		
		new Highlighter().getcolor(driver, login.getPass(),"red");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		
		Thread.sleep(3000);
		
	login.getSubmit().click();
		
System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
	}

