package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class report_functionality 

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
	}
	
@Test (dependsOnMethods= {"login"})
public void check_reportpopup_blankfields() throws InterruptedException
{
	//check blankfields data from debate card report popup
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"Featured-Debates\"]/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Report")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[3]/button")).click();
	Thread.sleep(3000);
	String actual_errortext=driver.findElement(By.xpath("//*[@id=\"type-error\"]")).getText();
	String expected_errortext="The type field is required.";
	Assert.assertEquals(actual_errortext, expected_errortext);
	Thread.sleep(3000);
	String ac_reason_error=driver.findElement(By.xpath("//*[@id=\"reason-error\"]")).getText();
	String exp_reason_error="The reason field is required.";
	Assert.assertEquals(ac_reason_error, exp_reason_error);
	Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[1]/button")).click();
    Thread.sleep(3000);
 
    //check blankfields data from argument report popup
    driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//div[@class='argument-actions']//i[@class='fal fa-ellipsis-h-alt']")).click();
   Thread.sleep(2000);
   driver.findElement(By.linkText("Report")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[3]/button")).click();
	Thread.sleep(3000);
	String actual_errortext1=driver.findElement(By.xpath("//*[@id=\"type-error\"]")).getText();
	String expected_errortext1="The type field is required.";
	Assert.assertEquals(actual_errortext1, expected_errortext1);
	Thread.sleep(3000);
	String ac_reason_error1=driver.findElement(By.xpath("//*[@id=\"reason-error\"]")).getText();
	String exp_reason_error1="The reason field is required.";
	Assert.assertEquals(ac_reason_error1, exp_reason_error1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[1]/button")).click();
	Thread.sleep(3000);
   driver.findElement(By.xpath("/html/body/header/div/div[1]/a[1]/img")).click();
   Thread.sleep(2000);


}
	
@Test (dependsOnMethods= {"check_reportpopup_blankfields"})
public void report_debate() throws InterruptedException
{
	driver.findElement(By.xpath("//*[@id=\"Featured-Debates\"]/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Report")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[1]/div/ul/li[2]/label")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[2]/div/textarea")).sendKeys("This is the duplicate debate");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[3]/button")).click();
	Thread.sleep(2000);
}

@Test (dependsOnMethods= {"report_debate"})
public void report_argument() throws InterruptedException
{
	driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//div[@class='argument-actions']//i[@class='fal fa-ellipsis-h-alt']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.linkText("Report")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[1]/div/ul/li[3]/label")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[2]/div/textarea")).sendKeys("This is fake news.");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
}

}
