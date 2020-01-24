package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddArgumentandComments {
    
	public WebDriver driver;
	
	@Parameters({"browser"})
	@Test
  
  public void login(String browser) throws InterruptedException 
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
  driver.get("https://stage.sided.co/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  Thread.sleep(2000);
  driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
  //driver.findElement(By.xpath("//*[@href='#']")).click();
  Thread.sleep(2000);
 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	
 driver.findElement(By.id("pwd")).sendKeys("user123");
	Thread.sleep(2000);
 driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
	Thread.sleep(8000);
driver.findElement(By.xpath("/html/body/div[8]/div/div/div/button")).click();
Thread.sleep(2000);
 //driver.findElement(By.xpath("//*[@href='/debate/indian-gymnast-pranati-nayak-won-at-2019-asian-artistic-gymnastic-championship']")).click();
 driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).click();
 Thread.sleep(2000);
  }
	@Test (dependsOnMethods= {"login"})
	public void add_argument() throws InterruptedException
	{
		//WebDriver driver = new ChromeDriver();
		System.out.println("Add Argument in the debate.");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class=\"fal fa-comment-plus\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[1]/div/div[2]/div[1]")).sendKeys("This is the first argument text.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[2]/div/div/div[1]/textarea")).sendKeys("This is the citation text.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[2]/div/div/div[2]/textarea")).sendKeys("www.twitter.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/div/div/div/div[1]/label/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class=\"fal fa-comment-plus\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[1]/div/div[2]/div[1]")).sendKeys("This is the second argument text.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[2]/div/div/div[1]/textarea")).sendKeys("This is the second citation text.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[2]/div/div/div[2]/textarea")).sendKeys("www.facebook.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/div/div/div/div[2]/label/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/button")).click();
		Thread.sleep(2000);
	
	}
	
	// hide this code because invite friends in not implemented yet in new design
	/*
	@Test (dependsOnMethods= {"add_argument"})
	public void invite_friends() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-target='#modalInviteFriends']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[1]/div/div/div/input")).sendKeys("user3@mailinator.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[2]/div[1]/div[1]/div/div/div[1]/label/span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[2]/div[2]/div[1]/div/textarea")).sendKeys("This is the message text.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[2]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		
		}
		*/
	@Test (dependsOnMethods= {"add_argument"})
	public void add_comment() throws InterruptedException
	{
		System.out.println("Add comment in the argument.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-target='#modalComments']")).click();	
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@name='comment']")).sendKeys("This is the first comment");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"createComment\"]/div/button")).click();
	    Thread.sleep(2000);
	    
	}
	
	}

