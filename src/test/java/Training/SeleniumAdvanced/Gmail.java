package Training.SeleniumAdvanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gmail {
	private WebDriver driver;
  @Test
  public void register() {
	  LoginPageObject.uname.sendKeys("kritika@gmail.com");
	  LoginPageObject.nextButton.click();
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	  LoginPageObject.password.sendKeys("abc");
	  LoginPageObject.nextButton.click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Training_AdvanceSelenium\\Drivers\\geckodriver-v0.20.1-win32\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.gmail.com");
	  PageFactory.initElements(driver, LoginPageObject.class);
  }

  @AfterTest
  public void afterTest() {
//	  driver.quit();
  }

}
