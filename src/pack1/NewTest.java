package pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	  WebDriver d=new ChromeDriver();
	  d.close();
  }
}
