package Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardEvents 
{
  public WebDriver driver;
  @Test
  public void test1()
  {
	  System.setProperty("webdriver.chrome.driver", "F:/selenium stuff/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://demoqa.com/keyboard-events-sample-form/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	  
	  //==========Find WebElements==================================================
	  WebElement name=driver.findElement(By.id("userName"));
	  WebElement currentaddress=driver.findElement(By.id("currentAddress"));
	  WebElement permanentaddress=driver.findElement(By.id("permanentAddress"));
	  WebElement submit=driver.findElement(By.id("submit"));
	  
	  //===================Instantiate Actions Class==============================
	  Actions actions=new Actions(driver);
	  actions.sendKeys(name, "Rimpy").perform();
	//Enter current address 
      actions.click(currentaddress).sendKeys("1205 OAK STREET,OLD FORGE,NEW YORK,11240").perform();
 
     //Copy current address 
     actions.keyDown(currentaddress,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); 
     actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permanentaddress,Keys.CONTROL).perform();
 
    //Paste current address in permanant adderss text field
     actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
 
     //Click on Submit button
     submit.click();
 
     // Accept the Alert 
    driver.switchTo().alert().accept();
    System.out.println("Submit Alert Accepted");
	  
	  actions.click(submit);
	  
}
}
