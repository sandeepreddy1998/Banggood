package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BanggoodPages {
	WebDriver driver;
    @FindBy(xpath="//span[contains(text(),'All categories')]")

	WebElement categorybox;
	public WebElement getcategorybox(){
		return categorybox;	
	}
	@FindBy(className="//header/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/ul[1]/li")

	List<WebElement> categoryboxtext;
	public List<WebElement> getcategoryboxtext(){
		return categoryboxtext;	
	}
	
	
	    @FindBy(className="header-search")
		WebElement searchtextbox;
		public WebElement getsearchtextbox(){
			return searchtextbox;	
		}
		@FindBy(id="login-email")
		WebElement Emailbox;
		public WebElement getEmailbox(){
			return Emailbox;	
		}
		@FindBy(id="login-pwd")
		WebElement passwordbox;
		public WebElement getpasswordbox(){
			return passwordbox;	
		}
		@FindBy(id="login-pwd-show")
		WebElement showpassword;
		public WebElement getshowpassword(){
			return showpassword;	
		}
		@FindBy(id="login-submit")
		WebElement submit;
		public WebElement getsubmit(){
			return submit;	
		}
		
	   @FindBy(xpath="//header/div[2]/div[1]/div[2]/form[1]/label[1]/input[1]")	
		WebElement magnifierbutton;
		public WebElement getmagnifierbutton(){
				
			return magnifierbutton;	
			}
		
	   @FindAll(@FindBy(className="title exclick"))
	   List<WebElement> searchboxItem;
	   public List<WebElement> getsearchboxItem()
	   {
	     return searchboxItem;
	    }
	   @FindAll(@FindBy(className="price notranslate")) 
	   List<WebElement> Prices; 
	   public List<WebElement> getPrices(){
	   return Prices;
	   }
	   @FindAll(@FindBy(className="exclick")) 
		List<WebElement> Footer; 
		public List<WebElement> getFooter()
		{
		  return Footer;
		}
	   public  BanggoodPages(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
		}
		

}
