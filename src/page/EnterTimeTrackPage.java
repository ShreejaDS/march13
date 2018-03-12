package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	
	@FindBy(xpath="//span[contains(.,'Help')]")
	private WebElement help;
	
	@FindBy(id="focusLink1")
	private WebElement version;
	@FindBy(xpath="//img[@class='close']")
	private WebElement closeBtn;
	@FindBy(id="logoutLink")
	private WebElement lgout;
	@FindBy(linkText="About your actiTIME")
	private WebElement abtActiTime;
	
	public EnterTimeTrackPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	public void clickLogout()
	{
		lgout.click();
	}
	public void clickHelp()
	{
		help.click();
		
	}
	public void clickAbtActiTime()
	{
		abtActiTime.click();
	}
	public void clickCloseBtn()
	{
		closeBtn.click();
	}
	public void verifyTitle(WebDriver d,String etitle)
	{
		WebDriverWait wait=new WebDriverWait(d, 10);
		
		try
		{
			wait.until(ExpectedConditions.titleIs(etitle));
			Reporter.log("pass:HomePage is Displayed",true);
		}
		catch(Exception e)
		{
			
			Reporter.log("fail:HomePage is not Displayed",true);
			Assert.fail();
	
		}
	
	}
	public void verifyVersion(String eversion)
	{
		String aversion=version.getText();
		if(aversion.equals(eversion))
		{
			Reporter.log("pass:versions equal",true);
		}
		else
		{
			Reporter.log("fail:versions are not equal",true);
		}
		//Assert.assertEquals(aversion, eversion);
	}
	

}
