package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameters
{
private static WebDriver driver;

@Test
@Parameters({"sUsername", "sPassword"})
public void test(String Username, String Password) throws InterruptedException
{
	
	   System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
	   driver = new ChromeDriver(); 
 	   driver.get("https://stage.sided.co/");
 	   driver.manage().window().maximize();
 	   Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath("//*[@href='#']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath("//*[@id='email']")).sendKeys(Username);
      Thread.sleep(4000);
     driver.findElement(By.id("pwd")).sendKeys(Password);
 
     Thread.sleep(4000);
  	driver.findElement(By.xpath("//*[@id='login']/button")).click();
     System.out.println("Login Successfully");
     
     Thread.sleep(4000);
 }
}
