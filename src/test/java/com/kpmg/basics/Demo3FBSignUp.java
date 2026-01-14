package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.SelectOption;


public class Demo3FBSignUp {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(); // kind of profile in browser
		Page page = context.newPage(); // tab 1

		page.navigate("https://www.facebook.com/");
		
		//click on create new account
		page.locator("xpath=//a[normalize-space()='Create new account']").click();
		
		//enter firstname as john
		page.locator("xpath=//input[@name='firstname']").fill("john");
		
		//enter lastname as wick
		page.locator("xpath=//input[@name='lastname']").fill("wick");
		
		
		//20 Dec 2000
		page.locator("xpath=//select[@id='day']").selectOption(new SelectOption().setLabel("20"));
		
		page.locator("xpath=//select[@id='month']").selectOption(new SelectOption().setLabel("Dec"));
		
		//select year 2000
		page.locator("xpath=//select[@id='year']").selectOption(new SelectOption().setLabel("2000"));
		
		//click on custom radio button
		//label[text()='Custom']
		page.locator("xpath=//input[@value='-1']").click();
		
//		page.locator("xpath=//input[@id='sex']").nth(2).click();
		
		//click on submit
		page.locator("xpath=//button[@name='websubmit']").click();
		
		page.waitForTimeout(5000);
		playwright.close();
		
		
	}

}
