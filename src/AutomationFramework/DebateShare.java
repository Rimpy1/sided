package AutomationFramework;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DebateShare 
{
	public WebDriver driver;
   @Parameters({"browser"})
	@Test
  public void login(String browser) throws InterruptedException 
  {
	   
      System.setProperty("webdriver.gecko.driver","F:/selenium stuff/geckodriver.exe");
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
	  
	    Thread.sleep(6000);
	    driver.get("https://www.linkedin.com/"); 
	    Thread.sleep(4000);
	  	 driver.findElement(By.xpath("/html/body/nav/a[3]")).click();
	  	 driver.findElement(By.id("username")).sendKeys("johanmulack@gmail.com");
	  	   
	  	 driver.findElement(By.id("password")).sendKeys("johan123");
	  	   
	  	 driver.findElement(By.xpath("//*[@type='submit']")).click();
	    
		driver.get("https://stage.sided.co/");
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	    Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
	   // driver.findElement(By.xpath("//*[@href='#']")).click();
	    Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div/button")).click();
	}
	  
   @Test (dependsOnMethods= {"login"})
 
  public void debate_share_on_FB() throws InterruptedException
  {
 System.out.println("Share debate on facebook");
  Thread.sleep(3000);  
  driver.findElement(By.xpath("//*[@class='fas fa-share-alt share-icon']")).click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//*[@data-label='facebook']")).click();
	

	String parent=driver.getWindowHandle();
	Set<String>s1=driver.getWindowHandles();
	Iterator<String> I1= s1.iterator();
	while(I1.hasNext())
	{
	  String child_window=I1.next();
	  if(!parent.equals(child_window))
	  {
	    driver.switchTo().window(child_window);
	    System.out.println(driver.switchTo().window(child_window).getTitle());
	    Thread.sleep(3000);
	    driver.findElement(By.id("email")).sendKeys("aileenmulack@gmail.com");
	    Thread.sleep(3000);
	    driver.findElement(By.id("pass")).sendKeys("aileen123");
	    Thread.sleep(3000);
	    driver.findElement(By.id("loginbutton")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.name("__CONFIRM__")).click();
	    Thread.sleep(3000);
	    
	  }
	}
	driver.switchTo().window(parent);
	System.out.println(driver.switchTo().window(parent).getTitle());
	
}
  @Test (dependsOnMethods= {"debate_share_on_FB"})
 
  public void debate_share_on_twitter() throws InterruptedException
  {
	 System.out.println("Share debate on Twitter.");
	 Thread.sleep(3000); 
	// driver.findElement(By.xpath("//*[@class='fas fa-share-alt share-icon']")).click();
	 //Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@data-label='twitter']")).click();
	  String parent=driver.getWindowHandle();
		Set<String>s2=driver.getWindowHandles();
		Iterator<String> I2= s2.iterator();
		while(I2.hasNext())
		{
		  String child_window=I2.next();
		  if(!parent.equals(child_window))
		  {
		    driver.switchTo().window(child_window);
		    System.out.println(driver.switchTo().window(child_window).getTitle());
		    Thread.sleep(6000); 
		    driver.findElement(By.xpath("//*[@id='username_or_email']")).sendKeys("josanmulack@gmail.com");
		    Thread.sleep(3000); 
		    driver.findElement(By.id("password")).sendKeys("mulack123");
		    Thread.sleep(3000); 
		    driver.findElement(By.xpath("//*[@value='Log in and Tweet']")).click();
		    Thread.sleep(3000); 
//		    driver.findElement(By.id("status")).sendKeys("This is debate text");
//		    Thread.sleep(3000); 
		    driver.findElement(By.xpath("//*[@value='Tweet']")).click();
		    Thread.sleep(3000);
		    
		   
		    
		  }
		
		 
		driver.switchTo().window(parent);
		System.out.println(driver.switchTo().window(parent).getTitle());
		
  }}
  
		  

		@Test (dependsOnMethods= {"debate_share_on_twitter"})
		public void debate_share_on_linkedin() throws InterruptedException,org.openqa.selenium.NoSuchFrameException, org.openqa.selenium.WebDriverException
		{
		   
			System.out.println("Share debate on linkedin");	
			Thread.sleep(4000);
			
//			driver.findElement(By.xpath("//*[@class='fas fa-share-alt share-icon']")).click();
//			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@data-label='linkedin']")).click();
		
		
		Thread.sleep(4000);
		Set<String>s3=driver.getWindowHandles();
		Iterator<String> I3= s3.iterator();
		while(I3.hasNext())
		{
		  String parent=driver.getWindowHandle();
		  String child_window=I3.next();
		  if(!parent.equals(child_window))
		  {
		    driver.switchTo().window(child_window);
		    System.out.println(driver.switchTo().window(child_window).getTitle());
//		    WebDriverWait wait = new WebDriverWait(driver, 20);
//	        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		    //driver.findElement(By.xpath("//*[@class='sign-in-link']")).click();
		    
		    Thread.sleep(10000);
//           driver.findElement(By.tagName("iframe"));
//    
//           driver.switchTo().frame("iframe");
//		   
//            driver.findElement(By.partialLinkText("Sign")).click();
//		    Thread.sleep(4000);
//		    driver.findElement(By.xpath("//*[@id=\"uno-reg-join\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/p/a")).click();
//		    driver.findElement(By.id("username")).sendKeys("johanmulack@gmail.com");
//		   
//		    driver.findElement(By.id("password")).sendKeys("johan123");
//		   
//		    driver.findElement(By.xpath("//*[@type='submit']")).click();
		    
		    driver.findElement(By.xpath("//*[@class='artdeco-button artdeco-button--2 artdeco-button--tertiary ember-view']")).click();
		    
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@data-control-name='share.post']")).click();
		    Thread.sleep(3000);
		    
		  }
		
		driver.switchTo().window(parent);
		System.out.println(driver.switchTo().window(parent).getTitle());
		
		}}
       }
  
  
  
  


