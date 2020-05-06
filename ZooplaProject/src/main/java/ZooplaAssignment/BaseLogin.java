package ZooplaAssignment;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Chrome Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
		
		driver.get("https://www.zoopla.co.uk/");
		
//		System.out.println(driver.getTitle());//Printed the Home page 
		
		driver.findElement(By.xpath("(//*[@type='button'])[2] ")).click(); //  This will Click the Accept Cookies
		
		System.out.println(driver.getCurrentUrl());
		
//		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//*[@class='button button--tertiary-dark account-link__text']")).click();

		driver.findElement(By.xpath("//*[@id='signin_email']")).sendKeys("constableval@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='signin_password']")).sendKeys("Couva1967!");
		
		driver.findElement(By.xpath("//*[@id='signin_submit']")).click();
				
		System.out.println(driver.getTitle());
	}
	}

