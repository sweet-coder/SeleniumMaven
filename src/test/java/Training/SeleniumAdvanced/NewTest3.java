package Training.SeleniumAdvanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest3 {
	private WebDriver driver;
  @Test
  public void register() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  driver.findElement(By.name("firstName")).sendKeys("Kritika");
	  driver.findElement(By.name("lastName")).sendKeys("Dwivedi");
	  driver.findElement(By.name("phone")).sendKeys("12345678");
	  driver.findElement(By.id("userName")).sendKeys("kritika@gmail.com");
	  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Planet Millenium, Pune");
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
	  driver.findElement(By.name("state")).sendKeys("Maharashtra");
	  driver.findElement(By.name("postalCode")).sendKeys("411027");
	  
	  Select country=new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");
	  
	  driver.findElement(By.cssSelector("input[name=email]")).sendKeys("kritika");
	  driver.findElement(By.cssSelector("input[name=password]")).sendKeys("kritika");
	  driver.findElement(By.cssSelector("input[name=confirmPassword]")).sendKeys("kritika");
	  driver.findElement(By.cssSelector("input[name=register]")).submit();
	  Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Training_AdvanceSelenium\\Drivers\\geckodriver-v0.20.1-win32\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.newtours.demoaut.com");
  }

  @AfterTest
  public void afterTest() {
//	  driver.quit();
  }

}
