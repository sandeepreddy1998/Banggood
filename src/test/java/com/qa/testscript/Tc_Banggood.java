package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class Tc_Banggood extends TestBase{
	    @Test(dataProvider = "getData")
	    public void SearchItem(String Itemname ) throws InterruptedException,IOException {
		SoftAssert sAssert = new SoftAssert();
		   bang.getsearchtextbox().clear();
		   bang.getsearchtextbox().sendKeys(Itemname);
		   bang.getmagnifierbutton().click();
			 String Title= driver.getTitle();
			 if(Title.contains(Itemname))
			 {
				 Reporter.log("The item is searched",true);
				 Assert.assertTrue(true);

			 }
			 else
			 {
				 captureScreenshot(driver,"SearchItem");
				 Reporter.log("The item is not searched",true);
				 Assert.assertTrue(false);
			 }

		}
		   @DataProvider
			public String[][] getData() throws IOException
			{
				String xFile = "C:\\Users\\User\\Desktop\\Java\\Banggood\\src\\test\\java\\com\\qa\\testdata\\Banggood.xlsx";
				String xSheet="Sheet1";
				int rowCount=ExcelUtility.getRowCount(xFile, xSheet);
				int cellCount =ExcelUtility.getCellCount(xFile, xSheet, rowCount);
				
				String[][] data=new String[rowCount][cellCount];
				for(int i=1;i<=rowCount;i++)
				{
					for(int j=0;j<cellCount;j++)
					{
						data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
						
					}
					
				}
				
				return data;
				
			}
		}
