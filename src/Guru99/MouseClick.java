package Guru99;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class MouseClick 
{
 	@Test
	public void main()
	{
	System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
	 WebDriver  driver = new ChromeDriver();
	driver.get("http://www.facebook.com/");
	WebElement txtUsername = driver.findElement(By.id("email"));
	
	
	Actions builder = new Actions(driver);
	Action seriesOfActions = builder
		.moveToElement(txtUsername)
		.click()
		.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "hello")
		.keyUp(txtUsername, Keys.SHIFT)
		.doubleClick(txtUsername)
		.contextClick()
		.build();
		
	seriesOfActions.perform() ;

	}
	
	@Test
	public void dragdrop()
	{
		System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
		 WebDriver  driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		// It is always advisable to Maximize the window before performing DragNDrop action 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		 //Actions class method to drag and drop 
		 Actions builder = new Actions(driver);
		 
		 WebElement from = driver.findElement(By.id("draggable"));
		 
		 WebElement to = driver.findElement(By.id("droppable")); 
		 //Perform drag and drop
		 builder.dragAndDrop(from, to).perform();
		 
		 //verify text changed in to 'Drop here' box 
		 String textTo = to.getText();
		 
		 if(textTo.equals("Dropped!")) 
		 {
		 System.out.println("PASS: Source is dropped to target as expected");
		 }
		 else 
		 {
		 System.out.println("FAIL: Source couldn't be dropped to target as expected");
		 }
	}
	@Test
	public void draganddropby() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
		 WebDriver  driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		// It is always advisable to Maximize the window before performing DragNDrop action 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		 //Actions class method to drag and drop 
		 Actions builder = new Actions(driver);
		 
		 WebElement from = driver.findElement(By.id("draggable"));
		 
		 WebElement to = driver.findElement(By.id("droppable")); 
		 //Perform drag and drop
		 builder.dragAndDropBy(from, 150, 250).perform();
		 
		 //verify text changed in to 'Drop here' box 
		 String textTo = to.getText();
		 
		 if(textTo.equals("Dropped!")) 
		 {
		 System.out.println("PASS: Source is dropped to target as expected");
		 }
		 else 
		 {
		 System.out.println("FAIL: Source couldn't be dropped to target as expected");
		 }	
		 builder.contextClick();
		 Thread.sleep(5000);
		 builder.release();
		 
		 
	}
	
	@Test
	public void mousehover()
	{
		System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
		 WebDriver  driver = new ChromeDriver();
		 driver.get("https://www.toolsqa.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 WebElement tutorial=driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/a/span/span"));
		 Actions actions=new Actions(driver);
		 actions.moveToElement(tutorial).perform();
		 
		 
	}
	
	@Test
	public void tooltip()
	{
		System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
		 WebDriver  driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		//============Case 1 ==============================================================
		 driver.get("http://demoqa.com/tooltip/");
		 driver.manage().window().maximize();
		// Get element for which we need to find tooltip 
			WebElement ageTextBox = driver.findElement(By.id("age"));

			//Get title attribute value 
			String tooltipText = ageTextBox.getAttribute("title"); 
			
			System.out.println("Retrieved tooltip text as :"+tooltipText); 
			
			//Verification if tooltip text is matching expected value 
			if(tooltipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")){ 
				System.out.println("Pass : Tooltip matching expected value");
				}
			else{ 
				System.out.println("Fail : Tooltip NOT matching expected value"); 
			} 
		 
		 
		 //================Case 2===========================================================
		 
		 driver.get("http://demoqa.com/tooltip-and-double-click/"); 
		 
		 System.out.println("demoqa webpage Displayed"); 
		 
		 //Maximise browser window 
		 driver.manage().window().maximize(); 
		 
		 //Instantiate Action Class 
		 Actions actions = new Actions(driver); 
		 
		 //Retrieve WebElement 
		 WebElement element = driver.findElement(By.id("tooltipDemo")); 
		 
		 // Use action class to mouse hover 
		 actions.moveToElement(element).perform(); 
		 
		  String toolTip = driver.findElement(By.cssSelector(".tooltiptext")).getText(); 
		 
		 // To get the tool tip text and assert 
		// String toolTipText = toolTip.getText();
		 System.out.println("toolTipText-->"+toolTip); 
		 
		 //Verification if tooltip text is matching expected value 
		 if(toolTip.equalsIgnoreCase("We ask for your age only for statistical purposes."))
		 { 
		 System.out.println("Pass* : Tooltip matching expected value");
		 }
		 else
		 {
		 System.err.println("Fail : Tooltip NOT matching expected value"); 
		 } 
		  } 
	}
	
	
	
	
	
	

