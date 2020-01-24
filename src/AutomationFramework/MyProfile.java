package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MyProfile {
  
	 public WebDriver driver;
	
	 @Parameters({"browser"})
	  @Test
   
	public void Loginuser(String browser) throws InterruptedException, org.openqa.selenium.WebDriverException
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
				   try {
		                ChromeOptions options = new ChromeOptions();
		                options.addArguments("--disable-notifications");
		                driver = new ChromeDriver();
		                Thread.sleep(4000);
		                driver.get("https://stage.sided.co/");
		            } catch (Exception e) {
		                // TODO Auto-generated catch block
		                System.out.println(e);
		            }   
				   
				   
		     	  driver.manage().deleteAllCookies();
			  }
		    
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
		    //driver.findElement(By.xpath("//*[@href='#']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user5@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id=\"modalStartDebate\"]/div/div/div/button")).click();
			Thread.sleep(3000);
	}
 @Test(dependsOnMethods = {"Loginuser"})
 public void uploadprofile() throws InterruptedException
 {
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@class=\"user-profile\"]")).click();
	 Thread.sleep(4000);
	 driver.findElement(By.linkText("My Profile")).click();
	 //driver.findElement(By.xpath("/html/body/header/div/div[2]/div[2]/div/div[1]/ul/li[1]/a")).click();
	 Thread.sleep(9000);
	 //driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
	 //Thread.sleep(3000);
//	 driver.switchTo().activeElement().sendKeys("C:/Users/vikas.IIIPL/Desktop/Images/1mb.png");
	 //driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/img")).click();
	// Thread.sleep(4000);
	WebElement UploadImg=driver.findElement(By.xpath("//*[@id='profile']"));
	 Thread.sleep(9000);
	UploadImg.sendKeys("C:/Users/vikas.IIIPL/Desktop/Images/5-min[1].png");
	 Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id='upload']")).click();
    Thread.sleep(3000);
    
 }
@Test (dependsOnMethods = {"uploadprofile"})
public void uploadcoverimage() throws InterruptedException
{
   Thread.sleep(6000);
    WebElement UploadImage=driver.findElement(By.xpath("//*[@id='coverimage']"));
	Thread.sleep(9000);
	UploadImage.sendKeys("C:/Users/vikas.IIIPL/Desktop/Images/5-min[1].png");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='upload']")).click();
    Thread.sleep(3000);
}
 
// @Test (dependsOnMethods= {"uploadprofile"})
// public void f1() throws InterruptedException
// {
//	 Thread.sleep(3000);
//	WebElement nameedit= driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div[1]/div[1]/h1"));
//	nameedit.click();
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//*[@id=\"nameedit\"]")).sendKeys("useruseruseruseruseruseruseruseruseruseruseruseruseruser");
//	Thread.sleep(3000);
// }

}
