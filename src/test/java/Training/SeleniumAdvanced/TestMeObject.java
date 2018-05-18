package Training.SeleniumAdvanced;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestMeObject {

	@FindBy(name="userName")
	 public static WebElement uname;
	
	@FindBy(name="password")
	public static WebElement pass; 
	
	@FindBy(name="Login")
	public static WebElement loginButton;
	
	@FindBy(xpath="//a[text()=' SignOut']")
	public static WebElement signout;
}
