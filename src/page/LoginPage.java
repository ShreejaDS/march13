package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



public class LoginPage {

	@FindBy(name="username")
	private WebElement un;
	@FindBy(name="pwd")
	private WebElement pw;
	@FindBy(id="loginButton")
	private WebElement lgin;
	@FindBy(xpath="//div[contains(.,'invalid')]")
	private WebElement errmsg;
	
	public LoginPage(WebDriver d)
	{
		PageFactory.initElements(d,this);
	}
	public void setUN(String username)
	{
		un.clear();
		un.sendKeys(username);
	}
	public void setPWD(String pwd)
	{
		//pw.clear();
		pw.sendKeys(pwd);
	}
	public void clickLogin()
	{
		lgin.click();
		
	}
	public void verifyErrorMsgDisplayed(WebDriver d)
	{
		
//		WebDriverWait wait=new WebDriverWait(d,20);
//		
//		try
//		{
//			wait.until(ExpectedConditions.visibilityOf(errmsg));
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(errmsg.isDisplayed())
			{
				
			}
			
	//	}
	//	catch(Exception e)
		else
		{
			
			Reporter.log("fail:errmsg is not Displayed",true);
			Assert.fail();
	
		}
		//Reporter.log("pass:errmsg is Displayed",true);
	}

}
