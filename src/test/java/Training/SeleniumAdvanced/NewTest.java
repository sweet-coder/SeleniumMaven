package Training.SeleniumAdvanced;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test(dataProvider = "login")
  public void f(String uname, String password) {
	  System.out.println(uname+" "+password);
  }

  @DataProvider(name="login")
  public String[][] dp() 
  {
//  {
//    return new String[][] {
//      new String[] { "username1", "password1" },
//      new String[] { "username2", "password2" },
//      new String[] { "username3", "password3" },
//    };
//  }
//  String data[][]={{"uname1","pass1"},
//		  		{"uname2","pass2"}};
//  return data;
	  
	  String [][] data = new String[3][2];
	  
	  data[0][0]= "user1";
	  data[0][1]= "pass1";
	  data[1][0]= "user2";
	  data[1][1]= "pass2";
	  data[2][0]= "user3";
	  data[2][1]= "pass3";
	  
	  
	  return data;
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("in before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("in after test");
  }

}
