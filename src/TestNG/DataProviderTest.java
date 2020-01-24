package TestNG;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.annotations.DataProvider;
 
import org.testng.annotations.Test;
 
public class DataProviderTest {
 
	private static WebDriver driver;
 
  @DataProvider(name = "Authentication")
 
  public static Object[][] credentials() {
 
        return new Object[][] { { "user3@mailinator.com", "user123" }, { "user2@mailinator.com", "user123" }};
 
  }
 
  // Here we are calling the Data Provider object with its Name
 
  @Test(dataProvider = "Authentication")
 
  public void test(String sUsername, String sPassword) throws InterruptedException 
  {
 
	  System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
	  
     driver = new ChromeDriver();
 
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      
      driver.get("https://stage.sided.co/");
 
      driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
      
      driver.findElement(By.xpath("//*[@href='#']")).click();
      
     
  	driver.findElement(By.xpath("//*[@id='email']")).sendKeys(sUsername);
 
	Thread.sleep(4000);
 
  	driver.findElement(By.id("pwd")).sendKeys(sPassword);
 
     
 
  	Thread.sleep(4000);
  	driver.findElement(By.xpath("//*[@id='login']/button")).click();
 
    System.out.println("Login Successfully");
 
 
  }
 
}