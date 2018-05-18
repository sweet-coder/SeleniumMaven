package Training.SeleniumAdvanced;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ExcelUtility;

public class LoginTestMe {
	private WebDriver driver;
  @Test(priority=1)
  public void test_me_login() throws IOException
  {
	  ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Training_AdvanceSelenium\\testdata.xlsx");
	  TestMeObject.uname.clear();
	  TestMeObject.uname.sendKeys(ExcelUtility.getCellData(1,1));
	  TestMeObject.pass.sendKeys(ExcelUtility.getCellData(1,2));
	  TestMeObject.loginButton.click();
  }
  
  @Test(priority=2)
  public void select_category() throws InterruptedException
  {		
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Categories']")));
	  WebElement category=driver.findElement(By.xpath("//*[text()='All Categories']"));
	  Actions act=new Actions(driver);
	  act.moveToElement(category).perform();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Electronics']")));
	  act.moveToElement(driver.findElement(By.xpath("//*[text()='Electronics']"))).click().build().perform();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Head Phone']")));
	  act.moveToElement(driver.findElement(By.xpath("//*[text()='Head Phone']"))).click().build().perform();
	  Assert.assertEquals(driver.getTitle(), "Search", "Item Category is selected"); 
  }
  
  @Test(priority=3)
  public void select_item() throws InterruptedException
  {	 
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Add to cart']")));
	  driver.findElement(By.xpath("//*[text()=' Add to cart']")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
	  Assert.assertEquals(driver.getTitle(), "View Cart", "View Cart page is opened");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Checkout ']")));
	  driver.findElement(By.xpath("//*[text()='Checkout ']")).click();
	  Assert.assertEquals(driver.getTitle(), "Cart Checkout", "Cart checkout page is opened");

  }
  
  @Test(priority=4)
  public void payment() throws InterruptedException
  {		
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit' and @value='Proceed to Pay']")));
	  driver.findElement(By.xpath("//*[@type='submit' and @value='Proceed to Pay']")).click();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[@type='radio' and @value='Punjab National Bank']")));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='radio' and @value='Punjab National Bank']")));
	  driver.findElement(By.xpath("//*[@type='radio' and @value='Punjab National Bank']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Continue']")));
	  driver.findElement(By.xpath("//*[text()='Continue']")).click();
	  Assert.assertEquals(driver.getTitle(), "Payment Gateway", "Payment gateway is opened");
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
