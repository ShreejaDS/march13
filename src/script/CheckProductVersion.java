package script;

import org.testng.annotations.Test;

import generic.XL;
import pack1.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest{

	
	@Test(priority=3,groups= {"login"},enabled=false)
	public void testProductVersion()
	{
		String un=XL.getCellValue(XL_P, "sheet3", 1, 0);
		String pw=XL.getCellValue(XL_P, "sheet3", 1, 1);
		String eversion=XL.getCellValue(XL_P, "sheet3", 1, 2);
		
		
		LoginPage l=new LoginPage(d);
		l.setUN(un);
		l.setPWD(pw);
		l.clickLogin();
		
		EnterTimeTrackPage e=new EnterTimeTrackPage(d);
		try
		{
		Thread.sleep(500);
		//e.clickHelp();
		//Thread.sleep(500);
		//e.clickAbtActiTime();
		//Thread.sleep(500);
		//e.verifyVersion(eversion);
	//	Thread.sleep(500);
	//	e.clickCloseBtn();
		Thread.sleep(2000);
		e.clickLogout();
		Thread.sleep(5000);
		
		}
		catch(Exception e1)
		{
			
		}
		
	}


}
