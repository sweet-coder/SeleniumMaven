package Training.SeleniumAdvanced;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject {

	@FindBy(id="identifierId")
	public static WebElement uname;
	
	@FindBy(xpath="//span[text()='Next']")
	public static WebElement nextButton;
	
	@FindBy(xpath="//input[@name='password' and @type='password']")
	public static WebElement password;
}
