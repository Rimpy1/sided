package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class pre_login_functionality 
{
	public static WebDriver driver;

	@Parameters({"browser"})
	@Test 
	public void prelogin_argument_closebutton(String browser) throws InterruptedException
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
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"fal fa-comment-plus\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"modalAddArgument\"]/div/div/div/button")).click();
		Thread.sleep(3000);
		driver.quit();
	} 
	
	
	@Test
	public void prelogin_argument_post() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://stage.sided.co/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"fal fa-comment-plus\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"ql-editor ql-blank\"]")).sendKeys("This is the argument text.");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[2]/div/div/div[1]/textarea")).sendKeys("This is the citation text.");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[2]/div[2]/div/div/div[2]/textarea")).sendKeys("twitter.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/div/div/div/div[1]/label/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"createArgument\"]/div/div[3]/button")).click();
		Thread.sleep(3000);
		driver.quit();
	
	}
	//invite functionality is not implemented yet in new design
	/*
	@Test 
	public void prelogin_invite_closebutton() throws InterruptedException
	{
	 driver=new ChromeDriver();
	 driver.get("https://stage.sided.co/");
	 Thread.sleep(3000);
	driver.manage().window().maximize();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[5]/div[1]/div/div[1]/a")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	Thread.sleep(3000);
	driver.findElement(By.id("pwd")).sendKeys("user123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id=\"modalInviteFriends\"]/div/div/div/button")).click();
	Thread.sleep(3000);
	driver.quit();
	
	}
	
	@Test
	public void prelogin_invite_friend() throws InterruptedException
	{
	 driver=new ChromeDriver();
	 driver.get("https://stage.sided.co/");
	 Thread.sleep(3000);
	driver.manage().window().maximize();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[5]/div[1]/div/div[1]/a")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
	Thread.sleep(3000);
	driver.findElement(By.id("pwd")).sendKeys("user123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[1]/div/div/div/input")).sendKeys("user5@mailinator.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[2]/div[1]/div[1]/div/div/div[1]/label/span[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[2]/div[2]/div[1]/div/textarea")).sendKeys("This is the message text.");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"inviteFriendsDebate\"]/div[2]/div[1]/div[2]/button")).click();
	Thread.sleep(3000);
	driver.quit();
	
	}
	*/
	
	@Test
	public void prelogin_commentslider_close() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"open-modal-comments \"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"modalComments\"]/div/div[2]/div/button")).click();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void prelogin_comment_post() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"open-modal-comments \"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pwd")).sendKeys("user123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@name='comment']")).sendKeys("This is the first comment");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"createComment\"]/div/button")).click();
	    Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void prelogin_debatereport_closebutton() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@class=\"fas fa-ellipsis-h\"]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Report")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[1]/button")).click();
			Thread.sleep(3000);
			driver.quit();
	}
	@Test
	public void prelogin_report_on_debate() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@class=\"fas fa-ellipsis-h\"]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Report")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[1]/div/ul/li[2]/label")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[2]/div/textarea")).sendKeys("This is the duplicate debate");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"report\"]/div/div/div[2]/form/div[3]/button")).click();
			Thread.sleep(3000);
			driver.quit();
	}
	
	
	@Test
	public void prelogin_argumentreport_closebutton() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
			Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@class='argument-actions']//i[@class='fal fa-ellipsis-h-alt']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Report")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[1]/button")).click();
			Thread.sleep(3000);
			driver.quit();
	}
	@Test
	public void prelogin_report_on_arg() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@class=\"thesis ellipsis-content\"]")).click();
			Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@class='argument-actions']//i[@class='fal fa-ellipsis-h-alt']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Report")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[1]/div/ul/li[3]/label")).click();
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[2]/div/textarea")).sendKeys("This is fake news.");
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//*[@id=\"report-argument\"]/div/div/div[2]/form/div[3]/button")).click();
				Thread.sleep(3000);
			driver.quit();
	}
	
	@Test
	public void prelogin_startdebate_closebutton() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"modalStartDebate\"]/div/div/div/button")).click();
			Thread.sleep(3000);
			driver.quit();
	
	}
	@Test
	public void prelogin_startdebate() throws InterruptedException
	{
		driver=new ChromeDriver();
		 driver.get("https://stage.sided.co/");
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("/html/body/header/div/div[1]/a[2]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
			Thread.sleep(3000);
			driver.findElement(By.id("pwd")).sendKeys("user123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[1]/div[1]/div/textarea")).sendKeys("This is a new question.");
			Thread.sleep(3000);
			driver.findElement(By.name("sides[0][text]")).sendKeys("Side one");
			Thread.sleep(3000);
			driver.findElement(By.name("sides[1][text]")).sendKeys("Side two");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div/form/div/div[1]/div[2]/div[2]/label")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[1]/div[3]/div/div[2]/div[1]")).sendKeys(" NASA has finally selected a sample collection site on asteroid Bennu after the arrival of OSIRIS-REx spacecraft in December 2018. The OSIRIS-Rex mission team has selected the site designated Nightingale, which is located in a crater high in Bennu's northern hemisphere. The team has also selected site Osprey of Bennu as a backup sample collection site.");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[2]/div[3]/div/div/div[1]/label")).click();
		    //driver.findElement(By.xpath("//*[@id=\"createDebate\"]/div/div[2]/div[5]/label")).click();
		    Thread.sleep(6000);
		    driver.findElement(By.xpath("//*[@class='btn btn-default btn-green']")).click();
		    Thread.sleep(3000);
			driver.quit();
	
	}
	
	
	
	
}