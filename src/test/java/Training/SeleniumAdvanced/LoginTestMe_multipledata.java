package Training.SeleniumAdvanced;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtility;

public class LoginTestMe_multipledata {
	private WebDriver driver;
	private static int count=0;
	  @Test(dataProvider="logindata", priority=1)
	  public void test_me_login(String user, String pwd) throws IOException, InterruptedException
	  {
		  try 
		  {
				  
			  TestMeObject.uname.clear();
			  TestMeObject.uname.sendKeys(user);
			  TestMeObject.pass.sendKeys(pwd);
			  TestMeObject.loginButton.click();
			  String title=driver.getTitle();
			  Assert.assertEquals(title.contains("Home"),true);
			  ExcelUtility.setExcelCell(count++, 2, "Pass");
			  Thread.sleep(5000);
		  }
		  catch(AssertionError e)
		  {
			ExcelUtility.setExcelCell(count++, 2, "Fail");
		  }
		  finally
		  {
			  driver.get("http://localhost:8083/TestMeApp/login.htm");
		  }
	  }
	  
	  @Test(priority=2)
	  public void select_category()
	  {		
		  WebElement category=driver.findElement(By.xpath("//span[text()='All Categories']"));
		  Actions act=new Actions(driver);
		  act.moveToElement(category).moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).moveToElement(driver.findElement(By.xpath("//a[text()='Head Phone']"))).build().perform();
		  Assert.assertEquals(driver.getTitle(), "Search", "Item is selected");
	  }
	  
	  @DataProvider(name="logindata")
	  public String[][] login_data() throws IOException 
	  {
		  ExcelUtility.setExcelPath("Sheet2", "C:\\Users\\A06438_P5.Training\\Desktop\\Training_AdvanceSelenium\\testdata.xlsx");
		  String[][] tabledata=ExcelUtility.getExcelTable();
		  return tabledata;
		  }
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Training_AdvanceSelenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("http://localhost:8083/TestMeApp/login.htm");
		  PageFactory.initElements(driver, TestMeObject.class);
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	}
