package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Delete_Functionality 
{
	public WebDriver driver;
	
	@Test
	public void login() throws InterruptedException
	{
//	if(browser.equalsIgnoreCase("firefox")) 
//	   {
//		   System.setProperty("webdriver.gecko.driver","F:/selenium stuff/geckodriver.exe");
//	      driver = new FirefoxDriver();
//	      driver.manage().deleteAllCookies();
//	    }
//	   else if(browser.equalsIgnoreCase("chrome"))
//	   {
	 System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
  	   driver = new ChromeDriver();
  	  driver.manage().deleteAllCookies();
	 // }
	Thread.sleep(3000);
	driver.get("https://stage.sided.co/");
	Thread.sleep(3000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.findElement(By.linkText("Log in")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	Thread.sleep(3000);
	driver.findElement(By.id("pwd")).sendKeys("user123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
	Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods= {"login"})
	public void delete_comment() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
		Thread.sleep(3000);
		 
		//scroll the page
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		 js.executeScript("window.scrollTo(document.body.scrollHeight, 600)");
		 Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class=\"open-modal-comments comment\"]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div/div/div[5]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--cancel\"]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div/div/div[5]/div[1]/div/div[1]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--confirm swal-button--danger\"]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"modalComments\"]/div/div[2]/div/button")).click();
		Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods= {"delete_comment"})
	public void delete_argument() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*@[class=\"hide-report-section\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--cancel\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"fas fa-ellipsis-h\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--confirm swal-button--danger\"]")).click();
		Thread.sleep(3000);
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 Thread.sleep(3000);
		  js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		  Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods= {"delete_argument"})
	public void delete_debate() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"fa fa-ellipsis-v fa-lg\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--cancel\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"fa fa-ellipsis-v fa-lg\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--confirm swal-button--danger\"]")).click();
		Thread.sleep(3000);
	}
	
}
