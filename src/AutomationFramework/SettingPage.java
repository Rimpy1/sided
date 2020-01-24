package AutomationFramework;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.firefox.FirefoxDriver;
@Listeners(utility.Listener.class)

public class SettingPage 
{
public static WebDriver driver;

@Parameters({"browser"})
@Test
public void login(String browser) throws InterruptedException
{
	ChromeOptions ops = new ChromeOptions();
    ops.addArguments("--disable-notifications");
if (browser.equalsIgnoreCase("chrome"))
{
	System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
    driver=new ChromeDriver(ops);
}
else
{
	System.getProperty("webdriver.chrome.driver", "F:/selenium stuff/geckodriver.exe");
	driver=new FirefoxDriver();
}
     
driver.get("https://stage.sided.co/");

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
Thread.sleep(3000);
driver.findElement(By.linkText("Log in")).click();
//driver.findElement(By.xpath("//*[@href='#']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user3@mailinator.com");
Thread.sleep(3000);
driver.findElement(By.id("pwd")).sendKeys("user123");
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/form/button")).click();
Thread.sleep(8000);
//driver.findElement(By.xpath("/html/body/div[8]/div/div/div/button")).click();
//Thread.sleep(3000);
driver.findElement(By.xpath("//*[@class=\"user-profile\"]")).click();
Thread.sleep(8000);
driver.findElement(By.linkText("Settings")).click();
Thread.sleep(4000);


}


@Test (dependsOnMethods= {"login"})
public void save_blankfields_on_settings_page() throws InterruptedException
{
	 WebElement name=driver.findElement(By.xpath("//*[@id=\"sname\"]"));
     WebElement susername=driver.findElement(By.xpath("//*[@id=\"susername\"]"));
     WebElement semail=driver.findElement(By.xpath("//*[@id=\"semail\"]"));
     WebElement button=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
     
     
name.clear();
Thread.sleep(4000);
susername.clear();
Thread.sleep(4000);
semail.clear();
Thread.sleep(4000);
button.click();
Thread.sleep(4000);
}

@Test (dependsOnMethods= {"save_blankfields_on_settings_page"})
//@Parameters({"Name", "Username", "Email", "Oldpass", "newpass", "confirmpass"})
//public void test1(String Name,String Username,String Email, String Oldpass, String newpass, String confirmpass) throws InterruptedException 
public void Namelimit_on_settings_page() throws InterruptedException
{
	WebElement name=driver.findElement(By.xpath("//*[@id=\"sname\"]"));
	WebElement button=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
	
  name.sendKeys("user3user3user3user3user3user3user3user3user3user3user3user3user3user3user3user3");
  Thread.sleep(4000);
  button.click();
  Thread.sleep(4000);
  String message="Name must be max 50 characters.";
  Thread.sleep(3000);
  String text=driver.findElement(By.xpath("//*[@id=\"sname-error\"]")).getText();
  Assert.assertEquals(message,text);
  Thread.sleep(4000);
  name.clear();
  Thread.sleep(4000);

  name.sendKeys("user3user3user3user3user3user3user3user3user3user3");

  Thread.sleep(4000);


}

@Test (dependsOnMethods= {"Namelimit_on_settings_page"})
public void UserNamelimit_on_settings_page() throws InterruptedException
{
	WebElement susername=driver.findElement(By.xpath("//*[@id=\"susername\"]"));
    WebElement button=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
    Thread.sleep(4000);
    susername.sendKeys("user3user3user3user3user3user3user3user3user3user3");
	 Thread.sleep(4000);
	 button.click();
	  Thread.sleep(4000);
	  String message="Username must be between 3 to 20 characters.";
	  Thread.sleep(3000);
	  String text=driver.findElement(By.xpath("//*[@id=\"susername-error\"]")).getText();
	  Assert.assertEquals(message,text);
	  Thread.sleep(4000);
	  susername.clear();
	  Thread.sleep(4000);
	  susername.sendKeys("user3user3user3user3");
     Thread.sleep(4000);
}

@Test (dependsOnMethods= {"UserNamelimit_on_settings_page"})
public void username_validation_on_settings_page() throws InterruptedException
{
//===============Check the user name is already existed or not==========
    
	WebElement susername=driver.findElement(By.xpath("//*[@id=\"susername\"]"));
    WebElement button=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
    Thread.sleep(4000);
    susername.clear();
    Thread.sleep(4000);
    susername.sendKeys("user123");
    Thread.sleep(3000);
    String actual_mssg5=driver.findElement(By.xpath("//*[@id='susername-error']")).getText();
    String expected_mssg5="This username is unavailable or already taken. Please try another.";
    Assert.assertEquals(actual_mssg5, expected_mssg5);
    Thread.sleep(3000);
    
    susername.clear();
    Thread.sleep(3000);
                //space in username
    susername.sendKeys("user 56");
    Thread.sleep(3000);
    String ac1=driver.findElement(By.xpath("//*[@id='susername-error']")).getText();
    String ec1="Use only letter, number and _.";
    Assert.assertEquals(ac1, ec1);
    Thread.sleep(3000);
    susername.clear();
    Thread.sleep(3000);
            //special charcter in username
    susername.sendKeys("user$%^&user");
    Thread.sleep(3000);
    String ac2=driver.findElement(By.xpath("//*[@id='susername-error']")).getText();
    String ec2="Use only letter, number and _.";
    Assert.assertEquals(ac2, ec2);
    Thread.sleep(3000);
    susername.clear();
    Thread.sleep(3000);
     //=======================Check valid username format==========================
    
    susername.sendKeys("user231_user23");
    Thread.sleep(3000);
    button.click();
    Thread.sleep(3000);
}

@Test (dependsOnMethods= {"username_validation_on_settings_page"})
public void email_validation_on_settings_page() throws InterruptedException
{
//Check for email ID errors.
	WebElement semail=driver.findElement(By.xpath("//*[@id=\"semail\"]"));
	semail.sendKeys("user5@mailinator.com");
    Thread.sleep(3000);
    
    String actual_mssg6=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String expected_mssg6="The email has already been taken.";
    Assert.assertEquals(actual_mssg6,expected_mssg6);
    
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
         //===========invalid email formats========================
   //case1
    semail.sendKeys("user3");
    Thread.sleep(3000);
    String actual_mssg7=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String expected_mssg7="The email must be a valid email address.";
    Assert.assertEquals(actual_mssg7,expected_mssg7);
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
    //case2
    semail.sendKeys("gmail.com");
    Thread.sleep(3000);
    String a1=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String e1="The email must be a valid email address.";
    Assert.assertEquals(a1,e1);
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
    //case3
    semail.sendKeys("user3@user@gmail.com");
    Thread.sleep(3000);
    String a2=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String e2="The email must be a valid email address.";
    Assert.assertEquals(a2,e2);
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
    //case4
    semail.sendKeys("user3%user#@gmail.com");
    Thread.sleep(3000);
    String a3=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String e3="The email must be a valid email address.";
    Assert.assertEquals(a3,e3);
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
    //case5
    semail.sendKeys("user3'abc'email@domain.com");
    Thread.sleep(3000);
    String a4=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String e4="The email must be a valid email address.";
    Assert.assertEquals(a4,e4);
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
    //case6
//    semail.sendKeys("user3..@gmail.com");
//    Thread.sleep(3000);
//    String a5=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
//    String e5="The email must be a valid email address.";
//    Assert.assertEquals(a5,e5);
//    Thread.sleep(3000);
//    semail.clear();
//    Thread.sleep(3000);
    //case7
    semail.sendKeys("user367@gmail..com");
    Thread.sleep(3000);
    String a6=driver.findElement(By.xpath("//*[@id=\"semail-error\"]")).getText();
    String e6="The email must be a valid email address.";
    Assert.assertEquals(a6,e6);
    Thread.sleep(3000);
    semail.clear();
    Thread.sleep(3000);
    
    //=================valid email format==================================
    semail.sendKeys("user211@gmail.com");
    
    Thread.sleep(3000);
}

@Test (dependsOnMethods= {"email_validation_on_settings_page"})
public void incorrect_oldpassword_on_settings_page() throws InterruptedException
{
	Thread.sleep(3000);
	driver.navigate().refresh();
	WebElement oldpassword=driver.findElement(By.xpath("//*[@id=\"spassword\"]"));
	WebElement newpassword=driver.findElement(By.xpath("//*[@id=\"schangepassword\"]"));
	WebElement confirmpassword=driver.findElement(By.xpath("//*[@id=\"sconfirmpassword\"]"));
	WebElement savebutton=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));

	//Case1: Incorrect Old Password
   
	System.out.println("Verify that the error message “Old password does not match!” should display if a user enters an incorrect password in the “Old Password” field.");
    Thread.sleep(8000);
    oldpassword.sendKeys("rimpy432");
    Thread.sleep(3000);
    savebutton.click();
    Thread.sleep(3000);
    String exp_mssg="Old password does not match!";
    Thread.sleep(4000);
    String ac_mssg=driver.findElement(By.xpath("//*[@class=\"swal-text\"]")).getText();
    Assert.assertEquals(ac_mssg, exp_mssg);
    Thread.sleep(3000);
    
    WebElement okbutton=driver.findElement(By.xpath("/html/body/div[11]/div/div[3]/div/button"));
    okbutton.click();
    
}
    
