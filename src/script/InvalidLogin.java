package script;

import org.testng.annotations.Test;

import generic.XL;
import pack1.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class InvalidLogin extends BaseTest{

	
	@Test(priority=2,groups= {"login"},enabled=true)
	public void testInvalidLogin()
	{
		int rc=XL.getRowCount(XL_P, "Sheet2");
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			System.out.println(i);
		String un=XL.getCellValue(XL_P, "Sheet2", i, 0);
		String pw=XL.getCellValue(XL_P, "Sheet2", i, 1);
		
	

		LoginPage l=new LoginPage(d);
		l.setUN(un);
		l.setPWD(pw);
		l.clickLogin();
		l.verifyErrorMsgDisplayed(d);
	
	
		}

	}
}
