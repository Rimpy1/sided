package AutomationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Follow_debate {
	public WebDriver driver;

	@Test
	public void login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:/selenium stuff/chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://stage.sided.co/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
		// driver.findElement(By.xpath("//*[@href='#']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");

		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div/button")).click();
		Thread.sleep(2000);
	}

	@Test (dependsOnMethods= {"login"})
	public void follow_debate() throws InterruptedException, java.lang.IllegalArgumentException, AWTException
	{
		Thread.sleep(2000);
		String debate_title= driver.findElement(By.xpath("//*[@class='thesis ellipsis-content']")).getText();
		Thread.sleep(2000);
		System.out.println(debate_title);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"far fa-bookmark\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/ul/li[3]")).click();
		Thread.sleep(2000);
		
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    Thread.sleep(3000);
	    Actions actions=new Actions(driver);
	    Thread.sleep(3000);
	    actions.sendKeys(debate_title);
		
		
		Thread.sleep(3000);
//	actions.sendKeys(debate_title);
//		Thread.sleep(3000);
//	actions.keyDown(Keys.ENTER);
		actions.perform();
		
//	Robot robot=new Robot();
//	robot.keyPress(KeyEvent.VK_CONTROL);
//	robot.keyPress(KeyEvent.VK_F);
//	((WebElement) robot).sendKeys(debate_title);
//	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
			
	}
}