//Csse2: Check limit of password field.
@Test (dependsOnMethods= {"incorrect_oldpassword_on_settings_page"})
public void password_limit_on_settings_page() throws InterruptedException
{
	driver.navigate().refresh();
	WebElement oldpassword=driver.findElement(By.xpath("//*[@id=\"spassword\"]"));
	WebElement newpassword=driver.findElement(By.xpath("//*[@id=\"schangepassword\"]"));
	WebElement confirmpassword=driver.findElement(By.xpath("//*[@id=\"sconfirmpassword\"]"));
	WebElement savebutton=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
    Thread.sleep(3000);
    oldpassword.sendKeys("user123");
    Thread.sleep(3000);
    newpassword.sendKeys("rimpy");
    Thread.sleep(3000);
    confirmpassword.sendKeys("rimpy");
    Thread.sleep(3000);
    savebutton.click();
    Thread.sleep(3000);
    
    String exp_mssg1="Password must be at least 6 characters long.";
    Thread.sleep(3000);
    String ac_mssg1=driver.findElement(By.xpath("//*[@id=\"schangepassword-error\"]")).getText();
    Assert.assertEquals(ac_mssg1, exp_mssg1);
    
    Thread.sleep(3000);
    
    String exp_mssg2="Please enter at least 6 characters.";
    Thread.sleep(3000);
    String ac_mssg2=driver.findElement(By.xpath("//*[@id=\"sconfirmpassword-error\"]")).getText();
    Assert.assertEquals(ac_mssg2, exp_mssg2);
}
    //Case3: Check the error message if confirm password does not match with new password.
    
