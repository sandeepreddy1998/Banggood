package com.qa.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Pages.BanggoodPages;

public class TestBase
{
	WebDriver driver;
	BanggoodPages bang;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void SetUp(String Browser,String Url) throws InterruptedException
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
		System.setProperty("webdriver.edge.driver", "C:\\Edge driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		} 
		else if(Browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.Firefox.driver", "C:\\Edge driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
        bang = new BanggoodPages(driver);
		driver.get(Url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void TearDown()
	{
	 driver.close();
		
	}
	public void captureScreenshot(WebDriver driver, String tr) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+tr+".png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}

}