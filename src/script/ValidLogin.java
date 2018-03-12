package script;

import org.testng.annotations.Test;

import generic.XL;
import pack1.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{

	
	@Test(priority=1,groups= {"smoke","login"},enabled=false)
	public void testValidLogin()
	{
		String un=XL.getCellValue(XL_P, "sheet1", 1, 0);
		String pw=XL.getCellValue(XL_P, "sheet1", 1, 1);
		
		
		
		String etitle=XL.getCellValue(XL_P, "sheet1", 1, 2);
		
		LoginPage l=new LoginPage(d);
		l.setUN(un);
		l.setPWD(pw);
		l.clickLogin();
		
		EnterTimeTrackPage e=new EnterTimeTrackPage(d);
		System.out.println(etitle);
		e.verifyTitle(d, etitle);

		
		
		
	}


}