@Test (dependsOnMethods= {"password_limit_on_settings_page"})  
public void mismatch_passwords_on_settings_page() throws InterruptedException
{
	driver.navigate().refresh();
	WebElement oldpassword=driver.findElement(By.xpath("//*[@id=\"spassword\"]"));
	WebElement newpassword=driver.findElement(By.xpath("//*[@id=\"schangepassword\"]"));
	WebElement confirmpassword=driver.findElement(By.xpath("//*[@id=\"sconfirmpassword\"]"));
	WebElement savebutton=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
    Thread.sleep(3000);
    oldpassword.sendKeys("user123");
    Thread.sleep(3000);
    newpassword.sendKeys("rimpy123");
    Thread.sleep(3000);
    confirmpassword.sendKeys("rimpy1234");
    Thread.sleep(3000);
    savebutton.click();
    Thread.sleep(3000);
    
    String exp_mssg3="Please enter the same password as above.";
    Thread.sleep(3000);
    String ac_mssg3=driver.findElement(By.xpath("//*[@id=\"sconfirmpassword-error\"]")).getText();
    Assert.assertEquals(ac_mssg3, exp_mssg3);
    
}
    
    //Case4: Check password changes successfully after filling valid data in the fields.
   @Test (dependsOnMethods= {"mismatch_passwords_on_settings_page"})
   public void valid_password_on_settings_page() throws InterruptedException
   {
	   driver.navigate().refresh();
	   WebElement oldpassword=driver.findElement(By.xpath("//*[@id=\"spassword\"]"));
		WebElement newpassword=driver.findElement(By.xpath("//*[@id=\"schangepassword\"]"));
		WebElement confirmpassword=driver.findElement(By.xpath("//*[@id=\"sconfirmpassword\"]"));
		WebElement savebutton=driver.findElement(By.xpath("//*[@id=\"settings\"]/div[7]/button"));
    Thread.sleep(3000);
    oldpassword.sendKeys("user123");
    Thread.sleep(3000);
    newpassword.sendKeys("rimpy123");
    Thread.sleep(3000);
    confirmpassword.sendKeys("rimpy123");
    Thread.sleep(3000);
    savebutton.click();
    Thread.sleep(3000);
   
    String exp_mssg3="Your details have been successfully updated.";
    Thread.sleep(3000);
    String ac_mssg3=driver.findElement(By.xpath("//*[@class=\"swal-text\"]")).getText();
    Assert.assertEquals(ac_mssg3, exp_mssg3);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--confirm\"]")).click();
    Thread.sleep(3000);

}

  
@Test (dependsOnMethods= {"valid_password_on_settings_page"})
   public void reset_password_on_settings_page() throws InterruptedException
   {
	   driver.navigate().refresh();
	   driver.findElement(By.xpath("//*[@id=\"settings\"]/div[4]/label")).click();
	   Thread.sleep(3000);
	   String exp_mssg3="Check your email for a link to reset your password.";
	   Thread.sleep(3000);
	    String ac_mssg3=driver.findElement(By.xpath("//*[@class=\"swal-text\"]")).getText();
	    Assert.assertEquals(ac_mssg3, exp_mssg3);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--confirm\"]")).click();
	    Thread.sleep(3000);
	   driver.get("https://www.mailinator.com/");
	    Thread.sleep(3000);
	    driver.manage().window().maximize();
	   driver.findElement(By.xpath("//*[@id=\"addOverlay\"]")).sendKeys("user3");
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//*[@id=\"go-to-public\"]")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.linkText("Sided Password Reset")).click();
	   Thread.sleep(3000);
	   
