package Training.SeleniumAdvanced;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest2 {
  @Test(priority=1, description="login", alwaysRun=false)
  public void f() {
	  System.out.println("in test method 2");
  }
  @Test(priority=3)
  public void f1() {
	  System.out.println("in test 2 method 2");
	  try {
		  int a,b=10,c=0;
		  a=b/c;
	  }
	  catch(Exception e)
	  {
		  throw e;
	  }
  }
  @Test(priority=2)
  public void f2() {
	  System.out.println("in test 3 method 2");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("in before test 2");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("in after test 2");
  }

}
