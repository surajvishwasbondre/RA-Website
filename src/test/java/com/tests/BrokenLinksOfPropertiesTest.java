package com.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.PopupFormPage;

public class BrokenLinksOfPropertiesTest extends TestBase {

	PopupFormPage popupformpg;


	public BrokenLinksOfPropertiesTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		popupformpg=new PopupFormPage(driver);
		driver.get("https://realtyassistant.in/properties"); 
	}
	
	@Test()
	public void VerifyBrokenLinks() throws IOException 
	{

       List<WebElement>allLinks=driver.findElements(By.tagName("a"));
       System.out.println(allLinks.size());
       
    
       for (WebElement link : allLinks) {
		String url=link.getAttribute("href");
		
		
		if(url==null) {
			System.out.println("url is empty");
		}else {
			validateBrokenLinks(url);
		}

       }
	}
public static void validateBrokenLinks(String linkurl) throws IOException  {
		
		HttpURLConnection connection;
		URL url;
		try {
			url=new URL(linkurl);
			connection=(HttpURLConnection)url.openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();
			if(connection.getResponseCode()==200)
			{
				System.out.println("Valid link....Link is working");
			}else {
				System.out.println("****Broken Link*******");
				System.out.println(linkurl);
				System.out.println(connection.getResponseMessage());
				System.out.println();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
}	
}
