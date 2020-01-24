package TestNG;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
@Listeners(utility.Listener.class)

public class TestListener {
 
public WebDriver driver;
	
@Test
 
public void main() throws java.lang.IllegalStateException, org.openqa.selenium.ElementClickInterceptedException, InterruptedException
  {
 
 // Find the element that's ID attribute is 'account'(My Account)
	 Thread.sleep(5000);
    driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
      
      driver.findElement(By.xpath("//*[@href='#']")).click();
      
      // Find the element that's ID attribute is 'log' (Username)
 
      // Enter Username on the element found by above desc.
 
  	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
 
      // Find the element that's ID attribute is 'pwd' (Password)
 
      // Enter Password on the element found by the above desc.
 
  	driver.findElement(By.id("pwd")).sendKeys("user123");
 
      // Now submit the form. WebDriver will find the form for us from the element
 
  	Thread.sleep(4000);
  	driver.findElement(By.xpath("//*[@id='login']/button")).click();
 
      // Print a Log In message to the screen
 
      System.out.println("Login Successfully");
 
      // Find the element that's ID attribute is 'account_logout' (Log Out)
 
      //driver.findElement(By.id("account_logout"));
    
    
  }
 
	@Parameters({"browser"})
	@BeforeMethod
 
  public void beforeMethod(String browser) {
 
   // Create a new instance of the Firefox driver
//	  
//	  
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	   if(browser.equalsIgnoreCase("firefox")) 
	   {
		   System.setProperty("webdriver.gecko.driver","F:/selenium stuff/geckodriver.exe");
	      driver = new FirefoxDriver();
	    }
	   else if(browser.equalsIgnoreCase("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
     	   driver = new ChromeDriver(); 
	   }
	   
	   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
 
      //Launch the Sided Website
 
      driver.get("https://stage.sided.co/");
      
      driver.manage().window().maximize();
      
 
  }
 
  @AfterMethod
 
  public void afterMethod() throws InterruptedException {
 
   // Close the driver
     //Thread.sleep(5000);
    // driver.quit();
 
  }
 
}