package com.kpmg.advance;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo4ShadowRoot {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://www.royalcaribbean.com/account/signin");
		
//		page.locator("css=button[aria-label='Create an account']").click();
//		page.locator("text=Create an account").click();
		
		page.getByText("Create an account").nth(1).click();
		
		page.locator("css=input[name='firstname']").fill("jack");
		
		
		//fill the form
		page.waitForTimeout(5000);
		playwright.close();
	}

}
