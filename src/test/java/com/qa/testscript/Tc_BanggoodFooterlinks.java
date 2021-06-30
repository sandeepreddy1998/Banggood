package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tc_BanggoodFooterlinks extends TestBase {
	@Test
	public void SearchItem() throws IOException
	{
		SoftAssert sAssert = new SoftAssert();
		List<WebElement> FooterLink= bang.getFooter();
		if(FooterLink.size()<1)
		{
			for(WebElement link:FooterLink)
			{
			Reporter.log(link.getText(),true);
			Assert.assertTrue(true);
			}
		}
		else
		{
			captureScreenshot(driver,"SearchItem");
			Reporter.log("Incorrect no of footer links",true);
			Assert.assertTrue(false);
		}
		
	}
}
