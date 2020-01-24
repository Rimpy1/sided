package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.testng.Assert;

//import org.testng.annotations.AfterGroup;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterGroup;
import org.testng.annotations.Test;

 
public class Grouping 
{
	public WebDriver driver;
	
	
	
	@Test (groups= {"Case1"})
	
	public void Case1() throws java.lang.IllegalStateException, org.openqa.selenium.ElementClickInterceptedException, InterruptedException
	  {
	 
	 // Find the element that's ID attribute is 'account'(My Account)
	 
	     
	     
	      
	      
	      // Find the element that's ID attribute is 'log' (Username)
	 
	      // Enter Username on the element found by above desc.
	    Thread.sleep(3000);
	  	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	 
	      // Find the element that's ID attribute is 'pwd' (Password)
	 
	      // Enter Password on the element found by the above desc.
	 
	  	driver.findElement(By.id("pwd")).sendKeys("user123");
	 
	      // Now submit the form. WebDriver will find the form for us from the element
	 
	  	driver.findElement(By.xpath("//*[@id='login']/button")).click();
	 
	      // Print a Log In message to the screen
	 
	      System.out.println("Login Successfully");
	 
	      // Find the element that's ID attribute is 'account_logout' (Log Out)
	 
	      //driver.findElement(By.id("account_logout"));
	    
	    
	  }
		
	@Parameters({"browser"})
	@BeforeMethod
	 
	  public void beforeMethod(String browser) 
		{
	 
	   // Create a new instance of the Firefox driver
//		  System.setProperty("webdriver.gecko.driver","F:/selenium stuff/geckodriver.exe");
//	      driver = new FirefoxDriver();
			if(browser.equalsIgnoreCase("firefox")) 
			   {
				   System.setProperty("webdriver.gecko.driver","F:/selenium stuff/geckodriver.exe");
			      driver = new FirefoxDriver();
			      driver.manage().deleteAllCookies();
			    }
			   else if(browser.equalsIgnoreCase("chrome"))
			   {
				   System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
		     	   driver = new ChromeDriver();
		     	  driver.manage().deleteAllCookies();
			   }
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	 
	      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 
	      //Launch the Sided Website
	 
	      driver.get("https://stage.sided.co/");
	      
	      driver.manage().window().maximize();
          driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
	      
	      driver.findElement(By.xpath("//*[@href='#']")).click();
	      
	 
	  }
	 
	  @AfterMethod
	 
	  public void afterMethod() throws InterruptedException {
	 
	   // Close the driver
	     //Thread.sleep(5000);
	    driver.quit();
	 
	  }
 
  @Test (groups = { "Case2" })
 
  public void Case2() throws InterruptedException 
  {
	Thread.sleep(8000);
	driver.findElement(By.xpath("//*[@id='login']/button")).click();
	System.out.println("check the user is not able to login with blank email and pass. fields.");
//	String actual1=driver.findElement(By.xpath("//*[@id='email-error']")).getText();
//	String expected1="The email or username is required.";
//	
//	Assert.assertEquals(actual1, expected1);
//	
//	String actual2=driver.findElement(By.xpath("//*[@id='pwd-error']")).getText();
//	String expected2="The password field is required.";
//	
//	Assert.assertEquals(actual2, expected2);
  
  }
 
 @Test (groups = { "Case3" })
 
  public void Case3() throws InterruptedException 
  {
 
   System.out.println("Check if email id is not exist");
   driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user30@mailinator.com");
	
	driver.findElement(By.id("pwd")).sendKeys("user123");
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id='login']/button")).click();
	
//	String actual3=driver.findElement(By.xpath("//*[@id='email-error']")).getText();
//	String expected3="These credentials do not match our records.";
//   
//	Assert.assertEquals(actual3, expected3);
  
  }
 
  @Test (groups = { "Case4" })
 
  public void Case4() throws InterruptedException {
 
   System.out.println("check if email id is exist but incorrect password");
   driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	
	driver.findElement(By.id("pwd")).clear();
	
	driver.findElement(By.id("pwd")).sendKeys("user1233");
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id='login']/button")).click();
	
//	String actual4=driver.findElement(By.xpath("//*[@id='email-error']")).getText();
//	String expected4="These credentials do not match our records.";
// 
//	Assert.assertEquals(actual4, expected4);
  }
 
  @Test (groups = {"Case5"})
 
  public void Case5() throws InterruptedException 
  {
 
   System.out.println("check if user is able to login with correct email id and password");
   driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	
	driver.findElement(By.id("pwd")).clear();
	
	driver.findElement(By.id("pwd")).sendKeys("user123");
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id='login']/button")).click();
  
  }
	
	 
	}