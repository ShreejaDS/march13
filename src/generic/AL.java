package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AL {
	
	public static String getProperty(String path,String key)
	{
		String v="";
		
		try
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
			
		return v;		
		
	}
	
	public static String getPhoto(WebDriver d,String folder,String name)
	{
		TakesScreenshot ts=(TakesScreenshot)d;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dt=new Date().toString().replaceAll(":", "_");
		String path=folder+name+"_"+dt+".png";
		File dst = new File(path);
		
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		return path;
	}

}
