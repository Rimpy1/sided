package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Voting_functionality 
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
	     Thread.sleep(3000);
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
		
  
  }
	
	@Test (dependsOnMethods= {"login"})
	public void check_votepopup_socaillink() throws InterruptedException
	{
		//hide debates I've voted in from content settings
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"fas fa-ellipsis-v\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content-setting-form\"]/div/div/div/div[2]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content-setting-form\"]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).click();
	 Thread.sleep(2000);
driver.findElement(By.xpath("//*[@class=\"fal fa-check-square\"]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"vote-modal\"]/div/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li[1]/a/i")).click();
Thread.sleep(3000);
String parent=driver.getWindowHandle();
driver.switchTo().window(parent);
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='vote-modal']/div/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li[2]/a/i")).click();
Thread.sleep(3000);
String parent1=driver.getWindowHandle();
driver.switchTo().window(parent1);
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='vote-modal']/div/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li[3]/a/i")).click();
Thread.sleep(3000);
String parent2=driver.getWindowHandle();
driver.switchTo().window(parent2);
Thread.sleep(2000);

}
	@Test (dependsOnMethods= {"check_votepopup_socaillink"})
	public void post_argument_from_votepopup() throws InterruptedException
	{
	Thread.sleep(2000);
	WebElement wb=driver.findElement(By.xpath("//*[@id='votecreateArgument']/div/div[1]/div/div/div[2]/div[1]"));
	Thread.sleep(3000);
	wb.sendKeys("This is the argument posted from the vote popup");
	Thread.sleep(3000);
	Actions actions = new Actions(driver);
	actions.keyDown(wb, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"votecreateArgument\"]/div/div[1]/div/div/div[1]/span[1]/button[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"votecreateArgument\"]/div/div[1]/div/div/div[1]/span[1]/button[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"votecreateArgument\"]/div/div[1]/div/div/div[1]/span[1]/button[3]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"votecreateArgument\"]/div/div[1]/div/div/div[1]/span[2]/button[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='votecreateArgument']/div/div[2]/button")).click();
	Thread.sleep(3000);
}
	
@Test (dependsOnMethods= {"post_argument_from_votepopup"})
public void check_votepopup_closebutton() throws InterruptedException
{
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/header/div/div[1]/a[1]/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@class=\"fal fa-check-square\"]")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@id=\"vote-modal\"]/div/div/div/div[1]/button")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/header/div/div[1]/a[1]/img")).click();
	 Thread.sleep(2000);
	 //show debates I've voted in from the content settings
	 driver.findElement(By.xpath("//*[@class=\"fas fa-ellipsis-v\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"content-setting-form\"]/div/div/div/div[2]/label")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"content-setting-form\"]/div/div/button")).click();
	Thread.sleep(2000);
}

 


	
}