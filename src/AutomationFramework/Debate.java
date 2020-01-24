package AutomationFramework;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Debate
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
	    Thread.sleep(4000);
		
		driver.get("https://stage.sided.co/");
		Thread.sleep(4000);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	    Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
	   // driver.findElement(By.xpath("//*[@href='#']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		Thread.sleep(4000);
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
	//	Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"modalStartDebate\"]/div/div/div/button")).click();
	}
	
	@Test (dependsOnMethods= {"login"})
	public void create_debate() throws InterruptedException
	{
		
		
		Thread.sleep(8000);
		//driver.findElement(By.name("thesis")).sendKeys("This is a question text.");
		driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[1]/div[1]/div/textarea")).sendKeys("Which county did Ravi Shastri play for?");
		Thread.sleep(4000);
		driver.findElement(By.name("sides[0][text]")).sendKeys("Glamorgan");
		Thread.sleep(4000);
		driver.findElement(By.name("sides[1][text]")).sendKeys("Leicestershire");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div/form/div/div[1]/div[2]/div[2]/label")).click();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[1]/div[3]/div/div[2]/div[1]")).sendKeys(" NASA has finally selected a sample collection site on asteroid Bennu after the arrival of OSIRIS-REx spacecraft in December 2018. The OSIRIS-Rex mission team has selected the site designated Nightingale, which is located in a crater high in Bennu's northern hemisphere. The team has also selected site Osprey of Bennu as a backup sample collection site.");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[2]/div[3]/div/div/div[1]/label")).click();
	    //driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[2]/div[5]/label")).click();
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//*[@class='btn btn-default btn-green']")).click();
	    Thread.sleep(4000);
		}

  
//	@Test (dependsOnMethods= {"create_debate"})
//	
//	public void test3()
//	{
//		driver.findElement(By.xpath("//*[@class='fas fa-share-alt share-icon']")).click();
//		driver.findElement(By.xpath("//*[@data-label='facebook']")).click();
//		
//	
//		String parent=driver.getWindowHandle();
//		Set<String>s1=driver.getWindowHandles();
//		Iterator<String> I1= s1.iterator();
//		while(I1.hasNext())
//		{
//		  String child_window=I1.next();
//		  if(!parent.equals(child_window))
//		  {
//		    driver.switchTo().window(child_window);
//		    System.out.println(driver.switchTo().window(child_window).getTitle());
//		    driver.findElement(By.id("email")).sendKeys("aileenmulack@gmail.com");
//		   
//		    driver.findElement(By.id("pass")).sendKeys("aileen123");
//		    
//		    driver.findElement(By.id("loginbutton")).click();
//		    
//		    driver.findElement(By.name("__CONFIRM__")).click();
//		    driver.close();
//		  }
//		}
//		driver.switchTo().window(parent);
//		System.out.println(driver.switchTo().window(parent).getTitle());
//		
//	}
//	
  
  

}
