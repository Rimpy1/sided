package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Signup 
{
	public WebDriver driver;
    @Parameters({"browser"})
	
	@Test
	public void main(String browser) throws InterruptedException
    {
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
	
    driver.get("https://stage.sided.co");
	driver.manage().window().maximize();
	// Print a Log In message to the screen
	System.out.println("Sided Successfully opened");
    Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@href='#signup']")).click();
    Thread.sleep(2000);
    
    //=========check blanck fields error messages===============
    
    driver.findElement(By.xpath("//*[@id='register']/button")).click();
    Thread.sleep(2000);
              //expected error message for name field.
    
    String actual_mssg = driver.findElement(By.xpath("//*[@id='name-error']")).getText();
    Thread.sleep(2000);
    String expected_mssg="The name field is required.";
    
    if(actual_mssg.endsWith(expected_mssg))
    	{
    	System.out.println("The name field is required.");
    	}
    else
    	{
    	System.err.println("Wrong message for name field.");
    }
    Thread.sleep(2000);
    
    // expected error message for username field.
    String actual_mssg1 = driver.findElement(By.xpath("//*[@id='Username2-error']")).getText();
    Thread.sleep(2000);
    String expected_mssg1="The username field is required.";
    
    if(actual_mssg1.endsWith(expected_mssg1))
    	{
    	System.out.println("The username field is required.");
    	}
    else
    	{
    	System.err.println("Wrong message for username field.");
    }
    Thread.sleep(2000);
    
    //expected error message for email field.
    
    String actual_mssg2 = driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    Thread.sleep(2000);
    String expected_mssg2="The email field is required.";
    
    if(actual_mssg2.endsWith(expected_mssg2))
    	{
    	System.out.println("The email field is required.");
    	}
    else
    	{
    	System.err.println("Wrong message for email field.");
    }
    Thread.sleep(2000);
    
    //expected error message for password filed.
    
    String actual_mssg3 = driver.findElement(By.xpath("//*[@id='password2-error']")).getText();
    Thread.sleep(2000);
    String expected_mssg3="The password field is required.";
    
    if(actual_mssg3.endsWith(expected_mssg3))
    	{
    	System.out.println("The password field is required.");
    	}
    else
    	{
    	System.err.println("Wrong message for name field.");
    }
    Thread.sleep(2000);
    
    //expected error message for Terms of service and privacy policies.
    
    String actual_mssg4 = driver.findElement(By.xpath("//*[@id='agree-error']")).getText();
    Thread.sleep(2000);
    String expected_mssg4="To Sign up, you must agree to the Terms of Service and Privacy Policy.";
    
    if(actual_mssg4.endsWith(expected_mssg4))
    	{
    	System.out.println("To Sign up, you must agree to the Terms of Service and Privacy Policy.");
    	}
    else
    	{
    	System.err.println("Wrong message for name field.");
    }
    Thread.sleep(2000);
    
    //===============Check the user name is already existed or not==========
    
    driver.findElement(By.xpath("//*[@id='name']")).sendKeys("mikimikimikimikimikimikimikimikimikimikimikimikimikimikimiki");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='name']")).clear();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='name']")).sendKeys("user211");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='Username2']")).sendKeys("user123");
    Thread.sleep(3000);
    String actual_mssg5=driver.findElement(By.xpath("//*[@id='Username2-error']")).getText();
    String expected_mssg5="This username is unavailable or already taken. Please try another.";
    if(actual_mssg5.equals(expected_mssg5))
    {
    	System.out.println("This username is unavailable or already taken. Please try another.");
    }
    else
    {
    	System.err.println("Wrong message for username already exist");
    }
    
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//*[@id='Username2']")).sendKeys("user123");
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='Username2']")).clear();
    Thread.sleep(2000);
                //space in username
    driver.findElement(By.xpath("//*[@id='Username2']")).sendKeys("user 56");
    Thread.sleep(2000);
    String ac1=driver.findElement(By.xpath("//*[@id='Username2-error']")).getText();
    String ec1="Use only letter, number and _.";
    if(ac1.equals(ec1))
    {
    	System.out.println("Use only letter, number and _.");
    }
    else
    {
    	System.err.println("Wrong message for space in username.");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='Username2']")).clear();
    Thread.sleep(2000);
            //special charcter in username
    driver.findElement(By.xpath("//*[@id='Username2']")).sendKeys("user$%^&user");
    Thread.sleep(2000);
    String ac2=driver.findElement(By.xpath("//*[@id='Username2-error']")).getText();
    String ec2="Use only letter, number and _.";
    if(ac2.equals(ec2))
    {
    	System.out.println("Use only letter, number and _.");
    }
    else
    {
    	System.err.println("Wrong message for special character in username.");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='Username2']")).clear();
    Thread.sleep(2000);
     //=======================Check valid username format==========================
    
    driver.findElement(By.xpath("//*[@id='Username2']")).sendKeys("user231_user23");
    Thread.sleep(2000);
    
    //Check for email ID errors.
    
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user3@mailinator.com");
    Thread.sleep(2000);
    
    String actual_mssg6=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String expected_mssg6="The email has already been taken.";
    if(actual_mssg6.equals(expected_mssg6))
    {
    	System.out.println("The email has already been taken.");
    }
    else
    {
    	System.err.println("Wrong message for email already exist");
    }
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
         //===========invalid email formats========================
   //case1
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user3");
    Thread.sleep(2000);
    String actual_mssg7=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String expected_mssg7="Please enter a valid email address.";
    if(actual_mssg7.equals(expected_mssg7))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for email already exist");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    //case2
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("gmail.com");
    Thread.sleep(2000);
    String a1=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String e1="Please enter a valid email address.";
    if(a1.equals(e1))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for email already exist");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    //case3
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user3@user@gmail.com");
    Thread.sleep(2000);
    String a2=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String e2="Please enter a valid email address.";
    if(a2.equals(e2))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for email already exist");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    //case4
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user3%user#@gmail.com");
    Thread.sleep(2000);
    String a3=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String e3="Please enter a valid email address.";
    if(a3.equals(e3))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for special character in the email.");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    //case5
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user3'abc'email@domain.com");
    Thread.sleep(2000);
    String a4=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String e4="Please enter a valid email address.";
    if(a4.equals(e4))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for single quotes in email.");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    //case6
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user3..@gmail.com");
    Thread.sleep(2000);
    String a5=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String e5="Please enter a valid email address.";
    if(a5.equals(e5))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for invalid email if there are dots before @");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    //case7
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user367@gmail..com");
    Thread.sleep(2000);
    String a6=driver.findElement(By.xpath("//*[@id='email2-error']")).getText();
    String e6="Please enter a valid email address.";
    if(a6.equals(e6))
    {
    	System.out.println("Please enter a valid email address.");
    }
    else
    {
    	System.err.println("Wrong message for INVALID email format if there are two or more dots with domain extension");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='email2']")).clear();
    Thread.sleep(2000);
    
    //=================valid email format==================================
    driver.findElement(By.xpath("//*[@id='email2']")).sendKeys("user211@gmail.com");
    
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//*[@id='password2']")).sendKeys("user");
    
    Thread.sleep(2000);
    
    String actual_mssg8=driver.findElement(By.xpath("//*[@id='password2-error']")).getText();
    String expected_mssg8="Password must be at least 6 characters long.";
    if(actual_mssg8.equals(expected_mssg8))
    {
    	System.out.println("Password must be at least 6 characters long.");
    }
    else
    {
    	System.err.println("wrong message for password character limit");
    }
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='password2']")).clear();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='password2']")).sendKeys("user@123");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='pwd3']")).sendKeys("user1");
    Thread.sleep(2000);
    String actual_mssg9=driver.findElement(By.xpath("//*[@id='pwd3-error']")).getText();
    String expected_mssg9="Please enter the same password as above.";
    if(actual_mssg9.equals(expected_mssg9))
    {
    	System.out.println("Please enter the same password as above.");
    }
    else
    {
    	System.err.println("Wrong message for confirm password.");
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='pwd3']")).clear();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='pwd3']")).sendKeys("user@123");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='register']/div[6]/label/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Terms of Service")).click();
    Thread.sleep(2000);
    String parentWindowHandle = driver.getWindowHandle();
    driver.switchTo().window(parentWindowHandle);
    Thread.sleep(2000);
    driver.findElement(By.linkText("Privacy Policy")).click();
    Thread.sleep(2000);
    driver.switchTo().window(parentWindowHandle);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='register']/button")).click();
    Thread.sleep(2000);
    
   }
    
}
