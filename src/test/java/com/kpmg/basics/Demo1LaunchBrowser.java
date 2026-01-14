package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1LaunchBrowser {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(); // kind of profile in browser
		Page page = context.newPage(); // tab 1

		page.navigate("https://www.facebook.com/");

		String actualTitle = page.title();
		System.out.println(actualTitle);
		
		//get url and print it 
		System.out.println(page.url());
		
		//get pagesource and print it 
		System.out.println(page.content());
		
		page.waitForTimeout(5000);
		
		//launch new browser 
//		Browser browser2= playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
//		//new context for that browser
//		BrowserContext browser2context1= browser2.newContext();
//		//new page (tab) in that context and navigate to google.com 
//		Page browser2context1Page1= browser2context1.newPage();
//		browser2context1Page1.navigate("https://www.google.com/");
//		
//		System.out.println(browser2context1Page1.title());
		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
