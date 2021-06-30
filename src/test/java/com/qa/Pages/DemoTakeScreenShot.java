package com.qa.Pages;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DemoTakeScreenShot 
{

	WebDriver driver;
	@BeforeClass
	public void SetUp() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");		
	}
	@AfterClass
	public void TearDown()
	{
	 driver.close();
		
	}
	@Test(priority=1)
	public void screenshotOfElement() throws IOException
	{
		File Source = driver.findElement(By.id("nav-logo-sprites")).getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"Banggoodlogo.png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}
	@Test(priority=2)
	public void screenshotOfDriver() throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"BanggoodPage.png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}
	@Test(priority=3)
	public void screenshotOfFullPage() throws IOException
	{
		AShot SShot = new AShot();
		Screenshot Source = SShot.shootingStrategy(ShootingStrategies.viewportPasting(300)).takeScreenshot(driver);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"BanggoodFullPage.jpg";
		ImageIO.write(Source.getImage(),"jpg",new File(Dest));
		
	}
}