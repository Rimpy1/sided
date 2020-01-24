package AutomationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleAnalytics 

{
	public WebDriver driver;
	
	@BeforeMethod
	public void userlogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
  	    driver = new ChromeDriver();
  	    
  	    driver.manage().deleteAllCookies();
  	  driver.get("https://stage.sided.co/");
  	  driver.manage().window().maximize();
  	  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  	  Thread.sleep(2000);
  	  driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
  	  driver.findElement(By.xpath("//*[@href='#']")).click();
  	  Thread.sleep(2000);
  	 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user1@gmail.com");
  		
  	 driver.findElement(By.id("pwd")).sendKeys("user123");
  		Thread.sleep(2000);
  	 driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
  		Thread.sleep(5000);
  	driver.findElement(By.xpath("//*[@id=\"modalStartDebate\"]/div/div/div/button")).click();
  	Thread.sleep(2000);
  	 //driver.findElement(By.xpath("//*[@href='/debate/indian-gymnast-pranati-nayak-won-at-2019-asian-artistic-gymnastic-championship']")).click();
  	driver.findElement(By.xpath("//*[@href=\'/user3/this-is-a-question-text-40\']")).click();
  	 Thread.sleep(2000);
  }
	
	@Test
  public void f() throws InterruptedException 
	{
//    for(int i=0; i<=20; i++)
//    {
//    	Thread.sleep(2000);
//    	driver.findElement(By.xpath("//*[@data-action-id='action-add-argument']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[1]/div/div[2]/div[1]")).sendKeys("This is the first argument text.");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/div/div/div/div[3]/label/span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/button")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//*[@data-action-id='action-add-argument']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[1]/div/div[2]/div[1]")).sendKeys("This is the first argument text.");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/div/div/div/div[4]/label/span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/button")).click();
//		Thread.sleep(2000);
//    }
//	for(int j=0; j<=20; j++)
//	{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@data-target='#modalComments']")).click();	
//		Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@name='comment']")).sendKeys("This is the first comment");
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"createComment\"]/div/button")).click();
//	    Thread.sleep(2000);
//	}
	driver.quit();
	}
	
//	@Test
//	public void test1() throws InterruptedException
//	{
//		
//		for(int k=0; k<=2000; k++ )
//		{
//			System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
//			Thread.sleep(2000);
//			
//			driver = new ChromeDriver();
//			driver.manage().window().setPosition(new Point(0, -1000));
//			driver.manage().deleteAllCookies();
//			driver.get("https://sided.co/");
//		  	//driver.manage().window().maximize();
//			
//			Thread.sleep(2000);
//		  	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//		  	Thread.sleep(2000);
////		  	driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
////		  	driver.findElement(By.xpath("//*[@href='#']")).click();
////		  	Thread.sleep(2000);
////		  	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
////		  	driver.findElement(By.id("pwd")).sendKeys("user123");
////		  	Thread.sleep(2000);
////		  	driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
////		  	Thread.sleep(8000);
////		  	driver.findElement(By.xpath("//*[@id=\"modalStartDebate\"]/div/div/div/button")).click();
////		  	Thread.sleep(2000);
//		  	 //driver.findElement(By.xpath("//*[@href='/debate/indian-gymnast-pranati-nayak-won-at-2019-asian-artistic-gymnastic-championship']")).click();
//		  	driver.findElement(By.xpath("//*[@href='/billybilly/who-won-the-gold-medal-in-10m-air-pistol-at-the-asian-shooting-championships-who-won-the-gold-medal-in-10m-air-pistol-at-the-asian-shooting-championships']")).click();
//		  	Thread.sleep(2000);
//			driver.quit();
//		}
//	
//	}
}
