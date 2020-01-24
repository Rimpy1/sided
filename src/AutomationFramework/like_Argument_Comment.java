package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class like_Argument_Comment 
{
	public WebDriver driver;
	@Test
	public void like_Arg() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   Thread.sleep(3000);
		  driver.get("https://stage.sided.co/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
		  //driver.findElement(By.xpath("//*[@href='#']")).click();
		  Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user5@mailinator.com");
		 Thread.sleep(2000);
		 driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"argument-2932\"]/div[2]/div[2]/button[1]/span[1]/i")).click();
		 Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods= {"like_Arg"})
	public void unlike_Argument() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"argument-2932\"]/div[2]/div[2]/button[1]/span[1]/i")).click();
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods= {"unlike_Argument"})
	public void like_comment() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"argument-2932\"]/div[2]/div[2]/button[2]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"comment-2871\"]/div/button/span[1]/i")).click();
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods= {"like_comment"})
    public void unlike_comment() throws InterruptedException
    {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"comment-2871\"]/div/button/span[1]/i")).click();
		Thread.sleep(2000);
		
    }
	
}
