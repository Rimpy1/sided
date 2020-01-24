package SeleniumGrid;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.MalformedURLException;
import java.net.URL;
 
public class TestGrid {
 public static WebDriver driver;
 
 public static void main(String[]  args) throws MalformedURLException, InterruptedException{
 
 String URL = "https://stage.sided.co/";
 String Node = "http://10.0.0.139:5555/wd/hub";
 DesiredCapabilities cap = DesiredCapabilities.chrome();
 cap.setPlatform(Platform.WIN8_1);
 driver = new RemoteWebDriver(new URL(Node), cap);
 driver.navigate().to(URL);
 Thread.sleep(5000);
 driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
 Thread.sleep(5000);
 driver.findElement(By.xpath("//*[@href='#']")).click();
 Thread.sleep(5000);
 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");driver.findElement(By.id("pwd")).sendKeys("user123");
Thread.sleep(4000);
driver.findElement(By.xpath("//*[@id='login']/button")).click();
Thread.sleep(5000);
System.out.println("Login Successfully");

 driver.quit();
 } 
}