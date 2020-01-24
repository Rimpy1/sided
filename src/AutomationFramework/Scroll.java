package AutomationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scroll 
{
 public WebDriver driver;
 @Test
	void f1() throws InterruptedException
{
	 System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://stage.sided.co/");
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Log in")).click();
	    //driver.findElement(By.xpath("//*[@href='#']")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(5000);
//		WebElement wb=driver.findElement(By.xpath("//*[@id=\"Featured-Debates\"]"));
//		 while(wb.isDisplayed())
//	    {
//			//Thread.sleep(5000);
//	    JavascriptExecutor js = ((JavascriptExecutor) driver);
//	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    Thread.sleep(2000);
//	    }
//		
	   
	  }
 @Test (dependsOnMethods= {"f1"})
 void f2() throws InterruptedException, AWTException 
 {
	 /*Thread.sleep(3000);
	 WebElement wb=driver.findElement(By.xpath("//*[@id=\"Featured-Debates\"]"));
	 while(wb.isDisplayed())
	    {
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	    Thread.sleep(2000);
	    }
	    */
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@class=\"far fa-bookmark\"]")).click();
	 Thread.sleep(3000);
	 /*driver.findElement(By.xpath("//*[@class=\"hide-report-section\"]")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@class=\"edit-debate\"]")).click();
	 Thread.sleep(3000);
	 WebElement e=driver.findElement(By.xpath("//*[@name=\"thesis\"]"));
	 Thread.sleep(3000);
	 Actions action=new Actions(driver);
	 Thread.sleep(3000);
	 action.keyDown(e, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	 Thread.sleep(3000);
	 action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(e,Keys.CONTROL).perform();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@id=\"modalEditDebate\"]/div/div/div/button")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@data-tab-id=\"USER_FOLLOWED_DEBATE\"]")).click();
	 Thread.sleep(3000);
	 Robot robot=new Robot();
	 Thread.sleep(3000);
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 Thread.sleep(3000);
	 robot.keyPress(KeyEvent.VK_F);
	 Thread.sleep(3000);
	 robot.keyPress(KeyEvent.VK_V);
	 Thread.sleep(3000);
	 */
	 
	 
	 
	 
 }
	
	
}
