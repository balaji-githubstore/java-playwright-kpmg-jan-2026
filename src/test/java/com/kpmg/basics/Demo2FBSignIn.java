package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo2FBSignIn {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(); // kind of profile in browser
		Page page = context.newPage(); // tab 1

		page.navigate("https://www.facebook.com/");
		
		page.locator("xpath=//input[@id='email']").fill("hello2232343434343@gmail.com");
	
		page.locator("xpath=//input[@id='pass']").fill("welcom222");
		
		page.locator("xpath=//button[@name='login']").click();
		
		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