//	   Alert alert = driver.switchTo().alert();
//	   alert.accept();
//	   
//	   Thread.sleep(3000);
//	   driver.findElement(By.linkText("Sided Password Reset")).click();
//	   Thread.sleep(3000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   Thread.sleep(4000);
	   ((JavascriptExecutor)driver).executeScript("window.scroll(0,500);");
	   Thread.sleep(4000);
	   driver.switchTo().frame("msg_body");
       Thread.sleep(3000);
       //driver.findElement(By.xpath("//*[@target=\"_other\"]")).click();
       driver.findElement(By.linkText("Reset Password")).click();
       
	   //driver.findElement(By.xpath("//*[@href=\"https://www.mailinator.com/key/url?url=https%3A//u6524390.ct.sendgrid.net/wf/click%3Fupn%3Dxf-2B6Vcg6Gdf0mRL2Bjrwh7mVg9L49RDoqy4y-2FVPL0ftn8D98TjAawlHqhIt4fa6EpZij0G6TnC4hTOwUoRI1v6ldelO6yAl-2Bg7-2F74frhnMuPNUK3vybKjt-2FjajTpr8Su_bJbxR5Idrk37agCzCootUTxhoRtGrWfk2BU-2F3Xtgfz-2B-2FYfeTLjmz8wv9F1pye-2F92l-2Bh8EjFQzPDoPz5s3TSknHotJff01E9VepmQz9mYyFxNDcIc63S9hSlvoqSh1f0tORSEMkXViIrnxh-2F53ITEkFgXn43H9mE-2B3lFrwBAKUj326Da3lFU16N0GQFrhe2M8OsMp4ss3QVwNZ4AK2MEPEzFZf7RliEcdNiowbl-2BB0ANJoTFE1LEiP9nQwW4Bugqs\"]")).click();
	 //Finding all iframe tags on a web page
//	  driver.manage().window().maximize();
	 // driver.switchTo().frame("msg_body");
	  
	  //driver.switchTo().frame("msg_body");
//	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msg_body\"]")));
//	   Thread.sleep(3000);
//	   driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[2]/div/div/div/div/div[2]/div/div/p[4]")).click();
	
	   //driver.findElement(By.cssSelector("body/table/tbody/tr/td/div:nth-child(2)/div/div/div/div/div:nth-child(3)/div/div/p:nth-child(5)/a")).click();

//	   driver.findElement(By.xpath("document.querySelector(\"body > table > tbody > tr > td > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div > p:nth-child(5) > a\")).click();
	   Thread.sleep(3000);
	   String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		  String child_window=I1.next();
		  if(!parent.equals(child_window))
		  {
	   Thread.sleep(3000);
	   driver.switchTo().window(child_window);
	   System.out.println(driver.switchTo().window(child_window).getTitle());
	   Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"rpassoword\"]")).sendKeys("user123");
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"rcomfirmpassoword\"]")).sendKeys("user123");
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"resetpassword\"]/div[2]/button")).click();
       Thread.sleep(3000);
       String actual_text=driver.findElement(By.xpath("//*[@class=\"swal-text\"]")).getText();
       String expected_text="Password changed successfully.";
       Assert.assertEquals(actual_text, expected_text);
       Thread.sleep(4000);
       driver.findElement(By.xpath("//*[@class=\"swal-button swal-button--confirm\"]")).click();
       Thread.sleep(3000);
		  }
   driver.switchTo().window(parent);
   System.out.println(driver.switchTo().window(parent).getTitle());
   }
		driver.switchTo().frame("msg_body");
	      Thread.sleep(3000);
	       //driver.findElement(By.xpath("//*[@target=\"_other\"]")).click();
	      driver.findElement(By.linkText("Reset Password")).click();
	      Thread.sleep(3000);
   
   }
   
  }

