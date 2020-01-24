package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class moderation_queue 

{
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
		Thread.sleep(9000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div/button")).click();
		Thread.sleep(2000);
	}
	

	
//@Test (dependsOnMethods= {"login"})
//public void report_debate() throws InterruptedException
//{
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id=\"Featured-Debates\"]/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div[2]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.linkText("Report")).click();
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[1]/div/ul/li[2]/label")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[2]/div/textarea")).sendKeys("This is the duplicate debate");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[3]/button")).click();
//	Thread.sleep(2000);
//}

@Test (dependsOnMethods= {"login"})
public void moderation_functionality() throws InterruptedException
{
	
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"user-profile\"]")).click();
Thread.sleep(3000);
driver.findElement(By.linkText("Moderation queue")).click();
Thread.sleep(3000);
//driver.findElement(By.linkText("No rules were broken")).click();
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form[1]/ul/li[1]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/ul/li[2]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"edit-report btn\"]")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[2]/input")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"edit-report btn\"]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[1]/button")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/button")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/ul/li[1]/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form[1]/ul/li[2]/label")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form[1]/div[3]/div[1]/textarea")).sendKeys("delete this debate");
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"btn btn-outline btn-green\"]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/ul/li[2]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"edit-report btn\"]")).click();
Thread.sleep(3000);
//check blank reason field 
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/div/div/textarea[1]")).clear();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[1]/button")).click();
Thread.sleep(3000);
//driver.findElement(By.xpath("//*[@value=\"save\"]")).click();
//Thread.sleep(4000);

//check error message text
String actual_message_text=driver.findElement(By.xpath("//*[@id=\"message-error\"]")).getText();
Thread.sleep(3000);
String expected_message_text="The message field is required.";
Thread.sleep(3000);
Assert.assertEquals(actual_message_text, expected_message_text);
Thread.sleep(3000);


driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/div/div/textarea[1]")).sendKeys("this is extra text");
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[1]/button")).click();
Thread.sleep(3000);


driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[3]/input")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[2]/button")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/ul/li[1]/a")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form[1]/ul/li[3]/label")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form[1]/div[3]/div[1]/textarea")).sendKeys("hide this debate");
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"btn btn-outline btn-green\"]")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/button")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li/div/ul/li[2]/a")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/div/div/textarea[1]")).clear();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[1]/button")).click();
Thread.sleep(3000);
String actl_msg_txt=driver.findElement(By.xpath("//*[@id=\"message-error\"]")).getText();
Thread.sleep(3000);
String exp_msg_txt="The message field is required.";
Thread.sleep(3000);
Assert.assertEquals(actl_msg_txt, exp_msg_txt);
Thread.sleep(3000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/div/div/textarea[1]")).sendKeys("this is new text");
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[1]/button")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[3]/input")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/ul/li[2]/button")).click();
Thread.sleep(3000);
}

}
