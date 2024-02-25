package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksOfPropertiesPage extends BasePage{
 
	public WebDriver driver;

	public BrokenLinksOfPropertiesPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
		
	   }

