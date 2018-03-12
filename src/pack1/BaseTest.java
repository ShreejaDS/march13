package pack1;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

import generic.AL;
import generic.IAutoConst;


public class BaseTest implements IAutoConst {
	
	public WebDriver d;
	//int c=1;
//	static
//	{
//				
//			System.setProperty(C_K,C_V);
//			System.setProperty(G_K,G_V);
//		
//	}
//	
	@Parameters({"b","ip"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional ("chrome")String browser,@Optional ("localhost")String ip)
			throws Exception
	{
		System.out.println(ip);
		URL ra=new URL("http://"+ip+":4444/wd/hub");
		DesiredCapabilities dc;
		
		
		
		
		
		//System.out.println(browser+":::"+c++);
		if(browser.equals("chrome"))
		{
			dc=DesiredCapabilities.chrome();
			//System.out.println(browser+":::"+c++);
		}
		else
			
		{
			dc=DesiredCapabilities.firefox();
		}
		//System.out.println(browser+":::"+c++);
		d=new RemoteWebDriver(ra, dc);
		//System.out.println(browser+":::"+c++);
		String url=AL.getProperty(S_P,"URL");
		d.get(url);
		String sito=AL.getProperty(S_P,"ITO");
		long ITO=Long.parseLong(sito);
     	d.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult res)
	{
		String name=res.getName();
		int status=res.getStatus();
		if(status==2)
		{
			String imgpath=	AL.getPhoto(d, P_P, name);
			System.out.println(imgpath);
		}
		d.quit();
	}
}
