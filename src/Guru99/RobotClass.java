package Guru99;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RobotClass {

	public WebDriver driver;

	@Test

	public void Loginuser() throws InterruptedException, org.openqa.selenium.WebDriverException {

		System.setProperty("webdriver.chrome.driver", "F:/selenium stuff/chromedriver.exe");
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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
		driver.findElement(By.xpath("//*[@href='#']")).click();

		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");

		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modalStartDebate\"]/div/div/div/button")).click();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = { "Loginuser" })
	public void uploadprofile() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/header/div/div[2]/div[2]/a/img")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/header/div/div[2]/div[2]/div/ul/li[1]/a")).click();

		Thread.sleep(8000);
		// driver.findElement(By.xpath("//*[@id='profile']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
		Thread.sleep(5000);
//	UploadImg.sendKeys("C:/Users/vikas.IIIPL/Desktop/Images/1mb.png");
//	 Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='upload']")).click();
//    Thread.sleep(3000);
		Robot robot = new Robot();

		
		  //Find x and y coordinates to pass to mouseMove method //1. Get the size of
		 //the current window. //2. Dimension class is similar to java Point class which
		//  represents a location in a two-dimensional (x, y) coordinate space. //But
		 // here Point point = element.getLocation() method can't be used to find the
		 // position //as this is Windows Popup and its locator is not identifiable using
		Dimension i = driver.manage().window().getSize(); 
		 System.out.println("Dimension x and y :"+i.getWidth()+" "+i.getHeight()); 
		  //3. Get the height and width of the screen 
		  int x =(i.getWidth() / 4)+ 3; 
		  int y = (i.getHeight() / 10) + 50;
		  robot.mouseMove(x,y); Thread.sleep(4000); //Clicks Left mouse button
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  System.out.println("Browse button clicked"); Thread.sleep(2000);
		  
		  //Closes the Desktop Windows popup robot.keyPress(KeyEvent.VK_ENTER);
		  System.out.println("Closed the windows popup"); Thread.sleep(1000);
		 
		
//		  robot.keyPress(KeyEvent.VK_1); // robot.keyPress(KeyEvent.VK_SHIFT);
//		  robot.keyPress(KeyEvent.VK_M); robot.keyPress(KeyEvent.VK_B);
//		  robot.keyPress(KeyEvent.VK_PERIOD); robot.keyPress(KeyEvent.VK_P);
//		  robot.keyPress(KeyEvent.VK_N); 
//		  robot.keyPress(KeyEvent.VK_G);
//		  robot.keyPress(KeyEvent.VK_ENTER);
//		  Thread.sleep(4000);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		  
		  

	}

}
