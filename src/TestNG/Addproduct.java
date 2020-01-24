package TestNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class Addproduct {
 
    public static WebDriver driver;
    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = System.getProperty("F:/eclipse 2019/Sided2019/" + "src/testdata/LoginTestData.xlsx");
    public static String SheetName= "login";
    
    
   @BeforeSuite
    public void OpenBrowser() throws InterruptedException
 
    {
    	System.setProperty("webdriver.chrome.driver","F:/selenium stuff/chromedriver.exe");
 	   driver = new ChromeDriver(); 
  	   driver.get("https://stage.sided.co/");
  	   driver.manage().window().maximize();
  	   Thread.sleep(4000);
    }
   @Test(dataProvider="ReadVariant")
   //@Parameters({"sUsername", "sPassword"})
   public void AddVariants(String Username, String Password) throws Exception
   {
   	
   	Thread.sleep(4000);
         driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/a/span")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("//*[@href='#']")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("//*[@id='email']")).sendKeys(Username);
         Thread.sleep(4000);
        driver.findElement(By.id("pwd")).sendKeys(Password);
    
        Thread.sleep(4000);
     	driver.findElement(By.xpath("//*[@id='login']/button")).click();
        System.out.println("Login Successfully");
        
        Thread.sleep(4000);
   }
    @DataProvider
    public static Object[][] ReadVariant() throws IOException, InterruptedException
    {

    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        HSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
        
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                HSSFRow row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }
			return Data;
    }
    
    }
