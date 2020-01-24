package TestNG;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class ValidationofInputfield {
 
	public static void main(String[] args) throws InterruptedException {
 
		System.setProperty("webdriver.chrome.driver", "F:/selenium stuff/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\amodm\\Downloads\\OnlyNumber.html");
 
		// Locating firstname web element
		WebElement numberField = driver.findElement(By.name("quantity"));
 
		/************************** Way 1 ********************************/
		// Type alphabets
		numberField.sendKeys("ASSDuiouoi");
 
		// Retrieve typed value
		String typedValue = numberField.getAttribute("value");
 
		// Get the length of typed value
		int size = typedValue.length();
 
		if (size == 0) {
			System.out.println("Alphabets are not allowed.");
		}
 
		// Type special Characters
		numberField.clear();
		numberField.sendKeys("#%$%&");
 
		// Retrieve typed value
		String typedValue1 = numberField.getAttribute("value");
 
		// Get the length of typed value
		int size1 = typedValue1.length();
 
		if (size1 == 0) {
			System.out.println("Special characters are not allowed.");
		}
 
		/************************** Way 2 ********************************/
		// Get type attribute of input box
		String typeAttributeValue = numberField.getAttribute("type");
 
		if (typeAttributeValue.equals("number")) {
			System.out.println("Only valid numbers are allowed.");
		}
		else
			System.out.println("There is no restriction of Only numbers.");
 
 
		// Closing driver
		driver.quit();
 
	}
}