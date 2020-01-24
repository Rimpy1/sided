package TestNGData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class LoginTest 
{
 WebDriver driver;
 
 @BeforeMethod
 public void SetUp ()
 {
	 System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
	   driver = new ChromeDriver(); 
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   	WebDriverWait wait=new WebDriverWait(driver, 20);
	   	driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.get("https://stage.sided.co/");
	   
 }
 @DataProvider
 public Object[][] getLoginData()
 {
	 Object data [][]=TestUtil.getTestData("login");
	 return data;
 }
 
 
 
 
 @Test (dataProvider="getLoginData")
 public void loginTest(String username, String password)
 {
		
        driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
        
        driver.findElement(By.xpath("//*[@href='#']")).click();
        
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
        
       driver.findElement(By.id("pwd")).sendKeys(password);
   
       
    	driver.findElement(By.xpath("//*[@id='login']/button")).click();
       System.out.println("Login Successfully");
//       JavascriptExecutor js=(JavascriptExecutor) driver;
//       js.executeScript("arguments[0].click();", loginBtn);
       
 }
 
 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }


}
